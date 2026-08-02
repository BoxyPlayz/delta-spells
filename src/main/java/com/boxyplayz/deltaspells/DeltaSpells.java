package com.boxyplayz.deltaspells;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boxyplayz.deltaspells.registry.SpellRegistry;
import com.boxyplayz.deltaspells.spells.Spells;

public class DeltaSpells implements ModInitializer {
	public static final String MOD_ID = "delta_spells";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		SpellRegistry.init();
		Spells.init();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}

	public static @NonNull Identifier id(@NonNull String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
