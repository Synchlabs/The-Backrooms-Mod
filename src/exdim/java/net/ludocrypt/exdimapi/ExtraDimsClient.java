package net.ludocrypt.exdimapi;

import java.util.Map;

import com.google.common.collect.Maps;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.ludocrypt.exdimapi.api.ExtraSkiesApi;
import net.ludocrypt.exdimapi.mixin.SkyPropertiesAccessor;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.Identifier;

public class ExtraDimsClient implements ClientModInitializer {

	public static final Map<Identifier, SkyProperties> EXTRA_SKIES = Maps.newHashMap();

	@Override
	public void onInitializeClient() {
		FabricLoader.getInstance().getEntrypointContainers("exskyapi", ExtraSkiesApi.class).forEach(container -> {
			ExtraSkiesApi exdimapi = container.getEntrypoint();
			exdimapi.registerModSkies(EXTRA_SKIES);
		});
		EXTRA_SKIES.forEach((id, sky) -> {
			SkyPropertiesAccessor.getBY_IDENTIFIER().put(id, sky);
			ExtraDims.LOGGER.info("Added Sky Property " + id + " to registry");
		});
	}

}
