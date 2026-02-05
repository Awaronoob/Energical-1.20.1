package net.awaronoob.energical.datagen;


import net.awaronoob.energical.Energical;
import net.awaronoob.energical.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Energical.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_NEODYMITE.get());
        basicItem(ModItems.NEODYMITE_INGOT.get());

        basicItem(ModItems.UNPRESSED_FLUXXITE.get());

        basicItem(ModItems.IRON_SHEET.get());
        basicItem(ModItems.GOLD_SHEET.get());
        basicItem(ModItems.NEODYMITE_SHEET.get());
        basicItem(ModItems.COPPER_SHEET.get());


    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Energical.MOD_ID,"item/" + item.getId().getPath()));
    }
}