package net.bareita.valheimmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.entity.custom.EikthyrEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EikthyrRenderer extends MobRenderer<EikthyrEntity, Eikthyr<EikthyrEntity>> {
    public EikthyrRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Eikthyr<>(pContext.bakeLayer(ModModelLayers.EIKTHYR_LAYER)), 0.5f);
    }
    @Override
    public void render(EikthyrEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(3f,3f,3f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(EikthyrEntity pEntity) {
        return new ResourceLocation(ValheimMod.MODID,"textures/entity/eikthyr.png");
    }
}
