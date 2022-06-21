package net.slothsoft.minecraft.sloth;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MobSpawner {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void biomeLoading(BiomeLoadingEvent event) {
		event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MobInit.SLOTH.get(),
				Constants.SLOTH_SPAWN_WEIGHT, Constants.SLOTH_SPAWN_AMOUNT_MIN, Constants.SLOTH_SPAWN_AMOUNT_MAX));
	}
}
