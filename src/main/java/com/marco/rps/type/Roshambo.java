package com.marco.rps.type;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public enum Roshambo {
	ROCK, PAPER, SCISSORS;

	/**
	 * Return a roshambo result
	 *
	 * @param other
	 * @return 0 Patta
	 * 			1 Player 1 win
	 * 			2 Player 2 win
	 */
	public int roshamboResult(Roshambo other) {
		int result = 0;
		if (this != other) {
			if (this == ROCK && other == SCISSORS ||
					this == SCISSORS && other == PAPER ||
					this == PAPER && other == ROCK) {
				result = 1;
			} else if (other == ROCK && this == SCISSORS ||
						other == SCISSORS && this == PAPER ||
						other == PAPER && this == ROCK) {
				result = 2;
			}
		}

		return result;
	}
}
