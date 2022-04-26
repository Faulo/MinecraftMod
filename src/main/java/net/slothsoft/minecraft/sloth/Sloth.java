package net.slothsoft.minecraft.sloth;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class Sloth extends Animal {

	protected Sloth(EntityType<? extends Animal> animal, Level level) {
		super(animal, level);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
		// TODO Auto-generated method stub
		return null;
	}
}
