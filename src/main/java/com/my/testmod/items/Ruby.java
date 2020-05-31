package com.my.testmod.items;

import com.my.testmod.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Ruby extends Item {

    public Ruby() {
        super(new Item.Properties().group(Tutorial.TAB));


    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 400;
    }
}
