package net.snackbag.wgoffset;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorldgenOffset implements ModInitializer {
	public static final String MOD_ID = "worldgen-offset";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ModConfig CONFIG = new ModConfig();

	@Override
	public void onInitialize() {
		LOGGER.info("(Worldgen Offset) Loading config...");
		CONFIG.reload();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
