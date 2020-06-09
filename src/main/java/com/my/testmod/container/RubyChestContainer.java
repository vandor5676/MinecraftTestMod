package com.my.testmod.container;

import com.my.testmod.items.Ruby;
import com.my.testmod.tileEntity.RubyChestTileEntity;
import com.my.testmod.util.ModContainerTypes;
import com.my.testmod.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class RubyChestContainer extends Container {
    public final RubyChestTileEntity tileEntity;
    public final IWorldPosCallable canInteractWithCallable;


    public RubyChestContainer(final int windowId, final PlayerInventory playerInventory, final RubyChestTileEntity tileEntity) {
        super(ModContainerTypes.RUBY_CHEST.get(), windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(),tileEntity.getPos());

        //Main Inventory
        int startX = 8;
        int startY = 18;
        int slotSizePlus2 = 18;
        for (int row=0;row<4;row++)
        {
            for(int column = 0;column<9;++column)
            {
            this.addSlot(new Slot(tileEntity,(row*9)+column,startX+(column*slotSizePlus2),startY  + (row*slotSizePlus2)));
            }
        }

        //Main Player Inventory
        int startPlayerInvY = startY *5+12;
        for (int row=0;row<3;row++)
        {
            for(int column = 0;column<9;++column)
            {
                this.addSlot(new Slot(playerInventory,9+ (row*9)+column,startX+(column*slotSizePlus2),startPlayerInvY  + (row*slotSizePlus2)));
            }
        }

        //Hotbar
        int hotbarY = startPlayerInvY + (startY/2) + 7;
        for (int column=0;column<9;column++)
        {
            this.addSlot(new Slot(playerInventory, column, startX+(column*slotSizePlus2),hotbarY));
        }
    }
    private static RubyChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data)
    {
        Objects.requireNonNull(playerInventory, "PlayerInventory cannot be null");
        Objects.requireNonNull(data,"data cannot be null"   );
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof RubyChestTileEntity) {
            return (RubyChestTileEntity)tileAtPos;
        }
        throw new IllegalStateException("Tile entity not correct! " +tileAtPos );
    }
    public RubyChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable,playerIn, RegistryHandler.RUBY_CHEST.get());
    }
    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < 36) {
                if (!this.mergeItemStack(itemstack1, 36, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 36, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }
}
