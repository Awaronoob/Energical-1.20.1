package net.awaronoob.energical.worldgen;


import net.awaronoob.energical.Energical;
import net.awaronoob.energical.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NEODYMITE_ORE_SMALL_KEY = registerKey("neodymite_ore_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NEODYMITE_ORE_MEDIUM_KEY = registerKey("neodymite_ore_medium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NEODYMITE_ORE_LARGE_KEY = registerKey("neodymite_ore_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NEODYMITE_ORE_BURIED_KEY = registerKey("neodymite_ore_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NEODYMITE_ORE_JUNGLE_KEY = registerKey("neodymite_ore_jungle");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldNeodymiteOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.NEODYMITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_NEODYMITE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_NEODYMITE_ORE_SMALL_KEY, Feature.ORE, new OreConfiguration(overworldNeodymiteOres, 3));
        register(context, OVERWORLD_NEODYMITE_ORE_MEDIUM_KEY, Feature.ORE, new OreConfiguration(overworldNeodymiteOres, 6));
        register(context, OVERWORLD_NEODYMITE_ORE_LARGE_KEY, Feature.ORE, new OreConfiguration(overworldNeodymiteOres, 9));
        register(context, OVERWORLD_NEODYMITE_ORE_BURIED_KEY, Feature.ORE, new OreConfiguration(overworldNeodymiteOres, 4, 1.0f));
        register(context, OVERWORLD_NEODYMITE_ORE_JUNGLE_KEY, Feature.ORE, new OreConfiguration(overworldNeodymiteOres, 6));

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Energical.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}