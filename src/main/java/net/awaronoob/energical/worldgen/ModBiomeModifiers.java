package net.awaronoob.energical.worldgen;

import net.awaronoob.energical.Energical;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_NEODYMITE_ORE_SMALL = registerKey("add_neodymite_ore_small");
    public static final ResourceKey<BiomeModifier> ADD_NEODYMITE_ORE_MEDIUM = registerKey("add_neodymite_ore_medium");
    public static final ResourceKey<BiomeModifier> ADD_NEODYMITE_ORE_LARGE = registerKey("add_neodymite_ore_large");
    public static final ResourceKey<BiomeModifier> ADD_NEODYMITE_ORE_BURIED = registerKey("add_neodymite_ore_buried");
    public static final ResourceKey<BiomeModifier> ADD_NEODYMITE_ORE_JUNGLE = registerKey("add_neodymite_ore_jungle");


    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_NEODYMITE_ORE_SMALL, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NEODYMITE_ORE_SMALL_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_NEODYMITE_ORE_MEDIUM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NEODYMITE_ORE_MEDIUM_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_NEODYMITE_ORE_LARGE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NEODYMITE_ORE_LARGE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_NEODYMITE_ORE_BURIED, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NEODYMITE_ORE_BURIED_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_NEODYMITE_ORE_JUNGLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NEODYMITE_ORE_JUNGLE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Energical.MOD_ID, name));
    }
}