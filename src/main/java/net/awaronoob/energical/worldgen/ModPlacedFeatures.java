package net.awaronoob.energical.worldgen;

import net.awaronoob.energical.Energical;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> NEODYMITE_ORE_SMALL_PLACED_KEY = registerKey("neodymite_ore_small_placed");
    public static final ResourceKey<PlacedFeature> NEODYMITE_ORE_MEDIUM_PLACED_KEY = registerKey("neodymite_ore_medium_placed");
    public static final ResourceKey<PlacedFeature> NEODYMITE_ORE_LARGE_PLACED_KEY = registerKey("neodymite_ore_large_placed");
    public static final ResourceKey<PlacedFeature> NEODYMITE_ORE_BURIED_PLACED_KEY = registerKey("neodymite_ore_buried_placed");
    public static final ResourceKey<PlacedFeature> NEODYMITE_ORE_JUNGLE_PLACED_KEY = registerKey("neodymite_ore_jungle_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NEODYMITE_ORE_SMALL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NEODYMITE_ORE_SMALL_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(100))));

        register(context, NEODYMITE_ORE_MEDIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NEODYMITE_ORE_MEDIUM_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, NEODYMITE_ORE_LARGE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NEODYMITE_ORE_LARGE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(65))));

        register(context, NEODYMITE_ORE_BURIED_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NEODYMITE_ORE_BURIED_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(65))));

        register(context, NEODYMITE_ORE_JUNGLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NEODYMITE_ORE_JUNGLE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Energical.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}