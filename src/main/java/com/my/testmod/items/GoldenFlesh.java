package com.my.testmod.items;

import com.my.testmod.Tutorial;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

import java.util.function.Supplier;

public class GoldenFlesh extends Item {
    public GoldenFlesh() {
        super(new Item.Properties().group(Tutorial.TAB).food(new Food.Builder()
                .hunger(1)
                .saturation(0f)
                .meat()
                .effect(new Supplier<EffectInstance>() {
                    @Override
                    public EffectInstance get() {
                        return new EffectInstance(Effect.get(17),120);
                    }
                },0.8f)
                .effect(new Supplier<EffectInstance>() {
                    @Override
                    public EffectInstance get() {
                        return new EffectInstance(Effect.get(10),240);
                    }
                },1)
                .build()));
    }
}
