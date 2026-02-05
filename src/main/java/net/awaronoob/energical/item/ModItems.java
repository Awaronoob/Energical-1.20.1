package net.awaronoob.energical.item;

import net.awaronoob.energical.Energical;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Energical.MOD_ID);

    public static final RegistryObject<Item> UNPRESSED_FLUXXITE = ITEMS.register("unpressed_fluxxite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_NEODYMITE = ITEMS.register("raw_neodymite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NEODYMITE_INGOT = ITEMS.register("neodymite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NEODYMITE_SHEET = ITEMS.register("neodymite_sheet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRON_SHEET = ITEMS.register("iron_sheet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_SHEET = ITEMS.register("copper_sheet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOLD_SHEET = ITEMS.register("gold_sheet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_SHEET = ITEMS.register("netherite_sheet",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}