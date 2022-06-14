package net.slothsoft.minecraft.sloth;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class SlothBabyModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "slothbabymodel"), "main");
	private final ModelPart sloth;

	public SlothBabyModel(ModelPart root) {
		this.sloth = root.getChild("sloth");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sloth = partdefinition.addOrReplaceChild("sloth", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = sloth.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(10, 20).addBox(-1.0F, -2.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, -2.0F, -3.75F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(19, 4).addBox(-1.0F, 0.0F, -4.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.25F));

		PartDefinition legs = sloth.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm_left = legs.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(19, 0).addBox(0.2F, -1.3333F, -1.6667F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, -0.6667F, -2.3333F));

		PartDefinition arm_left_ellbow = arm_left.addOrReplaceChild("arm_left_ellbow", CubeListBuilder.create().texOffs(8, 18).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.2F, 0.1667F, -0.1667F));

		PartDefinition leg_left = legs.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(0, 18).addBox(0.2F, -1.3333F, -1.3333F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.8F, -0.6667F, 1.3333F));

		PartDefinition leg_left_knee = leg_left.addOrReplaceChild("leg_left_knee", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.2F, 0.1667F, 0.1667F));

		PartDefinition arm_right = legs.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(12, 11).addBox(-3.2F, -1.3333F, -1.6667F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, -0.6667F, -2.3333F, 0.0F, 0.0F, 0.0F));

		PartDefinition arm_right_ellbow = arm_right.addOrReplaceChild("arm_right_ellbow", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.2F, 0.1667F, 0.3333F));

		PartDefinition leg_right = legs.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(14, 16).addBox(-3.2F, -1.3333F, -1.3333F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.8F, -0.6667F, 1.3333F));

		PartDefinition leg_right_knee = leg_right.addOrReplaceChild("leg_right_knee", CubeListBuilder.create().texOffs(0, 2).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.2F, 0.1667F, 0.1667F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		sloth.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}