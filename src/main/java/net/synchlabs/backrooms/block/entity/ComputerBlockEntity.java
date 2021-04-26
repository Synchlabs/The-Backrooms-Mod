package net.synchlabs.backrooms.block.entity;

import net.synchlabs.backrooms.Backrooms;
import net.synchlabs.backrooms.block.ComputerBlock;
import net.synchlabs.backrooms.init.BackroomsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Tickable;

public class ComputerBlockEntity extends BlockEntity implements Tickable {

    public ComputerBlockEntity(BlockEntityType<?> type) {
        super(type);
    }

    public ComputerBlockEntity() {
        super(BackroomsBlocks.COMPUTER_BLOCK_ENTITY);
    }

    @Override
    public void tick() {
        if(world.isReceivingRedstonePower(pos)) {
            System.out.println("ON");
            world.setBlockState(pos, BackroomsBlocks.COMPUTER.getDefaultState().with(ComputerBlock.ON, true));
        }
        else
        {
            System.out.println("OFF");
            world.setBlockState(pos, BackroomsBlocks.COMPUTER.getDefaultState().with(ComputerBlock.ON, false));
        }
    }

}
