package com.marco.rps.utils;

import com.marco.rps.data.GameResult;
import com.marco.rps.player.Player;
import com.marco.rps.type.Roshambo;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.Console;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public class RoshamboUtils {

	public static GameResult playGames(final int runPlay, final Player playerOne, final Player playerTwo) {
		final GameResult gameResult = new GameResult();

		for (int index = 0; index < runPlay; index++) {
			final Roshambo playerOneGame = playerOne.play();
			final Roshambo playerTwoGame = playerTwo.play();

			System.out.println("----------------------");
			System.out.printf("Player {%s} play {%s}\n", playerOne.playerName(), playerOneGame);
			System.out.printf("Player {%s} play {%s}\n", playerTwo.playerName(), playerTwoGame);
			System.out.println("----------------------");

			switch (playerOneGame.roshamboResult(playerTwoGame)) {
			case 0:
				gameResult.addFirstResult(null);
				gameResult.addSecondResult(null);
				break;
			case 1:
				gameResult.addFirstResult(Boolean.TRUE);
				gameResult.addSecondResult(Boolean.FALSE);
				break;
			case 2:
				gameResult.addFirstResult(Boolean.FALSE);
				gameResult.addSecondResult(Boolean.TRUE);
				break;
			default:
				break;
			}
		}

		return gameResult;
	}

	public static String getPlayerName(Console console) {
		System.out.println("Please enter player name");
		final String playerName = console.readLine();

		if (StringUtils.isBlank(playerName)) {
			throw new IllegalArgumentException("Empty player name");
		}

		return playerName.trim();
	}

	public static int getGamesRunning(Console console) {
		System.out.println("Please enter number of game to play.");
		String readLineGames = console.readLine();

		if (StringUtils.isBlank(readLineGames)) {
			throw new IllegalArgumentException("Empty Number of games to play");
		}

		final int games = NumberUtils.toInt(readLineGames);
		if (0 == games) {
			throw new IllegalArgumentException("Invalid Number of games to play insert");
		}

		return games;
	}

	public static int getNumberOfPlayer(Console console) {
		System.out.println("Please select number of Player: 1 = One Player, 2 = Two Player");
		final String readLineNumberOfPlayer = console.readLine();
		if (StringUtils.isBlank(readLineNumberOfPlayer)) {
			throw new IllegalArgumentException("Empty Value for Number of Player enter.");
		}

		final int playersNumber = NumberUtils.toInt(readLineNumberOfPlayer);
		if (0 == playersNumber) {
			throw new IllegalArgumentException("Invalid Value for Number of Player enter.");
		}

		return playersNumber;
	}

	public static void printResult(final int runPlay, final Player playerOne, final Player playerTwo, final GameResult gameResult) {
		System.out.println("");
		System.out.printf("Run\t\t%s\t\t%s\n", playerOne.playerName(), playerTwo.playerName());
		for (int idx = 0; idx < runPlay; idx++) {
			final Boolean playOneResult = gameResult.getFirstResult().get(idx);
			final Boolean playTwoResult = gameResult.getSecondResult().get(idx);
			System.out.printf("%d\t\t%d\t\t%d\n", (idx + 1),
					(null != playOneResult ? BooleanUtils.toInteger(playOneResult) : 0),
					(null != playTwoResult ? BooleanUtils.toInteger(playTwoResult) : 0));
		}
		System.out.println("");
	}
}
