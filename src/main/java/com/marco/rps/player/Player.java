package com.marco.rps.player;

import com.marco.rps.type.Roshambo;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public interface Player {
	int MAX_INDEX = 3;

	String COMPUTER = "Computer";

	Roshambo play();

	String playerName();
}
