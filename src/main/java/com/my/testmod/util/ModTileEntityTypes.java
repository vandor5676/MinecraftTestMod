package com.my.testmod.util;

import com.my.testmod.Tutorial;
import com.my.testmod.tileEntity.QuarryTileEntity;
import com.my.testmod.tileEntity.RubyChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Tutorial.MOD_ID);

    public  static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry_block",()->TileEntityType.Builder.create(QuarryTileEntity::new,RegistryHandler.QUARRY_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<RubyChestTileEntity>> RUBY_CHEST = TILE_ENTITY_TYPES.register("ruby_chest", ()->TileEntityType.Builder.create(RubyChestTileEntity::new, RegistryHandler.RUBY_CHEST.get()).build(null));
}
