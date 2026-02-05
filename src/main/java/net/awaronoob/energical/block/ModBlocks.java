package net.awaronoob.energical.block;


import net.awaronoob.energical.Energical;
import net.awaronoob.energical.block.custom.ItemDisplayBlock;
import net.awaronoob.energical.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Energical.MOD_ID);


    public static final RegistryObject<Block> NEODYMITE_ORE = registerBlock("neodymite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4.5F, 4.5F).requiresCorrectToolForDrops(), UniformInt.of(1, 5)));

    public static final RegistryObject<Block> DEEPSLATE_NEODYMITE_ORE = registerBlock("deepslate_neodymite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5.5F, 4.5F).requiresCorrectToolForDrops(), UniformInt.of(1, 5)));

    public static final RegistryObject<Block> RAW_NEODYMITE_BLOCK = registerBlock("raw_neodymite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5.5F, 5.5F).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .mapColor(MapColor.METAL)));

    public static final RegistryObject<Block> NEODYMITE_BLOCK = registerBlock("neodymite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(7.0F, 7.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .mapColor(MapColor.METAL)));

    public static final RegistryObject<Block> FLUXXITE_BLOCK = registerBlock("fluxxite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)
                    .mapColor(MapColor.STONE)));

    public static final RegistryObject<Block> ITEM_DISPLAY = registerBlock("item_display",
            () -> new ItemDisplayBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}