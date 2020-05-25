package com.my.testmod.items;

import com.my.testmod.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(Tutorial.TAB));


    }
}
