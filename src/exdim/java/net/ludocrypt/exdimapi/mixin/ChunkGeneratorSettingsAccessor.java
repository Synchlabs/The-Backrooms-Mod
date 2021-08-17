package net.ludocrypt.exdimapi.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;

@Mixin(ChunkGeneratorSettings.class)
public interface ChunkGeneratorSettingsAccessor {
	@Invoker("<init>")
	static ChunkGeneratorSettings createChunkGeneratorSettings(StructuresConfig structuresConfig, GenerationShapeConfig generationShapeConfig, BlockState defaultBlock, BlockState defaultFluid, int bedrockCeilingY, int bedrockFloorY, int seaLevel, boolean mobGenerationDisabled) {
		throw new UnsupportedOperationException();
	}

	@Invoker("createSurfaceSettings")
	static ChunkGeneratorSettings invokeCreateSurfaceSettings(StructuresConfig structuresConfig, boolean amplified) {
		throw new AssertionError();
	}

}
