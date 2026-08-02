package com.boxyplayz.deltaspells.spells;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class Spell {
	public abstract String getName();

	public abstract String getDescription();

	public abstract SpellReturnType use(final Level level, final Player player);
}
