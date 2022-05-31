package net.slothsoft.minecraft.sloth;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SlothRenderer<T extends SlothEntity> extends MobRenderer<T, SlothModel<T>> {

	static final ResourceLocation TEXTURE = new ResourceLocation(Constants.MOD_ID, "textures/entities/sloth.png");

	public SlothRenderer(Context context, SlothModel<T> model, float p_174306_) {
		super(context, model, p_174306_);
	}
	public SlothRenderer(Context context)  {

		this(context, new SlothModel<T>(context.bakeLayer(SlothModel.LAYER_LOCATION)), 0);
	}

	@Override
	public ResourceLocation getTextureLocation(T entity) {
		return TEXTURE;
	}

}
