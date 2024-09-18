package net.bareita.valheimmod.event;

import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.entity.ModEntities;
import net.bareita.valheimmod.entity.custom.DeerEntity;
import net.bareita.valheimmod.entity.custom.EikthyrEntity;
import net.bareita.valheimmod.entity.custom.TrollEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ValheimMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TROLL.get(), TrollEntity.createAttributes().build());
        event.put(ModEntities.DEER.get(), DeerEntity.createAttributes().build());
        event.put(ModEntities.EIKTHYR.get(), EikthyrEntity.createAttributes().build());
    }
}
