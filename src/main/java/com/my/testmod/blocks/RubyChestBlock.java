package com.my.testmod.blocks;

import com.my.testmod.tileEntity.RubyChestTileEntity;
import com.my.testmod.util.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class RubyChestBlock extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 6, 15),
            Block.makeCuboidShape(2, 5, 2, 3, 7, 14),
            Block.makeCuboidShape(3, 7, 3, 4, 8, 13),
            Block.makeCuboidShape(4, 8, 4, 5, 9, 12),
            Block.makeCuboidShape(5, 9, 5, 6, 10, 11),
            Block.makeCuboidShape(6, 9, 10, 11, 10, 11),
            Block.makeCuboidShape(3, 5, 13, 14, 7, 14),
            Block.makeCuboidShape(4, 7, 12, 13, 8, 13),
            Block.makeCuboidShape(5, 8, 11, 12, 9, 12),
            Block.makeCuboidShape(10, 9, 5, 11, 10, 10),
            Block.makeCuboidShape(13, 5, 2, 14, 7, 13),
            Block.makeCuboidShape(12, 7, 3, 13, 8, 12),
            Block.makeCuboidShape(11, 8, 4, 12, 9, 11),
            Block.makeCuboidShape(6, 9, 5, 10, 10, 6),
            Block.makeCuboidShape(3, 6, 2, 14, 7, 3),
            Block.makeCuboidShape(4, 7, 3, 12, 8, 4),
            Block.makeCuboidShape(5, 8, 4, 11, 9, 5),
            Block.makeCuboidShape(5, 11, 11, 11, 12, 12),
            Block.makeCuboidShape(6, 10, 10, 10, 11, 11),
            Block.makeCuboidShape(3, 13, 13, 14, 14, 14),
            Block.makeCuboidShape(4, 12, 12, 12, 13, 13),
            Block.makeCuboidShape(10, 10, 6, 11, 11, 11),
            Block.makeCuboidShape(13, 13, 3, 14, 15, 14),
            Block.makeCuboidShape(12, 12, 4, 13, 13, 13),
            Block.makeCuboidShape(11, 11, 5, 12, 12, 12),
            Block.makeCuboidShape(6, 10, 5, 11, 11, 6),
            Block.makeCuboidShape(3, 13, 2, 14, 15, 3),
            Block.makeCuboidShape(4, 12, 3, 13, 13, 4),
            Block.makeCuboidShape(5, 11, 4, 12, 12, 5),
            Block.makeCuboidShape(5, 10, 5, 6, 11, 11),
            Block.makeCuboidShape(2, 13, 2, 3, 15, 14),
            Block.makeCuboidShape(3, 12, 3, 4, 13, 13),
            Block.makeCuboidShape(4, 11, 4, 5, 12, 12),
            Block.makeCuboidShape(1, 14, 1, 15, 20, 15)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    public RubyChestBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.RUBY_CHEST.get().create();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if(!worldIn.isRemote)
        {
            TileEntity tile = worldIn.getTileEntity(pos);
            if(tile instanceof RubyChestTileEntity)
            {
                NetworkHooks.openGui((ServerPlayerEntity)player, (RubyChestTileEntity)tile, pos);
                return ActionResultType.SUCCESS;
            }
        }

        return ActionResultType.FAIL;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if(state.getBlock() != newState.getBlock())
        {
           TileEntity te = worldIn.getTileEntity(pos);
           if(te instanceof RubyChestTileEntity)
           {
               InventoryHelper.dropItems(worldIn,pos,((RubyChestTileEntity)te).getItems());
           }
        }

        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING))
        {
            default:
                return SHAPE_N;
        }
    }
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
