package net.ludocrypt.exdimapi.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.mojang.serialization.Lifecycle;

import net.ludocrypt.exdimapi.ExtraDims;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

@Mixin(DimensionType.class)
public class DimensionTypeMixin {

	@Inject(method = "addRegistryDefaults", at = @At("TAIL"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
	private static void exDimApi_addRegistryDefaults(DynamicRegistryManager.Impl registryManager, CallbackInfoReturnable<DynamicRegistryManager.Impl> ci, MutableRegistry<DimensionType> mutableRegistry) {
		ExtraDims.EXTRA_DIMENSIONS.forEach((id, dim) -> {
			mutableRegistry.add(dim.DIMENSION_KEY, dim.DIMENSION_TYPE, Lifecycle.stable());
			ExtraDims.LOGGER.info("Added Dimension Type " + id + " to registry");
		});
	}

	@Inject(method = "createDefaultDimensionOptions", at = @At("TAIL"), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
	private static void exDimApi_createDefaultDimensionOptions(Registry<DimensionType> dimensionRegistry, Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed, CallbackInfoReturnable<SimpleRegistry<DimensionOptions>> ci, SimpleRegistry<DimensionOptions> simpleRegistry) {
		ExtraDims.EXTRA_DIMENSIONS.forEach((id, dim) -> {
			simpleRegistry.add(dim.DIMENSION_OPTIONS_KEY, new DimensionOptions(() -> {
				return dimensionRegistry.getOrThrow(dim.DIMENSION_KEY);
			}, dim.createGenerator(biomeRegistry, chunkGeneratorSettingsRegistry, seed)), Lifecycle.stable());
			ExtraDims.LOGGER.info("Added Dimension Options " + id + " to registry");
		});
	}

}
