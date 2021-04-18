package net.ludocrypt.backrooms.block;

import net.ludocrypt.backrooms.block.entity.PortalSpawnerBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class PortalSpawnerBlock extends Block implements BlockEntityProvider {

	public PortalSpawnerBlock(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new PortalSpawnerBlockEntity();
	}

}
