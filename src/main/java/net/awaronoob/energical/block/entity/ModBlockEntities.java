package net.awaronoob.energical.block.entity;

import net.awaronoob.energical.Energical;
import net.awaronoob.energical.block.ModBlocks;
import net.awaronoob.energical.block.entity.custom.ItemDisplayBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Energical.MOD_ID);

    public static final RegistryObject<BlockEntityType<ItemDisplayBlockEntity>> ITEM_DISPLAY_BE =
            BLOCK_ENTITIES.register("item_display_be", () ->
                    BlockEntityType.Builder.of(ItemDisplayBlockEntity::new,
                            ModBlocks.ITEM_DISPLAY.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}