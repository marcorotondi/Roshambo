package com.marco.rps.player;

import com.marco.rps.type.Roshambo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public class PlayerTwo implements Player {

	private final String name;

	private final Roshambo[] roshambos = Roshambo.values();

	public PlayerTwo(final String name) {
		this.name = name;
	}

	@Override
	public Roshambo play() {
		int roshamboIndex = ThreadLocalRandom.current().nextInt(MAX_INDEX);
		return roshambos[roshamboIndex];
	}
}
