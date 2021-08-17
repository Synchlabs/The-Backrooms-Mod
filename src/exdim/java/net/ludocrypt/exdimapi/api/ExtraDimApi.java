package net.ludocrypt.exdimapi.api;

import java.util.Map;

import net.minecraft.util.Identifier;

public interface ExtraDimApi {
	public void registerModDimensions(Map<Identifier, ExtraDimension> registry);
}
