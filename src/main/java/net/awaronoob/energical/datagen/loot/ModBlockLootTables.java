package net.awaronoob.energical.datagen.loot;


import net.awaronoob.energical.block.ModBlocks;
import net.awaronoob.energical.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.NEODYMITE_ORE.get(),
                block -> createOreDrop(ModBlocks.NEODYMITE_ORE.get(), ModItems.RAW_NEODYMITE.get()));
        this.add(ModBlocks.DEEPSLATE_NEODYMITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_NEODYMITE_ORE.get(), ModItems.RAW_NEODYMITE.get()));

        dropSelf(ModBlocks.FLUXXITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_NEODYMITE_BLOCK.get());
        dropSelf(ModBlocks.NEODYMITE_BLOCK.get());

        dropSelf(ModBlocks.ITEM_DISPLAY.get());


    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}