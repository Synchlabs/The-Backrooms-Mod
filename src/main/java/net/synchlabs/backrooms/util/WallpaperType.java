package net.synchlabs.backrooms.util;

import com.google.common.base.Supplier;

import net.synchlabs.backrooms.init.BackroomsBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.StringIdentifiable;

public enum WallpaperType implements StringIdentifiable {
	EMPTY("empty", () -> BackroomsBlocks.PLASTERWALL), ARROWED("arrowed", () -> BackroomsBlocks.ARROWED_WALLPAPER), LINED("lined", () -> BackroomsBlocks.LINED_WALLPAPER), DOTTED("dotted", () -> BackroomsBlocks.DOTTED_WALLPAPER), BLANK("blank", () -> BackroomsBlocks.BLANK_WALLPAPER);

	public final String name;
	public final Supplier<Block> block;

	WallpaperType(String name, Supplier<Block> block) {
		this.name = name;
		this.block = block;
	}

	@Override
	public String asString() {
		return this.name;
	}

}
