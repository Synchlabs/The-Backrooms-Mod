package net.ludocrypt.backrooms.world.feature.level.zero;

import java.util.List;
import java.util.Random;

import com.mojang.serialization.Codec;

import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class DoorCarverFeature extends Feature<DefaultFeatureConfig> {

	public DoorCarverFeature(Codec<DefaultFeatureConfig> configCodec) {
		super(configCodec);
	}

	@Override
	public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig config) {

		for (Object object : List.of(Direction.values()).stream().filter((dir) -> !dir.equals(Direction.UP) && !dir.equals(Direction.DOWN)).toArray()) {
			Direction dir = (Direction) object;
			if (random.nextBoolean() && random.nextBoolean() && random.nextBoolean()) {
				if (world.getBlockState(pos.offset(dir)).isOf(BackroomsBlocks.PLASTERWALL)) {
					createWall(world, random, pos, dir);
				}
			}
		}

		if (world.getBlockState(pos.north()).isOf(BackroomsBlocks.PLASTERWALL) && world.getBlockState(pos.east()).isOf(BackroomsBlocks.PLASTERWALL) && world.getBlockState(pos.south()).isOf(BackroomsBlocks.PLASTERWALL) && world.getBlockState(pos.west()).isOf(BackroomsBlocks.PLASTERWALL)) {
			Direction dir = Direction.random(random);
			createWall(world, random, pos, dir.equals(Direction.UP) || dir.equals(Direction.DOWN) ? Direction.NORTH : dir);
		}

		return true;
	}

	public static void createWall(StructureWorldAccess world, Random random, BlockPos pos, Direction dir) {
		int addedOffset = random.nextInt(4) + 2;
		BlockPos.iterate(pos.offset(dir, addedOffset), pos.offset(dir, addedOffset + 1).add(0, 3, 0)).forEach((blockPos) -> {
			world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 3);
		});
		if (random.nextBoolean() && random.nextBoolean() && random.nextBoolean() && random.nextBoolean() && random.nextBoolean() && random.nextBoolean()) {
			world.setBlockState(pos.offset(dir, addedOffset), BackroomsBlocks.PORTAL_SPAWNER_BLOCK.getDefaultState(), 3);
		}
	}

}
