package net.awaronoob.energical.item;


import net.awaronoob.energical.Energical;
import net.awaronoob.energical.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Energical.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENERGICAL_MATERIALS_TAB = CREATIVE_MODE_TABS.register("energical_materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NEODYMITE_INGOT.get()))
                    .title(Component.translatable("creativetab." + Energical.MOD_ID + ".energical_materials_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.NEODYMITE_INGOT.get());
                        pOutput.accept(ModItems.RAW_NEODYMITE.get());

                        pOutput.accept(ModItems.UNPRESSED_FLUXXITE.get());


                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> ENERGICAL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("energical_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.NEODYMITE_ORE.get()))
                    .title(Component.translatable("creativetab." + Energical.MOD_ID + ".energical_blocks_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.NEODYMITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_NEODYMITE_ORE.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}