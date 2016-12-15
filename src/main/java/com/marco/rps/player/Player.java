package com.marco.rps.player;

import com.marco.rps.type.Roshambo;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public interface Player {
	static final int MAX_INDEX = 3;

	Roshambo play();
}
