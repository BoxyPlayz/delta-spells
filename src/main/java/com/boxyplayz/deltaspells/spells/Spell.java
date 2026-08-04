package com.boxyplayz.deltaspells.spells;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class Spell {
	protected Identifier id;
	protected int cost;

	public abstract String getName();

	public abstract String getDescription();

	public abstract SpellReturnType use(final Level level, final Player player);

	public Spell(Identifier Id, int Cost) {
		this.id = Id;
		this.cost = Cost;
	}

	public Identifier getId() {
		return this.id;
	}

	public boolean is(Spell spell) {
		return spell.getId() == this.id;
	}

	public int getCost() {
		return this.cost;
	}
}
