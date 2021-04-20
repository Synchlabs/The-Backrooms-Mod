package net.synchlabs.backrooms.init;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.DoorBlock;
import net.synchlabs.backrooms.Backrooms;
import net.synchlabs.backrooms.block.*;
import net.synchlabs.backrooms.block.entity.PortalSpawnerBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("all")
public class BackroomsBlocks {

	private static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
	private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();
	private static final Map<Identifier, BlockEntityType<?>> BLOCK_ENTITIES = new LinkedHashMap<>();

	public static final Block PORTAL_SPAWNER_BLOCK = add("portal_spawner", new PortalSpawnerBlock(FabricBlockSettings.copyOf(Blocks.END_PORTAL).dropsNothing()), ItemGroup.BUILDING_BLOCKS);
	public static final BlockEntityType<PortalSpawnerBlockEntity> PORTAL_SPAWNER_BLOCK_ENTITY = add("portal_spawner", PORTAL_SPAWNER_BLOCK, PortalSpawnerBlockEntity::new);

	public static final Block PLASTERWALL = add("plasterwall", new PlasterwallBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2.0F, 8.0F).breakByTool(FabricToolTags.PICKAXES).requiresTool().materialColor(DyeColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
	public static final Block CORK_TILE = add("cork_tile", new TileBlock(FabricBlockSettings.copyOf(Blocks.STONE).breakByTool(FabricToolTags.SWORDS).requiresTool().materialColor(DyeColor.WHITE)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FLUORESCENT_LIGHT = add("fluorescent_light", new FluorescentLightBlock(FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP).ticksRandomly().breakByTool(FabricToolTags.PICKAXES).requiresTool().materialColor(DyeColor.WHITE)), ItemGroup.BUILDING_BLOCKS);
	public static final Block PATTERNED_WALLPAPER = add("patterned_wallpaper", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).breakByTool(FabricToolTags.AXES).materialColor(DyeColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
	public static final Block STRIPED_WALLPAPER = add("striped_wallpaper", new Block(FabricBlockSettings.copyOf(PATTERNED_WALLPAPER)), ItemGroup.BUILDING_BLOCKS);
	public static final Block DOTTED_WALLPAPER = add("dotted_wallpaper", new Block(FabricBlockSettings.copyOf(PATTERNED_WALLPAPER)), ItemGroup.BUILDING_BLOCKS);
	public static final Block BLANK_WALLPAPER = add("blank_wallpaper", new Block(FabricBlockSettings.copyOf(PATTERNED_WALLPAPER)), ItemGroup.BUILDING_BLOCKS);
	public static final Block WOOLEN_CARPET = add("moist_carpet", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).breakByTool(FabricToolTags.SHEARS).materialColor(DyeColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
	public static final Block MOLDY_WOOLEN_CARPET = add("moldy_carpet", new Block(FabricBlockSettings.copyOf(WOOLEN_CARPET)), ItemGroup.BUILDING_BLOCKS);

	public static final Block HOTEL_CARPET = add("hotel_carpet", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).breakByTool(FabricToolTags.SHEARS).materialColor(DyeColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);

	public static final Block BLOODY_CARPET = add("bloody_carpet", new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).breakByTool(FabricToolTags.SHEARS).materialColor(DyeColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);

	public static final Block RED_PATTERNED_WALLPAPER = add("red_patterned_wallpaper", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).breakByTool(FabricToolTags.AXES).materialColor(DyeColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
	public static final Block RED_STRIPED_WALLPAPER = add("red_striped_wallpaper", new Block(FabricBlockSettings.copyOf(PATTERNED_WALLPAPER)), ItemGroup.BUILDING_BLOCKS);
	public static final Block RED_DOTTED_WALLPAPER = add("red_dotted_wallpaper", new Block(FabricBlockSettings.copyOf(PATTERNED_WALLPAPER)), ItemGroup.BUILDING_BLOCKS);
	public static final Block RED_BLANK_WALLPAPER = add("red_blank_wallpaper", new Block(FabricBlockSettings.copyOf(PATTERNED_WALLPAPER)), ItemGroup.BUILDING_BLOCKS);

	public static final Block OFFICE_DOOR = add("office_door", new BackroomsDoorBlock(FabricBlockSettings.copyOf(PATTERNED_WALLPAPER).nonOpaque()), ItemGroup.BUILDING_BLOCKS);

	private static <B extends Block, T extends BlockEntity> BlockEntityType<T> add(String name, B block, Supplier<T> supplier) {
		Identifier id = Backrooms.id(name);
		BlockEntityType<T> blockEntity = BlockEntityType.Builder.create(supplier, block).build(null);
		BLOCK_ENTITIES.put(id, blockEntity);
		return blockEntity;
	}

	private static <B extends Block> B add(String name, B block, ItemGroup tab) {
		return add(name, block, new BlockItem(block, new Item.Settings().group(tab)));
	}

	private static <B extends Block> B add(String name, B block, BlockItem item) {
		add(name, block);
		if (item != null) {
			item.appendBlocks(Item.BLOCK_ITEMS, item);
			ITEMS.put(Backrooms.id(name), item);
		}
		return block;
	}

	private static <B extends Block> B add(String name, B block) {
		BLOCKS.put(Backrooms.id(name), block);
		return block;
	}

	public static void init() {

		for (Identifier id : ITEMS.keySet()) {
			Registry.register(Registry.ITEM, id, ITEMS.get(id));
		}
		for (Identifier id : BLOCKS.keySet()) {
			Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
		}
		for (Identifier id : BLOCK_ENTITIES.keySet()) {
			Registry.register(Registry.BLOCK_ENTITY_TYPE, id, BLOCK_ENTITIES.get(id));
		}

		registerCompostableBlocks();
		registerFlammableBlocks();
		registerFuels();
	}

	private static void registerCompostableBlocks() {

	}

	private static void registerFlammableBlocks() {
		FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

	}

	private static void registerFuels() {
		FuelRegistry registry = FuelRegistry.INSTANCE;

	}

}
