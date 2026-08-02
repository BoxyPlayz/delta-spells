package com.boxyplayz.deltaspells.spells;

import java.util.Optional;

public class SpellReturnType {
	public final boolean errored;
	public final Optional<String> message;

	public static final SpellReturnType SUCCESS = new SpellReturnType(false);
	public static final SpellReturnType FAIL = new SpellReturnType(true);

	public SpellReturnType(boolean error) {
		errored = error;
		message = Optional.empty();
	}

	public SpellReturnType(boolean error, String msg) {
		errored = error;
		message = Optional.of(msg);
	}
}