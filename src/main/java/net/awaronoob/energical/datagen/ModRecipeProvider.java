package net.kaupenjoe.tutorialmod.datagen;


import net.awaronoob.energical.Energical;
import net.awaronoob.energical.block.ModBlocks;
import net.awaronoob.energical.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> NEODYMITE_SMELTABLES = List.of(ModItems.RAW_NEODYMITE.get(), ModBlocks.NEODYMITE_ORE.get(),
            ModBlocks.DEEPSLATE_NEODYMITE_ORE.get());

    private static final List<ItemLike> SOUL_BLOCK_ITEMS = List.of(Items.SOUL_SAND, Items.SOUL_SOIL);

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, NEODYMITE_SMELTABLES, RecipeCategory.MISC, ModItems.NEODYMITE_INGOT.get(), 0.75f, 200, "neodymite");
        oreBlasting(pWriter, NEODYMITE_SMELTABLES, RecipeCategory.MISC, ModItems.NEODYMITE_INGOT.get(), 0.75f, 100, "neodymite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNPRESSED_FLUXXITE.get(), 3)
                .pattern("GND")
                .pattern("CID")
                .pattern("DDD")
                .define('G', ModItems.GOLD_SHEET.get())
                .define('N', ModItems.NEODYMITE_SHEET.get())
                .define('C', ModItems.COPPER_SHEET.get())
                .define('I', ModItems.IRON_SHEET.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.NEODYMITE_SHEET.get()), has(ModItems.NEODYMITE_SHEET.get())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ITEM_DISPLAY.get())
                .pattern(" N ")
                .pattern("NCN")
                .pattern("NSN")
                .define('N', ModItems.NEODYMITE_INGOT.get())
                .define('C', Items.COAL)
                .define('S', Ingredient.of(Items.SOUL_SAND, Items.SOUL_SOIL))
                .unlockedBy(getHasName(ModItems.NEODYMITE_INGOT.get()), has(ModItems.NEODYMITE_INGOT.get()))
                .save(pWriter);


        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.NEODYMITE_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.NEODYMITE_BLOCK.get());


    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Energical.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}