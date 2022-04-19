package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {
	@SubscribeEvent
	public static void onPlayerLoggedInEvent(PlayerLoggedInEvent event) {
		var mc = Minecraft.getInstance();

		mc.gui.getChat().addMessage(new TextComponent("Hello World!"));
	}
}