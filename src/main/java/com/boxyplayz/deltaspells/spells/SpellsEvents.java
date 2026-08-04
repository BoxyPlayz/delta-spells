package com.boxyplayz.deltaspells.spells;

import com.boxyplayz.deltaspells.DeltaSpells;
import com.boxyplayz.deltaspells.networking.ServerboundCastSpellPayload;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;

public class SpellsEvents {
	public static void init() {
		ServerPlayNetworking.registerGlobalReceiver(ServerboundCastSpellPayload.TYPE, (payload, context) -> {
			SpellReturnType spellReturned = payload.selected().use(context.player().level(), context.player());
			if (spellReturned.errored) {
				DeltaSpells.LOGGER.error(spellReturned.message.orElse("Error: [No Context Provided]"));
			}
		});

		ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, baseDamageTaken, damageTaken, blocked) -> {
			if (entity instanceof ServerPlayer player) {
				if (player.getAttachedOrElse(DeltaSpells.TP_ATTACHMENT, (byte) 0) > 100)
					return;

				int newTP = player.getAttachedOrElse(DeltaSpells.TP_ATTACHMENT, (byte) 0)
						+ (int) Math.floor(baseDamageTaken);

				if (newTP > 100)
					newTP = 100;

				player.setAttached(DeltaSpells.TP_ATTACHMENT, (byte) newTP);

			}
		});
	}
}
