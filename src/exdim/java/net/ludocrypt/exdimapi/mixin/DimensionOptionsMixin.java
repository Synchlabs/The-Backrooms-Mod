package net.ludocrypt.exdimapi.mixin;

import java.util.Set;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.ludocrypt.exdimapi.ExtraDims;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.dimension.DimensionOptions;

@Mixin(DimensionOptions.class)
public class DimensionOptionsMixin {

	@Shadow
	@Final
	private static Set<RegistryKey<DimensionOptions>> BASE_DIMENSIONS;

	static {
		ExtraDims.EXTRA_DIMENSIONS.forEach((id, dim) -> {
			BASE_DIMENSIONS.add(dim.DIMENSION_OPTIONS_KEY);
			ExtraDims.LOGGER.info("Added Dimension Options " + id + " to base registry");
		});
	}

}
