package com.my.testmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;

public class RubyWood extends LogBlock {
    public RubyWood() {
        super(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG));
    }
}
