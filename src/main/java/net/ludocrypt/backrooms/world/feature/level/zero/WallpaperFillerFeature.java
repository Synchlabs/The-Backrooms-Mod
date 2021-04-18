package net.ludocrypt.backrooms.world.feature.level.zero;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.util.WallpaperType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
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
					generateAt(world, blockPos, config.type);
				}
			}
		}
		return true;
	}

	public static void generateAt(WorldAccess world, BlockPos pos, WallpaperType type) {
		if (!world.isAir(pos)) {
			world.setBlockState(pos, type.block.get().getDefaultState(), 3);
		}
	}

}
