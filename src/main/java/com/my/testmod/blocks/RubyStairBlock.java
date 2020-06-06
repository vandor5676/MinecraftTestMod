package com.my.testmod.blocks;

import com.my.testmod.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import java.util.function.Supplier;

public class RubyStairBlock  extends StairsBlock {

    public RubyStairBlock() {
        super(()-> RegistryHandler.RUBY_BLOCK.get().getDefaultState(),Properties.create(Material.ROCK));
    }
}
