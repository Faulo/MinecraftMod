package net.slothsoft.minecraft.sloth;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class Sloth extends Animal {

	protected Sloth(EntityType<? extends Animal> animal, Level level) {
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
}
