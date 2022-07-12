package net.slothsoft.minecraft.sloth;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Constants.MOD_ID)
public class Bootstrap {
	public Bootstrap() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		MobInit.ENTITIES.register(bus);
		
		MinecraftForge.EVENT_BUS.register(new SoundRegisterListener());
	}

	private void setup(final FMLCommonSetupEvent event) {
	}
}
