package com.boxyplayz.deltaspells.networking;

import com.boxyplayz.deltaspells.DeltaSpells;
import com.boxyplayz.deltaspells.registry.SpellRegistry;
import com.boxyplayz.deltaspells.spells.Spell;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record ServerboundCastSpellPayload(Spell selected) implements CustomPacketPayload {

	public static final Identifier CAST_SPELL_PAYLOAD_ID = DeltaSpells.id("cast_spell_payload");

	public static final CustomPacketPayload.Type<ServerboundCastSpellPayload> TYPE = new CustomPacketPayload.Type<>(
			CAST_SPELL_PAYLOAD_ID);

	public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundCastSpellPayload> CODEC = StreamCodec
			.composite(ByteBufCodecs.registry(SpellRegistry.SPELL_REGISTRY_KEY), ServerboundCastSpellPayload::selected,
					ServerboundCastSpellPayload::new);

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

}
