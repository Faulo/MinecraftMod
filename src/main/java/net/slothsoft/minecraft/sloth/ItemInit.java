package net.slothsoft.minecraft.sloth;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

	// Block Items
	public static final RegistryObject<ForgeSpawnEggItem> SLOTH_EGG = ITEMS.register("sloth_spawn_egg",
			() -> new ForgeSpawnEggItem(MobInit.SLOTH, 0xa1a29d, 0x896e5c,
					new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
}