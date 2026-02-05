package net.awaronoob.energical.datagen;

import net.awaronoob.energical.Energical;
import net.awaronoob.energical.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Energical.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NEODYMITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_NEODYMITE_ORE.get())
                .add(ModBlocks.RAW_NEODYMITE_BLOCK.get())

                .add(ModBlocks.FLUXXITE_BLOCK.get())
                .add(ModBlocks.NEODYMITE_BLOCK.get())

                .add(ModBlocks.ITEM_DISPLAY.get());




        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NEODYMITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_NEODYMITE_ORE.get())
                .add(ModBlocks.RAW_NEODYMITE_BLOCK.get())

                .add(ModBlocks.NEODYMITE_BLOCK.get())
                .add(ModBlocks.FLUXXITE_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ITEM_DISPLAY.get());


        tag(Tags.Blocks.ORES)
                .add(ModBlocks.NEODYMITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_NEODYMITE_ORE.get());

        tag(Tags.Blocks.ORES_IN_GROUND_STONE)
                .add(ModBlocks.NEODYMITE_ORE.get())
                .add(ModBlocks.RAW_NEODYMITE_BLOCK.get());

        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(ModBlocks.DEEPSLATE_NEODYMITE_ORE.get())
                .add(ModBlocks.RAW_NEODYMITE_BLOCK.get());

        tag(Tags.Blocks.ORE_BEARING_GROUND_STONE)
                .add(ModBlocks.NEODYMITE_ORE.get());

        tag(Tags.Blocks.ORE_BEARING_GROUND_DEEPSLATE)
                .add(ModBlocks.DEEPSLATE_NEODYMITE_ORE.get());

    }
}