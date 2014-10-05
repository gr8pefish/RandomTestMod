package main.randomtestmod.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import main.randomtestmod.RandomTestMod;
import main.randomtestmod.client.gui.BaseBook.ItemGuiBaseBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 0) {
			RandomTestMod.logger.info("Open Gui");
			return new ItemGuiBaseBook();
		}
		return null;
	}
}
