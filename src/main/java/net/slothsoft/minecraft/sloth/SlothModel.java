package net.slothsoft.minecraft.sloth;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class SlothModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "slothmodel"), "main");
	private final ModelPart sloth;

	public SlothModel(ModelPart root) {
		this.sloth = root.getChild("sloth");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sloth = partdefinition.addOrReplaceChild("sloth", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = sloth.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(26, 2)
						.addBox(-1.0F, 0.0F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 14)
						.addBox(-2.0F, -2.0F, -3.75F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 14)
						.addBox(-1.0F, 0.0F, -4.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.0F, -5.25F));

		PartDefinition legs = sloth.addOrReplaceChild("legs", CubeListBuilder.create(),
				PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arm_left = legs.addOrReplaceChild("arm_left",
				CubeListBuilder.create().texOffs(13, 19)
						.addBox(0.2F, -1.3333F, -1.6667F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(24, 19)
						.addBox(4.2F, -0.3333F, -0.6667F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 0)
						.addBox(8.2F, -0.3333F, -0.6667F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.8F, 1.3333F, -3.3333F));

		PartDefinition leg_left = legs.addOrReplaceChild("leg_left",
				CubeListBuilder.create().texOffs(9, 24)
						.addBox(0.2F, -1.3333F, -1.3333F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 3)
						.addBox(3.2F, -0.3333F, -1.3333F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
						.addBox(6.2F, -0.3333F, -0.3333F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.8F, 1.3333F, 3.3333F));

		PartDefinition arm_right = legs.addOrReplaceChild("arm_right",
				CubeListBuilder.create().texOffs(16, 14)
						.addBox(-4.2F, -1.3333F, -1.6667F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(18, 24)
						.addBox(-8.2F, -0.3333F, -0.6667F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-11.2F, -0.3333F, -0.6667F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.8F, 1.3333F, -3.3333F));

		PartDefinition leg_right = legs.addOrReplaceChild("leg_right",
				CubeListBuilder.create().texOffs(0, 21)
						.addBox(-3.2F, -1.3333F, -1.3333F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-6.2F, -0.3333F, -1.3333F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 6)
						.addBox(-9.2F, -0.3333F, -0.3333F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.8F, 1.3333F, 3.3333F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		sloth.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}