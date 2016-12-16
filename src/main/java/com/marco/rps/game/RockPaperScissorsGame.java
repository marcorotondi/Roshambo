/**
 * 
 */
package com.marco.rps.game;

import com.marco.rps.data.GameResult;
import com.marco.rps.player.Player;
import com.marco.rps.player.PlayerBean;

import java.io.Console;

import static com.marco.rps.player.Player.COMPUTER;
import static com.marco.rps.utils.RoshamboUtils.getGamesRunning;
import static com.marco.rps.utils.RoshamboUtils.getNumberOfPlayer;
import static com.marco.rps.utils.RoshamboUtils.getPlayerName;
import static com.marco.rps.utils.RoshamboUtils.playGames;
import static com.marco.rps.utils.RoshamboUtils.printResult;

/**
 * @author marco.rotondi
 *
 */
public class RockPaperScissorsGame implements Game {
	private final Console console = System.console();

	public static RockPaperScissorsGame build() {
		return new RockPaperScissorsGame();
	}

	@Override
	public void play() {
		final int numPlayer = getNumberOfPlayer(console);
		final GameResult gameResult;
		int playGames;

		switch (numPlayer) {
		case 1:
			final Player player = new PlayerBean(getPlayerName(console));
			final Player computer = new PlayerBean(COMPUTER);
			playGames = getGamesRunning(console);

			gameResult = playGames(playGames, player, computer);
			printResult(playGames, player, computer, gameResult);
			break;
		case 2:
			final Player player1 = new PlayerBean(getPlayerName(console));
			final Player player2 = new PlayerBean(getPlayerName(console));
			playGames = getGamesRunning(console);

			gameResult = playGames(playGames, player1, player2);
			printResult(playGames, player1, player2, gameResult);
			break;
		default:
			throw new IllegalStateException("Invalid Flow.");
		}
	}

}
