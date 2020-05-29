package com.my.testmod.items;

import com.my.testmod.Tutorial;
import com.my.testmod.modMaterials.ModMaterial;
import net.minecraft.item.SwordItem;

public class RubyDagger extends SwordItem {
    public RubyDagger() {
        super(ModMaterial.modItemTier.RUBY,4,0.2f,new Properties().group(Tutorial.TAB));//new Item.Properties().group(Tutorial.TAB)
    }

}
