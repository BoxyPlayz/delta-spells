package com.boxyplayz.deltaspells.spells.builtin;

import com.boxyplayz.deltaspells.spells.Spell;
import com.boxyplayz.deltaspells.spells.SpellReturnType;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class HealSelfSpell extends Spell {

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
		if (player.getHealth() + 4 < player.getMaxHealth()) {
			player.heal(4);
		} else if (player.getHealth() + 4 == player.getMaxHealth()) {
			player.setHealth(player.getMaxHealth());
		} else {
			return new SpellReturnType(true, "You're already healed!");
		}
		return SpellReturnType.SUCCESS;
	}

}
