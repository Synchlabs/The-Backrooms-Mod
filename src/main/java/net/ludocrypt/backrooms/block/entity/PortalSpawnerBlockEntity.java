package net.ludocrypt.backrooms.block.entity;

import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Tickable;

public class PortalSpawnerBlockEntity extends BlockEntity implements Tickable {

	public PortalSpawnerBlockEntity(BlockEntityType<?> type) {
		super(type);
	}

	public PortalSpawnerBlockEntity() {
		super(BackroomsBlocks.PORTAL_SPAWNER_BLOCK_ENTITY);
	}

	@Override
	public void tick() {
		world.setBlockState(pos, Blocks.AIR.getDefaultState());
	}

}
