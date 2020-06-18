package com.my.testmod.world.feature;

import com.my.testmod.util.RegistryHandler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class RubyTree extends Tree {

    public static final TreeFeatureConfig RUBY_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.RUBY_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RegistryHandler.RUBY_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(3,0)
    )).baseHeight(14).heightRandA(5).foliageHeight(3).ignoreVines().setSapling((IPlantable)RegistryHandler.RUBY_SAPLING.get()).build();

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(RUBY_TREE_CONFIG);
    }
}
