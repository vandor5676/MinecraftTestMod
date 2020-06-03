package com.my.testmod.util;

import com.my.testmod.Tutorial;
import com.my.testmod.blocks.BlockItemBase;
import com.my.testmod.blocks.QuarryBlock;
import com.my.testmod.blocks.RopeBlock;
import com.my.testmod.blocks.RubyBlock;
import com.my.testmod.items.GoldenFlesh;
import com.my.testmod.items.Ruby;
import com.my.testmod.items.RubyBoots;
import com.my.testmod.items.RubyDagger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Tutorial.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Tutorial.MOD_ID);


    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //items
    public static final RegistryObject<Item> RUBY  =ITEMS.register("ruby", Ruby::new);
    public static final RegistryObject<Item> GOLDEN_FLESH  =ITEMS.register("golden_flesh", GoldenFlesh::new);

    //tools

    //weapons
    public static final RegistryObject<Item> RUBY_DAGGER = ITEMS.register("ruby_dagger", RubyDagger::new);


    //blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> ROPE_BLOCK = BLOCKS.register("rope_block", RopeBlock::new);
    public static final RegistryObject<Block> QUARRY_BLOCK = BLOCKS.register("quarry_block",()-> new QuarryBlock(Block.Properties.create(Material.CLAY)));

    //block items
    public static final RegistryObject RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", ()->new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject ROPE_BLOCK_ITEM = ITEMS.register("rope_block",() ->new BlockItemBase(ROPE_BLOCK.get()));
    public static final RegistryObject QUARRY_BLOCK_ITEM = ITEMS.register("quarry_block",() ->new BlockItemBase(QUARRY_BLOCK.get()));
    //armor
    public static final RegistryObject RUBY_BOOTS = ITEMS.register("ruby_boots", RubyBoots::new);

}

