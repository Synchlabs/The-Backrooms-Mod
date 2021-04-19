package net.ludocrypt.backrooms.init;

import java.util.LinkedHashMap;
import java.util.Map;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.world.Level0;
import net.ludocrypt.backrooms.world.biome.Level0Biome;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class BackroomsBiomes {

	private static final Map<Identifier, Biome> BIOMES = new LinkedHashMap<>();

	public static final RegistryKey<Biome> LEVEL0 = add("level0", Level0Biome.create());

	public static void init() {
		for (Identifier id : BIOMES.keySet()) {
			Registry.register(BuiltinRegistries.BIOME, id, BIOMES.get(id));
		}
		Level0.NOISE_POINTS.put(LEVEL0, new Biome.MixedNoisePoint(0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
	}

	private static RegistryKey<Biome> add(String s, Biome b) {
		Identifier id = Backrooms.id(s);
		BIOMES.put(id, b);
		return RegistryKey.of(Registry.BIOME_KEY, id);
	}

}
