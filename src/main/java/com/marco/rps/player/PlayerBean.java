package com.marco.rps.player;

import com.marco.rps.type.Roshambo;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public class PlayerBean implements Player {

	private final String name;

	private final Roshambo[] roshambos = Roshambo.values();

	public PlayerBean(final String name) {
		this.name = name;
	}

	@Override
	public Roshambo play() {
		int roshamboIndex = ThreadLocalRandom.current().nextInt(MAX_INDEX);
		return roshambos[roshamboIndex];
	}

	@Override
	public String playerName() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PlayerBean))
			return false;
		PlayerBean that = (PlayerBean) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
