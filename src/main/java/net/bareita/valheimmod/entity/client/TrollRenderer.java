package net.bareita.valheimmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bareita.valheimmod.ValheimMod;
import net.bareita.valheimmod.entity.custom.TrollEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TrollRenderer extends MobRenderer<TrollEntity, troll<TrollEntity>> {
    public TrollRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new troll<>(pContext.bakeLayer(ModModelLayers.TROLL_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TrollEntity pEntity) {
        return new ResourceLocation(ValheimMod.MODID,"textures/entity/troll.png");
    }

    @Override
    public void render(TrollEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f,0.5f,0.5f);
        }
        pPoseStack.scale(2.5f,2.5f,2.5f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
