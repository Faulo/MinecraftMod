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

public class SlothModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "geometry.sloth"), "main");
    private final ModelPart Body;
    private final ModelPart Legs;

    public SlothModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.Legs = root.getChild("Legs");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, 0.0F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, 1.0F, -10.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Legs = partdefinition.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

        PartDefinition Arm_Left = Legs.addOrReplaceChild("Arm_Left", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, 0.0F, -5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(8.0F, 1.0F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(12.0F, 1.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Leg_Left = Legs.addOrReplaceChild("Leg_Left", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, 0.0F, 2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(7.0F, 1.0F, 2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(10.0F, 1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Arm_Right = Legs.addOrReplaceChild("Arm_Right", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, 0.0F, -5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-12.0F, 1.0F, -4.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-15.0F, 1.0F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Leg_Right = Legs.addOrReplaceChild("Leg_Right", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-7.0F, 0.0F, 2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-10.0F, 1.0F, 2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-13.0F, 1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        Legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
