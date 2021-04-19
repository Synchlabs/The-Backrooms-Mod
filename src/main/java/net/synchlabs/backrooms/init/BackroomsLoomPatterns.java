package net.synchlabs.backrooms.init;

import java.util.LinkedHashMap;
import java.util.Map;

import io.github.fablabsmc.fablabs.api.bannerpattern.v1.LoomPattern;
import io.github.fablabsmc.fablabs.api.bannerpattern.v1.LoomPatterns;
import net.synchlabs.backrooms.Backrooms;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BackroomsLoomPatterns {

	private static final Map<Identifier, LoomPattern> LOOM_PATTERNS = new LinkedHashMap<>();

	public static final LoomPattern ARROWED = add("arrowed", new LoomPattern(false));
	public static final LoomPattern LINED = add("lined", new LoomPattern(false));
	public static final LoomPattern DOTTED = add("dotted", new LoomPattern(false));
	public static final LoomPattern BLANK = add("blank", new LoomPattern(false));

	public static void init() {
		for (Identifier id : LOOM_PATTERNS.keySet()) {
			Registry.register(LoomPatterns.REGISTRY, id, LOOM_PATTERNS.get(id));
		}
	}

	private static LoomPattern add(String s, LoomPattern p) {
		Identifier id = Backrooms.id(s);
		LOOM_PATTERNS.put(id, p);
		return p;
	}

}
