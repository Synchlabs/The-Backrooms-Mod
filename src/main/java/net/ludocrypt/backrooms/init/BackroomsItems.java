package net.ludocrypt.backrooms.init;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.items.WallpaperPatternItem;
import net.ludocrypt.backrooms.util.WallpaperType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BackroomsItems {

	private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

	public static final Item ARROWED_PATTERN = add("arrowed_pattern", new WallpaperPatternItem(BackroomsLoomPatterns.ARROWED, WallpaperType.ARROWED, new FabricItemSettings().group(ItemGroup.MISC)));
	public static final Item LINED_PATTERN = add("lined_pattern", new WallpaperPatternItem(BackroomsLoomPatterns.LINED, WallpaperType.LINED, new FabricItemSettings().group(ItemGroup.MISC)));
	public static final Item DOTTED_PATTERN = add("dotted_pattern", new WallpaperPatternItem(BackroomsLoomPatterns.DOTTED, WallpaperType.DOTTED, new FabricItemSettings().group(ItemGroup.MISC)));
	public static final Item BLANK_PATTERN = add("blank_pattern", new WallpaperPatternItem(BackroomsLoomPatterns.BLANK, WallpaperType.BLANK, new FabricItemSettings().group(ItemGroup.MISC)));

	private static <I extends Item> I add(String name, I item) {
		ITEMS.put(Backrooms.id(name), item);
		return item;
	}

	public static void init() {
		for (Identifier id : ITEMS.keySet()) {
			Registry.register(Registry.ITEM, id, ITEMS.get(id));
		}
	}
}
