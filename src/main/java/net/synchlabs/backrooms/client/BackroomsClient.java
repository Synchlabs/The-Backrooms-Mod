package net.synchlabs.backrooms.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.synchlabs.backrooms.init.BackroomsBlocks;

public class BackroomsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		BlockRenderLayerMap.INSTANCE.putBlock(BackroomsBlocks.OFFICE_DOOR, RenderLayer.getTranslucent());
	}

}
