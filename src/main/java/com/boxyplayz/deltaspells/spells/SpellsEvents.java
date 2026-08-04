package com.boxyplayz.deltaspells.spells;

import com.boxyplayz.deltaspells.DeltaSpells;
import com.boxyplayz.deltaspells.networking.ServerboundCastSpellPayload;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class SpellsEvents {
	public static void init() {
		ServerPlayNetworking.registerGlobalReceiver(ServerboundCastSpellPayload.TYPE, (payload, context) -> {
			Entity entity = context.player().level().getEntity(payload.playerId());
			if (entity instanceof Player player) {
				SpellReturnType spellReturned = payload.selected().use(entity.level(), player);
				if (spellReturned.errored) {
					DeltaSpells.LOGGER.error(spellReturned.message.orElse("Error: [No Context Provided]"));
				}
			}
		});
	}
}
