package com.boxyplayz.deltaspells.client;

import com.boxyplayz.deltaspells.DeltaSpells;
import com.boxyplayz.deltaspells.client.gui.CustomUI;
import com.boxyplayz.deltaspells.client.keymap.DeltaSpellsKeymaps;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.resources.Identifier;

public class DeltaSpellsClient implements ClientModInitializer {

	public static final Identifier TPHudId = Identifier.fromNamespaceAndPath(DeltaSpells.MOD_ID, "tp_hud");

	@Override
	public void onInitializeClient() {
		DeltaSpellsKeymaps.init();

		HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, TPHudId, CustomUI::extract);
	}
}