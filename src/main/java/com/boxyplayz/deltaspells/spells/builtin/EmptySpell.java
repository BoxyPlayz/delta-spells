package com.boxyplayz.deltaspells.spells.builtin;

import com.boxyplayz.deltaspells.spells.Spell;
import com.boxyplayz.deltaspells.spells.SpellReturnType;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EmptySpell extends Spell {

	public EmptySpell(Identifier Id, byte Cost) {
		super(Id, Cost);
	}

	@Override
	public String getName() {
		return "undefined";
	}

	@Override
	public String getDescription() {
		return "this should not be possible";
	}

	@Override
	public SpellReturnType customUse(Level level, Player player) {
		return SpellReturnType.FAIL;
	}

}
