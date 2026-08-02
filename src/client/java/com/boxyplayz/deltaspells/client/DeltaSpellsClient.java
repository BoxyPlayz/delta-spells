package com.boxyplayz.deltaspells.client;

import com.boxyplayz.deltaspells.client.keymap.DeltaSpellsKeymaps;

import net.fabricmc.api.ClientModInitializer;

public class DeltaSpellsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		DeltaSpellsKeymaps.init();
	}
}