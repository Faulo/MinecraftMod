package net.slothsoft.minecraft.sloth;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;

public class SlothRenderer extends MobRenderer<Sheep, SheepModel<Sheep>> {

	static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entities/sloth.png");

	public SlothRenderer(EntityRendererProvider.Context context, SheepModel<T> model, float p_174306_) {
		super(context, model, p_174306_);
        this.addLayer(new SheepFurLayer(this, context.getModelSet()));
	}

	public SlothRenderer(Context context) {
		this(context, new SheepModel<Sheep>(context.bakeLayer(SlothModel.LAYER_LOCATION)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(Sheep entity) {
		return TEXTURE;
	}

}
