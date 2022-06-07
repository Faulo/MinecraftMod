package net.slothsoft.minecraft.sloth;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WorldData;

import java.util.Random;

public class SlothEntity extends Animal {

	protected SlothEntity(EntityType<? extends Animal> animal, Level level) {
		super(animal, level);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
		return MobInit.SLOTH.get().create(level);
	}

	@Override
	protected void registerGoals() {
		goalSelector.addGoal(0, new TemptGoal(this, 100, Ingredient.of(ItemInit.EXAMPLE_BLOCK.get()), false));
	}

	public static boolean canSpawn(EntityType<SlothEntity> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, Random random)
	{
		return checkAnimalSpawnRules(entity, levelAccess, spawnType, pos, random)
				&& levelAccess instanceof final Level level;
	}
}
