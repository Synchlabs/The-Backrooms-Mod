package net.synchlabs.backrooms;

import java.util.Map;

import net.fabricmc.api.ModInitializer;
import net.synchlabs.backrooms.init.BackroomsBiomes;
import net.synchlabs.backrooms.init.BackroomsBlocks;
import net.synchlabs.backrooms.init.BackroomsFeatures;
import net.synchlabs.backrooms.init.BackroomsGroups;
import net.synchlabs.backrooms.init.BackroomsItems;
import net.synchlabs.backrooms.init.BackroomsLoomPatterns;
import net.synchlabs.backrooms.world.Level0;
import net.synchlabs.backrooms.world.chunk.MazeChunkGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Backrooms implements ModInitializer {

	@Override
	public void onInitialize() {
		Registry.register(Registry.CHUNK_GENERATOR, id("maze_chunk"), MazeChunkGenerator.CODEC);
		BackroomsLoomPatterns.init();
		BackroomsFeatures.init();
		BackroomsItems.init();
		BackroomsBiomes.init();
		BackroomsBlocks.init();
		BackroomsGroups.init();
	}

	/*@Override
	public void registerModDimensions(Map<Identifier, ExtraDimension> registry) {
		registry.put(Level0.LEVEL_0_ID, new Level0());
	}*/

	public static Identifier id(String id) {
		return new Identifier("backrooms", id);
	}

}
