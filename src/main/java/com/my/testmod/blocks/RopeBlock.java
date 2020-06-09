package com.my.testmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class RopeBlock extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(8, -1, 7, 9, 16, 8),
            Block.makeCuboidShape(7, 2, 7, 8, 15, 8),
            Block.makeCuboidShape(7, 1, 8, 8, 16, 9),
            Block.makeCuboidShape(8, 0, 8, 9, 17, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, -1, 7, 8, 16, 8),
            Block.makeCuboidShape(7, -1, 7, 8, 16, 8),
            Block.makeCuboidShape(7, 2, 8, 8, 15, 9),
            Block.makeCuboidShape(8, 1, 8, 9, 16, 9),
            Block.makeCuboidShape(8, 0, 7, 9, 17, 8)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public RopeBlock() {
        super(Block.Properties.create(Material.WEB)
        .hardnessAndResistance(1.0f,1.0f)
        .sound(SoundType.CLOTH)
        .harvestLevel(0)
        .harvestTool(null)
        //.notSolid()o
        //.doesNotBlockMovement()
        );

        this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING))
        {
            case UP:
                return SHAPE_S;
            case DOWN:
                return SHAPE_S;
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_S;
            case WEST:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_N;
            default:
                return SHAPE_N;
        }
    }

    //makes block face you when placed
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING,context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.with(FACING, direction.rotate(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
//        if(!worldIn.isRemote())
//        {
//            ServerWorld serverWorld = (ServerWorld)worldIn;
//            LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(),pos.getY(),pos.getZ(),false);
//            serverWorld.addLightningBolt(entity);
//
//        }
        return ActionResultType.SUCCESS;
    }
}
