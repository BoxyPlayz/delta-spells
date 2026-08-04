package com.boxyplayz.deltaspells.spells.builtin;

import com.boxyplayz.deltaspells.DeltaSpells;
import com.boxyplayz.deltaspells.spells.Spell;
import com.boxyplayz.deltaspells.spells.SpellReturnType;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class HealSelfSpell extends Spell {

	public HealSelfSpell(Identifier Id, byte Cost) {
		super(Id, Cost);
	}

	@Override
	public String getName() {
		return "SelfHeal";
	}

	@Override
	public String getDescription() {
		return "Heal by 4HP";
	}

	@Override
	public SpellReturnType use(Level level, Player player) {
		byte tp = player.getAttachedOrElse(DeltaSpells.TP_ATTACHMENT, (byte) 0);
		if (tp < getCost()) {
			return new SpellReturnType(true, "Not enough TP");
		}

		if (player.getHealth() + 4 < player.getMaxHealth()) {
			player.heal(4);
		} else if (player.getHealth() <= player.getMaxHealth()) {
			player.setHealth(player.getMaxHealth());
		} else {
			return new SpellReturnType(true, "You're already healed!");
		}

		tp -= (byte) getCost();

		player.setAttached(DeltaSpells.TP_ATTACHMENT, tp);

		return SpellReturnType.SUCCESS;
	}

}
