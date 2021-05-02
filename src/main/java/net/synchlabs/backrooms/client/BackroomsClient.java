package net.synchlabs.backrooms.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.ludocrypt.exdimapi.api.ExtraSkiesApi;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.Identifier;
import net.synchlabs.backrooms.init.BackroomsBlocks;
import net.synchlabs.backrooms.world.Level0;

import java.util.Map;

public class BackroomsClient implements ClientModInitializer, ExtraSkiesApi {

	@Override
	public void onInitializeClient() {

		BlockRenderLayerMap.INSTANCE.putBlock(BackroomsBlocks.OFFICE_DOOR, RenderLayer.getTranslucent());
	}

	@Override
	public void registerModSkies(Map<Identifier, SkyProperties> map) {
		new Level0.Level0Sky();
	}
}
