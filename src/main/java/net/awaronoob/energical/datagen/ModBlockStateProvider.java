package net.awaronoob.energical.datagen;

import net.awaronoob.energical.Energical;
import net.awaronoob.energical.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Energical.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NEODYMITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_NEODYMITE_ORE);

        blockWithItem(ModBlocks.NEODYMITE_BLOCK);
        blockWithItem(ModBlocks.RAW_NEODYMITE_BLOCK);

        blockWithItem(ModBlocks.FLUXXITE_BLOCK);

        simpleBlock(ModBlocks.ITEM_DISPLAY_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/item_display")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}