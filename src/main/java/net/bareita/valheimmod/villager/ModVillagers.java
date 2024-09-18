package net.bareita.valheimmod.villager;

import com.google.common.collect.ImmutableSet;
import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.block.ModBlocks;
import net.bareita.valheimmod.sound.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, ValheimMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, ValheimMod.MODID);

    public static final RegistryObject<PoiType> FORGE_POI = POI_TYPES.register("forge_poi", () -> new PoiType(ImmutableSet.copyOf(ModBlocks.FORGE_BLOCK.get().getStateDefinition().getPossibleStates()),1,1));

    public static final RegistryObject<VillagerProfession> HALDOR = VILLAGER_PROFESSION.register("haldor", () -> new VillagerProfession("haldor", holder -> holder.get() == FORGE_POI.get(), holder -> holder.get() == FORGE_POI.get(), ImmutableSet.of(), ImmutableSet.of(), ModSounds.HALDOR_GREETINGS.get()));
    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSION.register(eventBus);
    }
}
