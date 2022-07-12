package net.slothsoft.minecraft.sloth;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class SoundRegistrator {
    public static final SoundEvent ENTITY_SLOTH_HURT;
    public static final SoundEvent ENTITY_SLOTH_IDLE;
    public static final SoundEvent ENTITY_SLOTH_DEATH;

    static {
    	ENTITY_SLOTH_HURT = addSoundsToRegistry("entity.sloth.hurt");
    	ENTITY_SLOTH_IDLE = addSoundsToRegistry("entity.sloth.ambient");
    	ENTITY_SLOTH_DEATH = addSoundsToRegistry("entity.sloth.death");
    }

    private static SoundEvent addSoundsToRegistry(String soundId) {
        ResourceLocation shotSoundLocation = new ResourceLocation("slothmod", soundId);
        SoundEvent soundEvent = new SoundEvent(shotSoundLocation);
        soundEvent.setRegistryName(shotSoundLocation);
        return soundEvent;
    }       
}