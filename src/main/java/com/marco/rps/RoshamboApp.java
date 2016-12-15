package com.marco.rps;

import com.marco.rps.data.GameResult;
import com.marco.rps.player.Player;
import com.marco.rps.player.PlayerBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.Console;

import static com.marco.rps.player.Player.COMPUTER;
import static com.marco.rps.utils.RoshamboUtils.getGamesRunning;
import static com.marco.rps.utils.RoshamboUtils.getPlayerName;
import static com.marco.rps.utils.RoshamboUtils.playGames;
import static com.marco.rps.utils.RoshamboUtils.printResult;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public class RoshamboApp {

	public static void main(String[] args) {
		final Console console = System.console();
		System.out.println("Please select number of Player: 1 = One Player, 2 = Two Player");
		String readLinePlayer = console.readLine();

		if (StringUtils.isNoneBlank(readLinePlayer)) {
			final int numPlayer = NumberUtils.toInt(readLinePlayer);
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
				throw new IllegalArgumentException("Invalid Value for Number of Player enter.");
			}
		} else {
			throw new IllegalArgumentException("Empty Value for Number of Player enter.");
		}
	}
}
