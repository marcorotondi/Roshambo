package com.marco.rps.player;

import com.marco.rps.type.Roshambo;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public class Computer implements Player {

	private final String name = "Computer";

	private final Roshambo[] roshambos = Roshambo.values();

	@Override
	public Roshambo play() {
		int roshamboIndex = ThreadLocalRandom.current().nextInt(MAX_INDEX);
		return roshambos[roshamboIndex];
	}
}
