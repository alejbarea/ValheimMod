package net.bareita.valheimmod.entity.client;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bareita.valheimmod.entity.animations.ModAnimationDefinitions;
import net.bareita.valheimmod.entity.custom.TrollEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class troll<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart troll;
	private final ModelPart cabeza;
	private final ModelPart torso;
	private final ModelPart brazo_izq;
	private final ModelPart brazo_der;
	private final ModelPart pata_der;
	private final ModelPart pata_izq;
	public troll(ModelPart root) {
		this.troll = root.getChild("troll");
		this.cabeza = this.troll.getChild("body").getChild("cabeza");
		this.torso = this.troll.getChild("body").getChild("torso");
		this.brazo_izq = this.troll.getChild("body").getChild("brazo_izq");
		this.brazo_der = this.troll.getChild("body").getChild("brazo_der");
		this.pata_der = this.troll.getChild("body").getChild("pata_der");
		this.pata_izq = this.troll.getChild("body").getChild("pata_izq");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition troll = partdefinition.addOrReplaceChild("troll", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, (float)Math.PI / 2, 0.0F));

		PartDefinition body = troll.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cabeza = body.addOrReplaceChild("cabeza", CubeListBuilder.create().texOffs(39, 39).addBox(-1.0F, -24.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(-2.0F, -33.0F, -4.0F, 9.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(25, 27).addBox(3.0F, -29.5F, -1.5F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(7.0F, -32.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, 0).addBox(7.0F, -32.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -23.0F, -7.0F, 5.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition brazo_izq = body.addOrReplaceChild("brazo_izq", CubeListBuilder.create().texOffs(36, 12).addBox(-2.0F, -22.0F, 4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(35, 0).addBox(-2.0F, -22.0F, 7.0F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition brazo_der = body.addOrReplaceChild("brazo_der", CubeListBuilder.create().texOffs(32, 30).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(36, 19).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.0F, -8.0F));

		PartDefinition pata_der = body.addOrReplaceChild("pata_der", CubeListBuilder.create().texOffs(23, 0).addBox(-2.0F, -9.0F, -6.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition pata_izq = body.addOrReplaceChild("pata_izq", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
		this.animateWalk(ModAnimationDefinitions.ANDAR, limbSwing, limbSwingAmount, 1f, 1f);
		this.animate(((TrollEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 0.5f);
		this.animate(((TrollEntity) entity).attackAnimationState, ModAnimationDefinitions.ATAQUE, ageInTicks, 0.5f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -2.5F, 2.5F);

		this.cabeza.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		troll.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.troll;
	}
}