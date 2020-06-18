package com.my.testmod.util;

import com.my.testmod.Tutorial;
import com.my.testmod.blocks.*;
import com.my.testmod.items.GoldenFlesh;
import com.my.testmod.items.Ruby;
import com.my.testmod.items.RubyBoots;
import com.my.testmod.items.RubyDagger;
import com.my.testmod.world.feature.RubyTree;
import net.minecraft.block.*;
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
    public static final RegistryObject<Block> RUBY_STAIRS =  BLOCKS.register("ruby_stairs", RubyStairBlock::new);
    public static final RegistryObject<Block> RUBY_FENCE =  BLOCKS.register("ruby_fence", ()->new FenceBlock(Block.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> RUBY_BUTTON =  BLOCKS.register("ruby_button", ()->new ModWoodButtonBlock(Block.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> RUBY_PRESSURE_PLATE =  BLOCKS.register("ruby_pressure_plate", ()->new ModPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,Block.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> RUBY_CHEST = BLOCKS.register("ruby_chest",()-> new RubyChestBlock(Block.Properties.from(RegistryHandler.RUBY_BLOCK.get())));

    public static final RegistryObject<Block> RUBY_PLANKS = BLOCKS.register("ruby_planks",RubyPlanks::new);
    public static final RegistryObject<Block> RUBY_LOG = BLOCKS.register("ruby_log",RubyWood::new);
    public static final RegistryObject<Block> RUBY_LEAVES = BLOCKS.register("ruby_leaves",RubyLeaves::new);
    public static final RegistryObject<Block> RUBY_SAPLING = BLOCKS.register("ruby_sapling",()->new RubySapling(RubyTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));

    //block items
    public static final RegistryObject RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", ()->new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject ROPE_BLOCK_ITEM = ITEMS.register("rope_block",() ->new BlockItemBase(ROPE_BLOCK.get()));
    public static final RegistryObject QUARRY_BLOCK_ITEM = ITEMS.register("quarry_block",() ->new BlockItemBase(QUARRY_BLOCK.get()));
    public static final RegistryObject RUBY_STAIRS_ITEM = ITEMS.register("ruby_stairs",() ->new BlockItemBase(RUBY_STAIRS.get()));
    public static final RegistryObject RUBY_FENCE_ITEM = ITEMS.register("ruby_fence",() ->new BlockItemBase(RUBY_FENCE.get()));
    public static final RegistryObject RUBY_BUTTON_ITEM = ITEMS.register("ruby_button",() ->new BlockItemBase(RUBY_BUTTON.get()));
    public static final RegistryObject RUBY_PRESSURE_PLATE_ITEM = ITEMS.register("ruby_pressure_plate",() ->new BlockItemBase(RUBY_PRESSURE_PLATE.get()));
    public static final RegistryObject RUBY_Chest = ITEMS.register("ruby_chest",() ->new BlockItemBase(RUBY_CHEST.get()));

    public static final RegistryObject RUBY_PLANKS_ITEM = ITEMS.register("ruby_planks", ()->new BlockItemBase(RUBY_PLANKS.get()));
    public static final RegistryObject RUBY_LOG_ITEM = ITEMS.register("ruby_log", ()->new BlockItemBase(RUBY_LOG.get()));
    public static final RegistryObject RUBY_LEAVES_ITEM = ITEMS.register("ruby_leaves", ()->new BlockItemBase(RUBY_LEAVES.get()));
    public static final RegistryObject RUBY_SAPLING_ITEM = ITEMS.register("ruby_sapling", ()->new BlockItemBase(RUBY_SAPLING.get()));

    //armor
    public static final RegistryObject RUBY_BOOTS = ITEMS.register("ruby_boots", RubyBoots::new);

}

