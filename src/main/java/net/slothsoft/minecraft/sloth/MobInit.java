package net.slothsoft.minecraft.sloth;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MobInit {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			Constants.MOD_ID);

	public static final RegistryObject<EntityType<SlothEntity>> SLOTH = ENTITIES.register("sloth",
			() -> EntityType.Builder.<SlothEntity>of(SlothEntity::new, MobCategory.CREATURE).sized(1.0f, 1.0f)
					.build(new ResourceLocation(Constants.MOD_ID, "sloth").toString()));

	@SubscribeEvent
	public static final void entityAttributeCreation(EntityAttributeCreationEvent event) {
		event.put(MobInit.SLOTH.get(), createCustomAttributes().build());
	}
	@SubscribeEvent
	public static final void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(SlothModel.LAYER_LOCATION, SlothModel::createBodyLayer);
	}
	@SubscribeEvent
	public static final void reigsterRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MobInit.SLOTH.get(), SlothRenderer::new);
	}

	public static AttributeSupplier.Builder createCustomAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 100)
				.add(Attributes.MOVEMENT_SPEED, 0);
	}
}
