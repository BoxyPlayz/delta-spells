package com.boxyplayz.deltaspells.spells;

import com.boxyplayz.deltaspells.DeltaSpells;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class Spell {
	protected Identifier id;
	protected byte cost;

	public abstract String getName();

	public abstract String getDescription();

	public SpellReturnType use(final Level level, final Player player) {
		byte tp = player.getAttachedOrElse(DeltaSpells.TP_ATTACHMENT, (byte) 0);
		if (tp < cost) {
			return new SpellReturnType(true, "Not enough TP");
		}

		SpellReturnType returnVal = customUse(level, player);

		if (!returnVal.errored) {
			tp -= (byte) getCost();

			player.setAttached(DeltaSpells.TP_ATTACHMENT, tp);
		}

		return returnVal;
	}

	public abstract SpellReturnType customUse(final Level level, final Player player);

	public Spell(Identifier Id, byte Cost) {
		this.id = Id;
		this.cost = Cost;
	}

	public Identifier getId() {
		return this.id;
	}

	public boolean is(Spell spell) {
		return spell.getId() == this.id;
	}

	public byte getCost() {
		return this.cost;
	}
}
