package com.boxyplayz.deltaspells;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boxyplayz.deltaspells.networking.ServerboundCastSpellPayload;
import com.boxyplayz.deltaspells.registry.SpellRegistry;
import com.boxyplayz.deltaspells.spells.Spell;
import com.boxyplayz.deltaspells.spells.Spells;
import com.boxyplayz.deltaspells.spells.SpellsEvents;
import com.mojang.serialization.Codec;

public class DeltaSpells implements ModInitializer {
	public static final String MOD_ID = "delta_spells";

	public static final AttachmentType<Byte> TP_ATTACHMENT = AttachmentRegistry.create(
			id("tp_energy"),
			builder -> builder
					.initializer(() -> (byte) 0) // The default value of the Attachment, if one has not been set.
					.syncWith(
							ByteBufCodecs.BYTE, // Dictates how to turn the data into a packet to send to clients.
							AttachmentSyncPredicate.targetOnly() // Dictates who to send the data to.
					)
					.persistent(Codec.BYTE));

	public static final AttachmentType<Spell> SELECTED_SPELL = AttachmentRegistry.create(
			id("selected_spell"),
			builder -> builder
					.initializer(() -> Spells.EMPTY) // The default value of the Attachment, if one has not been set.
					.syncWith(
							ByteBufCodecs.registry(SpellRegistry.SPELL_REGISTRY_KEY), // Dictates how to turn the data
																						// into a packet to send to
																						// clients.
							AttachmentSyncPredicate.targetOnly() // Dictates who to send the data to.
					));

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

		PayloadTypeRegistry.serverboundPlay().register(ServerboundCastSpellPayload.TYPE,
				ServerboundCastSpellPayload.CODEC);

		SpellsEvents.init();
	}

	public static @NonNull Identifier id(@NonNull String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
