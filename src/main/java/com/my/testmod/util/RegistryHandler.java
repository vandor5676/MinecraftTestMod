package com.my.testmod.util;

import com.my.testmod.Tutorial;
import com.my.testmod.blocks.BlockItemBase;
import com.my.testmod.blocks.RubyBlock;
import com.my.testmod.items.GoldenFlesh;
import com.my.testmod.items.ItemBase;
import com.my.testmod.items.RubyDagger;
import net.minecraft.block.Block;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Tutorial.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Tutorial.MOD_ID);


    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //items
    public static final RegistryObject<Item> RUBY  =ITEMS.register("ruby", ItemBase::new);
    public static final RegistryObject<Item> GOLDEN_FLESH  =ITEMS.register("golden_flesh", GoldenFlesh::new);
    public static final RegistryObject<Item> RUBY_DAGGER = ITEMS.register("ruby_dagger", RubyDagger::new);


    //blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);

    //block items
    public static final RegistryObject RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", ()->new BlockItemBase(RUBY_BLOCK.get()));



}

