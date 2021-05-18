package net.synchlabs.backrooms.world;

import java.util.Map;
import java.util.OptionalLong;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import net.synchlabs.backrooms.Backrooms;
import net.synchlabs.backrooms.client.BackroomsClient;
import net.synchlabs.backrooms.init.BackroomsBlocks;
import net.synchlabs.backrooms.world.chunk.MazeChunkGenerator;
import net.ludocrypt.exdimapi.api.ExtraDimension;
import net.ludocrypt.exdimapi.mixin.DimensionTypeAccessor;
import net.ludocrypt.exdimapi.util.NoiseSettings;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.VoronoiBiomeAccessType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

public class Level0 extends ExtraDimension{

	public static final Identifier LEVEL_0_ID = Backrooms.id("the_lobby");
	public static final Map<RegistryKey<Biome>, Biome.MixedNoisePoint> NOISE_POINTS = Maps.newHashMap();
	public static final NoiseSettings DEFAULT = new NoiseSettings(7, ImmutableList.of(1.0D));

	public Level0() {
		super(LEVEL_0_ID, DimensionTypeAccessor.createDimensionType(OptionalLong.of(1200), true, false, false, false, 1, false, false, false, false, false, 256, VoronoiBiomeAccessType.INSTANCE, BlockTags.INFINIBURN_OVERWORLD.getId(), LEVEL_0_ID, 0.1F), LEVEL_0_ID, (dim, client, ci) -> {
		}, DEFAULT, DEFAULT, DEFAULT, DEFAULT, null, NOISE_POINTS);
	}

	@Override
	public ChunkGenerator createGenerator(Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
		return new MazeChunkGenerator(4, 8, 100, BackroomsBlocks.PLASTERWALL.getDefaultState(), BackroomsBlocks.PLASTERWALL.getDefaultState(), ImmutableList.of(false, true, false, true, false), ImmutableList.of(false, false, true, true, true), ImmutableList.of(false, true, true, false, true), ImmutableList.of(false, true, false, true, true), BIOME_SOURCE_PRESET.getBiomeSource(biomeRegistry, seed), seed);
	}

	@Override
	public void init() {

	}

	public static class Level0Sky extends SkyProperties {

		public Level0Sky() {
			super(Float.NaN, false, SkyType.NONE, false, false);
		}

		@Override
		public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
			return color;
		}

		@Override
		public boolean useThickFog(int camX, int camY) {
			return false;
		}

		@Override
		public float[] getFogColorOverride(float skyAngle, float tickDelta) {
			return null;
		}

	}

}
