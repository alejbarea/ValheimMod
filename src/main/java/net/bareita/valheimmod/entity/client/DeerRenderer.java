package net.bareita.valheimmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.entity.custom.DeerEntity;
import net.bareita.valheimmod.entity.custom.TrollEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DeerRenderer extends MobRenderer<DeerEntity, deer<DeerEntity>> {
    public DeerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new deer<>(pContext.bakeLayer(ModModelLayers.DEER_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(DeerEntity pEntity) {
        return new ResourceLocation(ValheimMod.MODID,"textures/entity/deer.png");
    }

    @Override
    public void render(DeerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f,0.5f,0.5f);
        }
        pPoseStack.scale(1.2f,1.2f,1.2f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
