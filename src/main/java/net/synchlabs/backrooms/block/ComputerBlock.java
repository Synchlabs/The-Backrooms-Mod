package net.synchlabs.backrooms.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.synchlabs.backrooms.block.entity.ComputerBlockEntity;

public class ComputerBlock extends HorizontalFacingBlock implements BlockEntityProvider {

    public static final BooleanProperty ON = BooleanProperty.of("on");

    public ComputerBlock(FabricBlockSettings fabricBlockSettings) {
        super(fabricBlockSettings);
        setDefaultState(this.stateManager.getDefaultState().with(ON, false).with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(ON);
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new ComputerBlockEntity();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }
}
