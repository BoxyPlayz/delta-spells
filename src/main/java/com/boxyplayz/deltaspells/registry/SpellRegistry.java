package com.boxyplayz.deltaspells.registry;

import org.jspecify.annotations.NonNull;

import com.boxyplayz.deltaspells.DeltaSpells;
import com.boxyplayz.deltaspells.spells.Spell;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class SpellRegistry {
	public static final @NonNull ResourceKey<Registry<Spell>> SPELL_REGISTRY_KEY = ResourceKey
			.createRegistryKey(DeltaSpells.id("spells"));

	public static final Registry<Spell> SPELL_REGISTRY = FabricRegistryBuilder.create(SPELL_REGISTRY_KEY)
			.buildAndRegister();

	public static void init() {
	}

}
