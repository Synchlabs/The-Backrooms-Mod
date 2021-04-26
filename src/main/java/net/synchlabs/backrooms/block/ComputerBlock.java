package net.synchlabs.backrooms.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.world.BlockView;
import net.synchlabs.backrooms.block.entity.ComputerBlockEntity;
import net.synchlabs.backrooms.block.entity.PortalSpawnerBlockEntity;

public class ComputerBlock extends Block implements BlockEntityProvider {

    public static final BooleanProperty ON = BooleanProperty.of("on");

    public ComputerBlock(FabricBlockSettings fabricBlockSettings) {
        super(fabricBlockSettings);
        setDefaultState(getStateManager().getDefaultState().with(ON, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(ON);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new ComputerBlockEntity();
    }
}
