package com.my.testmod;

import com.my.testmod.util.RegistryHandler;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class test {
    public test() {
        ResourceLocation testTagItem = new ResourceLocation(Tutorial.MOD_ID,"ruby_tag_Item");
        Item item = RegistryHandler.RUBY.get();
        boolean isInTag = ItemTags.getCollection().get(testTagItem).contains(item);

        if(isInTag)
        {
            item.setDamage(item.getDefaultInstance(),15);
        }
    }

}
