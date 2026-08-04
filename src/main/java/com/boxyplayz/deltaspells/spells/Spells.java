package com.boxyplayz.deltaspells.spells;

import org.jspecify.annotations.NonNull;

import com.boxyplayz.deltaspells.DeltaSpells;
import com.boxyplayz.deltaspells.registry.SpellRegistry;
import com.boxyplayz.deltaspells.spells.builtin.HealSelfSpell;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;

public class Spells {
	private static <T extends Spell> T registerSpell(@NonNull String name, T spell) {
		Identifier id = Identifier.fromNamespaceAndPath(DeltaSpells.MOD_ID, name);
		return Registry.register(SpellRegistry.SPELL_REGISTRY, id, spell);
	}

	public static final HealSelfSpell HEAL_SELF = registerSpell("heal_self",
			new HealSelfSpell(DeltaSpells.id("heal_self"), (byte) 16));

	public static void init() {

	}

}
