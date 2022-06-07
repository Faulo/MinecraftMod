// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class SlothModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "slothmodel"), "main");
	private final ModelPart body;
	private final ModelPart legs;

	public SlothModel(ModelPart root) {
		this.body = root.getChild("body");
		this.legs = root.getChild("legs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(26, 2).addBox(-1.0F, 0.0F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 14).addBox(-1.0F, 1.0F, -10.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition arm_left = legs.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(13, 19).addBox(4.0F, 0.0F, -5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 19).addBox(8.0F, 1.0F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(12.0F, 1.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg_left = legs.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(9, 24).addBox(4.0F, 0.0F, 2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(7.0F, 1.0F, 2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(10.0F, 1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm_right = legs.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(16, 14).addBox(-8.0F, 0.0F, -5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 24).addBox(-12.0F, 1.0F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-15.0F, 1.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg_right = legs.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(0, 21).addBox(-7.0F, 0.0F, 2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-10.0F, 1.0F, 2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(-13.0F, 1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}