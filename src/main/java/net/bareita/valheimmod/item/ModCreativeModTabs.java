package net.bareita.valheimmod.item;

import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ValheimMod.MODID);

    public static final RegistryObject<CreativeModeTab> VALHEIM_TAB = CREATIVE_MODE_TABS.register("valheim_tab", ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN.get())).title(Component.translatable("creativetab.valheim_tab")).displayItems((pParameters, pOutput) -> {
        pOutput.accept(ModItems.TIN.get());
        pOutput.accept(ModItems.RAW_TIN.get());
        pOutput.accept(ModBlocks.TIN_ORE.get());
        pOutput.accept(ModBlocks.TIN_BLOCK.get());
        pOutput.accept(ModBlocks.BRONZE_BLOCK.get());
        pOutput.accept(ModItems.BRONZE.get());
        pOutput.accept(ModItems.WISHBONE.get());
        pOutput.accept(ModBlocks.FORGE_BLOCK.get());
        pOutput.accept(ModItems.RAW_DEER_MEAT.get());
        pOutput.accept(ModItems.COOKED_DEER_MEAT.get());
        pOutput.accept(ModItems.SURTLING_CORE.get());
        pOutput.accept(ModItems.BRONZE_SWORD.get());
        pOutput.accept(ModItems.BRONZE_AXE.get());
        pOutput.accept(ModItems.BRONZE_PICKAXE.get());
        pOutput.accept(ModItems.BRONZE_HOE.get());
        pOutput.accept(ModItems.BRONZE_SHOVEL.get());
        pOutput.accept(ModItems.SPEAR.get());
        pOutput.accept(ModItems.BRONZE_SPEAR.get());
        pOutput.accept(ModItems.BRONZE_HELMET.get());
        pOutput.accept(ModItems.BRONZE_CHEST.get());
        pOutput.accept(ModItems.BRONZE_BOOTS.get());
        pOutput.accept(ModItems.BRONZE_LEGS.get());
        pOutput.accept(ModItems.ONION_SEED.get());
        pOutput.accept(ModItems.ONION.get());
        pOutput.accept(ModItems.TROLL_SPAWN_EGG.get());
        pOutput.accept(ModBlocks.BRONZE_BUTTON.get());
        pOutput.accept(ModBlocks.BRONZE_SLAB.get());
        pOutput.accept(ModBlocks.BRONZE_STAIRS.get());
        pOutput.accept(ModBlocks.BRONZE_TRAPDOOR.get());
        pOutput.accept(ModBlocks.BRONZE_DOOR.get());
        pOutput.accept(ModBlocks.BRONZE_WALL.get());
        pOutput.accept(ModBlocks.BRONZE_FENCE.get());
        pOutput.accept(ModBlocks.BRONZE_FENCE_GATE.get());
        pOutput.accept(ModItems.DEER_SPAWN_EGG.get());
        pOutput.accept(ModItems.DEER_TROPHY.get());
        pOutput.accept(ModBlocks.EIKTHYR_SUMMON.get());
        pOutput.accept(ModItems.TROLL_SKIN.get());
        pOutput.accept(ModItems.TROLL_BOOTS.get());
        pOutput.accept(ModItems.TROLL_LEGS.get());
        pOutput.accept(ModItems.TROLL_CHEST.get());
        pOutput.accept(ModItems.TROLL_HELMET.get());
    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
