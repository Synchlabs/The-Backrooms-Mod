package net.ludocrypt.backrooms.world.feature.level.zero;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.block.PlasterwallBlock;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

public class WallpaperFillerFeature extends Feature<WallpaperConfig> {

	public WallpaperFillerFeature(Codec<WallpaperConfig> configCodec) {
		super(configCodec);
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, WallpaperConfig config) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				for (int y = 0; y < 4; y++) {
					BlockPos blockPos = pos.add(x, y, z);
					if (world.isAir(blockPos)) {
						for (Direction dir : Direction.values()) {
							BlockPos offset = blockPos.offset(dir);
							if (world.getBlockState(offset).isOf(BackroomsBlocks.PLASTERWALL)) {
								world.setBlockState(offset, world.getBlockState(offset).with(PlasterwallBlock.DIRECTION_MAP.get(dir.getOpposite()), config.type), 3);
							}
						}
					}
				}
			}
		}
		return true;
	}

}
