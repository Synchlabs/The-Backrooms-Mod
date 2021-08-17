package net.ludocrypt.exdimapi.util;

import java.util.List;

import net.minecraft.world.biome.source.MultiNoiseBiomeSource;

public class NoiseSettings extends MultiNoiseBiomeSource.NoiseParameters {

	public NoiseSettings(int firstOctave, List<Double> amplitudes) {
		super(firstOctave, amplitudes);
	}

}
