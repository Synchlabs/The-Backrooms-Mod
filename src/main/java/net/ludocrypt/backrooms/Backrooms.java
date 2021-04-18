package net.ludocrypt.backrooms;

import java.util.Map;

import net.fabricmc.api.ModInitializer;
import net.ludocrypt.backrooms.init.BackroomsBiomes;
import net.ludocrypt.backrooms.init.BackroomsBlocks;
import net.ludocrypt.backrooms.init.BackroomsFeatures;
import net.ludocrypt.backrooms.init.BackroomsGroups;
import net.ludocrypt.backrooms.init.BackroomsItems;
import net.ludocrypt.backrooms.init.BackroomsLoomPatterns;
import net.ludocrypt.backrooms.world.Level0;
import net.ludocrypt.backrooms.world.chunk.MazeChunkGenerator;
import net.ludocrypt.exdimapi.api.ExtraDimApi;
import net.ludocrypt.exdimapi.api.ExtraDimension;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Backrooms implements ModInitializer, ExtraDimApi {

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

	@Override
	public void registerModDimensions(Map<Identifier, ExtraDimension> registry) {
		registry.put(Level0.LEVEL_0_ID, new Level0());
	}

	public static Identifier id(String id) {
		return new Identifier("backrooms", id);
	}

}
