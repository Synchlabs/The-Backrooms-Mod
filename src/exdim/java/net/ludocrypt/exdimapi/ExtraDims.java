package net.ludocrypt.exdimapi;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.ludocrypt.exdimapi.api.ExtraDimApi;
import net.ludocrypt.exdimapi.api.ExtraDimension;
import net.minecraft.util.Identifier;

public class ExtraDims implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("ExtraDimApi");
	public static final Map<Identifier, ExtraDimension> EXTRA_DIMENSIONS = Maps.newHashMap();

	@Override
	public void onInitialize() {
		FabricLoader.getInstance().getEntrypointContainers("exdimapi", ExtraDimApi.class).forEach(container -> {
			ExtraDimApi exdimapi = container.getEntrypoint();
			exdimapi.registerModDimensions(EXTRA_DIMENSIONS);
		});
		EXTRA_DIMENSIONS.forEach((id, dim) -> {
			dim.init();
		});
	}

}
