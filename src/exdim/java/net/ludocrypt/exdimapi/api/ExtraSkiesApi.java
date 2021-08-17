package net.ludocrypt.exdimapi.api;

import java.util.Map;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public interface ExtraSkiesApi {
	public void registerModSkies(Map<Identifier, SkyProperties> registry);
}
