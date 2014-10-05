package main.randomtestmod;

/*
 * Check all the classes for (hopefully) detailed descriptions of what it does. There will also be tidbits of comments throughout the codebase.
 * If you wish to add a description to a class, or extend/change an existing one, submit a PR with your changes.
 */

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import main.randomtestmod.blocks.BlockRecipeRegistry;
import main.randomtestmod.blocks.BlockRegistry;
import main.randomtestmod.client.gui.CreativeTabBaseMod;
import main.randomtestmod.client.gui.GuiHandler;
import main.randomtestmod.items.ItemRecipeRegistry;
import main.randomtestmod.items.ItemRegistry;
import main.randomtestmod.proxies.CommonProxy;
import main.randomtestmod.util.EventHandler;
import main.randomtestmod.util.GenerationHandler;
import main.randomtestmod.util.OreDictHandler;
import net.minecraft.creativetab.CreativeTabs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND, guiFactory = ModInformation.GUIFACTORY)
public class RandomTestMod {

	@SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
	public static CommonProxy proxy;

	public static CreativeTabs tabBaseMod = new CreativeTabBaseMod(ModInformation.ID + ".creativeTab");
	public static Logger logger = LogManager.getLogger(ModInformation.NAME);

	@Mod.Instance
	public static RandomTestMod instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger.info("Begin Pre-initialization");

		ConfigHandler.init(event.getSuggestedConfigurationFile());

		ItemRegistry.registerItems();
		BlockRegistry.registerBlocks();

		OreDictHandler.registerOreDict();
		FMLCommonHandler.instance().bus().register(new EventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		GameRegistry.registerWorldGenerator(new GenerationHandler(), 2);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("Begin Initialization");

		ItemRecipeRegistry.registerItemRecipes();
		BlockRecipeRegistry.registerBlockRecipes();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info("Begin Post-initialization");
	}
}
