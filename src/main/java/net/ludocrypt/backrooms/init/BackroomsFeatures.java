package net.ludocrypt.backrooms.init;

import java.util.HashMap;
import java.util.Map;

import net.ludocrypt.backrooms.Backrooms;
import net.ludocrypt.backrooms.util.WallpaperType;
import net.ludocrypt.backrooms.world.feature.ForeachExtraPosDecorator;
import net.ludocrypt.backrooms.world.feature.ForeachPosDecorator;
import net.ludocrypt.backrooms.world.feature.level.zero.DoorCarverFeature;
import net.ludocrypt.backrooms.world.feature.level.zero.TileFeature;
import net.ludocrypt.backrooms.world.feature.level.zero.WallpaperConfig;
import net.ludocrypt.backrooms.world.feature.level.zero.WallpaperFillerFeature;
import net.ludocrypt.backrooms.world.feature.level.zero.WoolenCarpetFeature;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

// TODO: Check
public class BackroomsFeatures {

	private static final Map<Identifier, ConfiguredFeature<? extends FeatureConfig, ? extends Feature<? extends FeatureConfig>>> CONFIGURED_FEATURES = new HashMap<>();
	private static final Map<Identifier, Decorator<? extends DecoratorConfig>> DECORATORS = new HashMap<>();
	private static final Map<Identifier, Feature<? extends FeatureConfig>> FEATURES = new HashMap<>();

	// Level 0
	public static final Decorator<ChanceDecoratorConfig> FOREACH_POS = add("foreach_pos_decorator", new ForeachPosDecorator(ChanceDecoratorConfig.CODEC));
	public static final Decorator<ChanceDecoratorConfig> FOREACH_EXTRA_POS = add("foreach_extra_pos_decorator", new ForeachExtraPosDecorator(ChanceDecoratorConfig.CODEC));

	public static final Feature<DefaultFeatureConfig> CORK_TILE_FEATURE = add("cork_tile_feature", new TileFeature(DefaultFeatureConfig.CODEC));
	public static final ConfiguredFeature<?, ?> LEVEL0_CORK_TILES = add("level0_cork_tiles", CORK_TILE_FEATURE.configure(DefaultFeatureConfig.INSTANCE).decorate(FOREACH_POS.configure(new ChanceDecoratorConfig(104))));

	public static final Feature<DefaultFeatureConfig> WOOLEN_CARPET_FLOOR_FEATURE = add("woolen_carpet_floor_feature", new WoolenCarpetFeature(DefaultFeatureConfig.CODEC));
	public static final ConfiguredFeature<?, ?> LEVEL0_WOOLEN_CARPET_FLOOR = add("woolen_carpet_floor", WOOLEN_CARPET_FLOOR_FEATURE.configure(DefaultFeatureConfig.INSTANCE).decorate(FOREACH_POS.configure(new ChanceDecoratorConfig(99))));

	public static final Feature<DefaultFeatureConfig> DOOR_CARVER_FEATURE = add("carver_feature", new DoorCarverFeature(DefaultFeatureConfig.CODEC));
	public static final ConfiguredFeature<?, ?> LEVEL0_DOOR_CARVER = add("door_carver", DOOR_CARVER_FEATURE.configure(DefaultFeatureConfig.INSTANCE).decorate(FOREACH_EXTRA_POS.configure(new ChanceDecoratorConfig(100))));

	public static final Feature<WallpaperConfig> WALLPAPER_FILLER_FEATURE = add("door_carver_feature", new WallpaperFillerFeature(WallpaperConfig.CODEC));
	public static final ConfiguredFeature<?, ?> LEVEL0_ARROWED_WALLPAPER_FILLER = add("arrowed_wallpaper_filler", WALLPAPER_FILLER_FEATURE.configure(new WallpaperConfig(WallpaperType.ARROWED)).decorate(FOREACH_EXTRA_POS.configure(new ChanceDecoratorConfig(100))));
	public static final ConfiguredFeature<?, ?> LEVEL0_LINED_WALLPAPER_FILLER = add("lined_wallpaper_filler", WALLPAPER_FILLER_FEATURE.configure(new WallpaperConfig(WallpaperType.LINED)).decorate(FOREACH_EXTRA_POS.configure(new ChanceDecoratorConfig(100))));
	public static final ConfiguredFeature<?, ?> LEVEL0_DOTTED_WALLPAPER_FILLER = add("dotted_wallpaper_filler", WALLPAPER_FILLER_FEATURE.configure(new WallpaperConfig(WallpaperType.DOTTED)).decorate(FOREACH_EXTRA_POS.configure(new ChanceDecoratorConfig(100))));
	public static final ConfiguredFeature<?, ?> LEVEL0_BLANK_WALLPAPER_FILLER = add("blank_wallpaper_filler", WALLPAPER_FILLER_FEATURE.configure(new WallpaperConfig(WallpaperType.BLANK)).decorate(FOREACH_EXTRA_POS.configure(new ChanceDecoratorConfig(100))));

	private static <FC extends FeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, F> add(String name, ConfiguredFeature<FC, F> cf) {
		CONFIGURED_FEATURES.put(Backrooms.id(name), cf);
		return cf;
	}

	private static <DC extends DecoratorConfig> Decorator<DC> add(String name, Decorator<DC> d) {
		DECORATORS.put(Backrooms.id(name), d);
		return d;
	}

	private static <FC extends FeatureConfig> Feature<FC> add(String name, Feature<FC> f) {
		FEATURES.put(Backrooms.id(name), f);
		return f;
	}

	public static void init() {
		for (Identifier id : CONFIGURED_FEATURES.keySet()) {
			Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, CONFIGURED_FEATURES.get(id));
		}
		for (Identifier id : DECORATORS.keySet()) {
			Registry.register(Registry.DECORATOR, id, DECORATORS.get(id));
		}
		for (Identifier id : FEATURES.keySet()) {
			Registry.register(Registry.FEATURE, id, FEATURES.get(id));
		}
	}

}
