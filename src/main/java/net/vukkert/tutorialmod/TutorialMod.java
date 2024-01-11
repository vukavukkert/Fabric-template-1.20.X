package net.vukkert.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.vukkert.tutorialmod.block.ModBlocks;
import net.vukkert.tutorialmod.item.ModItemGroups;
import net.vukkert.tutorialmod.item.Moditems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();

		Moditems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}