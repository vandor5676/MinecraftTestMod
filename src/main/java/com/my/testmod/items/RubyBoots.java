package com.my.testmod.items;

import com.my.testmod.Tutorial;
import com.my.testmod.modMaterials.ModMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ArmorItem;

public class RubyBoots extends ArmorItem {
    public RubyBoots(/*IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder*/) {
        super(ModMaterial.modArmorMaterial.RUBY, EquipmentSlotType.FEET, new Properties().group(Tutorial.TAB));
    }
}
