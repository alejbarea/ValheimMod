package net.bareita.valheimmod.event;


import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.entity.client.Eikthyr;
import net.bareita.valheimmod.entity.client.ModModelLayers;
import net.bareita.valheimmod.entity.client.deer;
import net.bareita.valheimmod.entity.client.troll;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ValheimMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.TROLL_LAYER, troll::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.DEER_LAYER, deer::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.EIKTHYR_LAYER, Eikthyr::createBodyLayer);
    }
}
