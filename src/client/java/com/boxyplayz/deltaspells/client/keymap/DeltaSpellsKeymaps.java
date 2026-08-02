package com.boxyplayz.deltaspells.client.keymap;

import com.boxyplayz.deltaspells.DeltaSpells;
import com.mojang.blaze3d.platform.InputConstants;

import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class DeltaSpellsKeymaps {
	public static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(
			Identifier.fromNamespaceAndPath(DeltaSpells.MOD_ID, "delta_spells"));

	public static final KeyMapping castSpellKey = KeyMappingHelper.registerKeyMapping(
			new KeyMapping(
					"key.delta_spells.cast_spell", // The translation key for the key mapping.
					InputConstants.Type.KEYSYM, // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
					InputConstants.KEY_RETURN, // The keycode of the key.
					CATEGORY // The category of the mapping.
			));

	public static final KeyMapping spellNextKey = KeyMappingHelper.registerKeyMapping(
			new KeyMapping(
					"key.delta_spells.spell_next", // The translation key for the key mapping.
					InputConstants.Type.KEYSYM, // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
					InputConstants.KEY_RIGHT, // The keycode of the key.
					CATEGORY // The category of the mapping.
			));

	public static final KeyMapping spellBackKey = KeyMappingHelper.registerKeyMapping(
			new KeyMapping(
					"key.delta_spells.spell_back", // The translation key for the key mapping.
					InputConstants.Type.KEYSYM, // The type of the keybinding; KEYSYM for keyboard, MOUSE for mouse.
					InputConstants.KEY_LEFT, // The keycode of the key.
					CATEGORY // The category of the mapping.
			));

	public static void init() {

	}
}
