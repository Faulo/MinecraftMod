package net.slothsoft.minecraft.sloth;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class SlothEntity extends Sheep {

	protected SlothEntity(EntityType<? extends Sheep> animal, Level level) {
		super(animal, level);
		// TODO Auto-generated constructor stub
	}

	private static final double maxHealth = 100D;
	private static final double moveSpeed = 0.1D;

	@Override
	public boolean isFood(ItemStack item) {
		return item.is(Items.MELON_SLICE) || item.is(Items.POPPY) || item.is(Items.DANDELION) || item.is(Items.FERN)
				|| item.is(Items.LARGE_FERN);
	}

	@Override
	public Sheep getBreedOffspring(ServerLevel level, AgeableMob parent) {
		return MobInit.SLOTH.get().create(level);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		goalSelector.removeAllGoals();

		goalSelector.addGoal(0, new FloatGoal(this));
		goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.of(Items.MELON_SLICE), false));
		goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));

		goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}

	public static boolean canSpawn(EntityType<SlothEntity> entity, LevelAccessor levelAccess, MobSpawnType spawnType,
			BlockPos pos, Random random) {
		return checkAnimalSpawnRules(entity, levelAccess, spawnType, pos, random)
				&& levelAccess instanceof final Level level;
	}

	public static AttributeSupplier.Builder createCustomAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, maxHealth).add(Attributes.MOVEMENT_SPEED,
				moveSpeed);
	}

	@javax.annotation.Nonnull
	@Override
	public java.util.List<ItemStack> onSheared(@Nullable Player player, @javax.annotation.Nonnull ItemStack item,
			Level world, BlockPos pos, int fortune) {
		world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS,
				1.0F, 1.0F);
		this.gameEvent(GameEvent.SHEAR, player);
		if (!world.isClientSide) {
			this.setSheared(true);
			int i = 1 + this.random.nextInt(3);

			java.util.List<ItemStack> items = new java.util.ArrayList<>();
			for (int j = 0; j < i; ++j) {
				items.add(new ItemStack(Items.MOSS_BLOCK));
			}
			return items;
		}
		return java.util.Collections.emptyList();
	}
	
	
	@Override
    protected SoundEvent getAmbientSound() {
    	return SoundRegistrator.ENTITY_SLOTH_IDLE;
	}

	@Override
    protected SoundEvent getHurtSound(DamageSource p_29872_) {
    	return SoundRegistrator.ENTITY_SLOTH_HURT;
    }

	@Override
    protected SoundEvent getDeathSound() {
    	return SoundRegistrator.ENTITY_SLOTH_DEATH;
    }

	@Override
    protected void playStepSound(BlockPos p_29861_, BlockState p_29862_) {
    	this.playSound(SoundEvents.SHEEP_STEP, 0.15F, 1.0F);
    }
}
