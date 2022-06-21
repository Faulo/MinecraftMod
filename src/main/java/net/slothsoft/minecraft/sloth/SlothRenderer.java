package net.slothsoft.minecraft.sloth;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SlothRenderer extends MobRenderer<SlothEntity, SlothModel<SlothEntity>> {

	static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entities/sloth.png");

	public SlothRenderer(EntityRendererProvider.Context context, SlothModel<SlothEntity> model, float p_174306_) {
		super(context, model, p_174306_);
		this.addLayer(new SlothMossLayer(this, context.getModelSet()));
	}

	public SlothRenderer(Context context) {
		this(context, new SlothModel<SlothEntity>(context.bakeLayer(SlothModel.LAYER_LOCATION)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(SlothEntity entity) {
		return TEXTURE;
	}

}
