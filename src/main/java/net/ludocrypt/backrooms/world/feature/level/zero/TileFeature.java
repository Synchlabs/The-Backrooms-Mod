package net.ludocrypt.backrooms.world.feature.level.zero;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.block.TileBlock;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TileFeature extends Feature<DefaultFeatureConfig> {

	public TileFeature(Codec<DefaultFeatureConfig> configCodec) {
		super(configCodec);
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig config) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				if (x % 2 == 0) {
					world.setBlockState(pos.add(x, 0, z), BackroomsBlocks.CORK_TILE.getDefaultState().with(TileBlock.FACING, Direction.WEST), 2);
				} else {
					world.setBlockState(pos.add(x, 0, z), BackroomsBlocks.CORK_TILE.getDefaultState().with(TileBlock.FACING, Direction.EAST), 2);
				}
			}
		}
		return true;
	}

}
