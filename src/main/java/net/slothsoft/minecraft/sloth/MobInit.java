package net.slothsoft.minecraft.sloth;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class MobInit {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			Constants.MOD_ID);

	public static final RegistryObject<EntityType<Sloth>> SLOTH = ENTITIES.register("sloth",
			() -> EntityType.Builder.<Sloth>of(Sloth::new, MobCategory.CREATURE).sized(1.0f, 1.0f)
					.build(new ResourceLocation(Constants.MOD_ID, "sloth").toString()));

	@SubscribeEvent
	public static final void entityAttributeCreation(EntityAttributeCreationEvent event) {
		event.put(MobInit.SLOTH.get(), createCustomAttributes().build());
	}

	public static AttributeSupplier.Builder createCustomAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 100)
				.add(Attributes.MOVEMENT_SPEED, 0);
	}
}
