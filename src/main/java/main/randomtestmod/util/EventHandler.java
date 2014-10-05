package main.randomtestmod.util;

/*
 * Class for most of your events to be registered in.
 * Remember that there are two different registries for Events. This one will not work for everything.
 */

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import main.randomtestmod.RandomTestMod;
import main.randomtestmod.ConfigHandler;
import main.randomtestmod.ModInformation;

public class EventHandler {

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.modID.equals(ModInformation.ID)) {
			ConfigHandler.syncConfig();
			RandomTestMod.logger.info(TextHelper.localize("info.randomtestmod.console.config.refresh"));
		}
	}
}
