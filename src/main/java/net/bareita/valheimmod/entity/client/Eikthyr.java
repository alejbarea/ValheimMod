package net.bareita.valheimmod.entity.client;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bareita.valheimmod.entity.animations.ModAnimationDefinitions;
import net.bareita.valheimmod.entity.custom.EikthyrEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class Eikthyr<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "eikthyr"), "main");
	private final ModelPart Eikthyr;
	private final ModelPart body;
	private final ModelPart legs;
	private final ModelPart front_left_leg;
	private final ModelPart front_right_leg;
	private final ModelPart hind_left_leg;
	private final ModelPart hind_right_leg;
	private final ModelPart chest;
	private final ModelPart head;

	public Eikthyr(ModelPart root) {
		this.Eikthyr = root.getChild("Eikthyr");
		this.body = this.Eikthyr.getChild("body");
		this.legs = this.body.getChild("legs");
		this.front_left_leg = this.legs.getChild("front_left_leg");
		this.front_right_leg = this.legs.getChild("front_right_leg");
		this.hind_left_leg = this.legs.getChild("hind_left_leg");
		this.hind_right_leg = this.legs.getChild("hind_right_leg");
		this.chest = this.body.getChild("chest");
		this.head = this.body.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Eikthyr = partdefinition.addOrReplaceChild("Eikthyr", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = Eikthyr.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition front_left_leg = legs.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(32, 35).addBox(3.0F, -7.0F, 2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition front_right_leg = legs.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -5.0F, 0.0F));

		PartDefinition hind_left_leg = legs.addOrReplaceChild("hind_left_leg", CubeListBuilder.create().texOffs(13, 24).addBox(3.0F, -7.0F, -5.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hind_right_leg = legs.addOrReplaceChild("hind_right_leg", CubeListBuilder.create().texOffs(0, 24).addBox(-6.0F, -7.0F, 2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(40, 41).addBox(7.0F, -12.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -13.0F, -5.0F, 15.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 17).addBox(-17.0F, -18.0F, -2.0F, 11.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 28).addBox(-13.0F, -21.0F, -2.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 35).addBox(-11.0F, -25.0F, 1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(-11.0F, -26.0F, 3.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(21, 17).addBox(-11.0F, -26.0F, -12.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(39, 0).addBox(-11.0F, -25.0F, -3.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 17).addBox(-11.0F, -16.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 35).addBox(-11.0F, -24.0F, -12.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 35).addBox(-11.0F, -34.0F, -8.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-11.0F, -34.0F, 6.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 35).addBox(-11.0F, -24.0F, 10.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationDefinitions.EIKTHYR_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((EikthyrEntity) entity).idleAnimationState, ModAnimationDefinitions.EIKTHYR_IDLE, ageInTicks, 1f);
		this.animate(((EikthyrEntity) entity).attackAnimationState, ModAnimationDefinitions.EIKTHYR_ATTACK, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Eikthyr.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.Eikthyr;
	}
}