import com.marco.rps.data.GameResult;
import com.marco.rps.player.Player;
import com.marco.rps.player.PlayerBean;
import com.marco.rps.type.Roshambo;
import com.marco.rps.utils.RoshamboUtils;
import org.junit.Test;

import static com.marco.rps.player.Player.COMPUTER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public class RoshamboTest {

	private int gameResult;

	@Test
	public void testRoshamboEqual() {
		gameResult = Roshambo.ROCK.roshamboResult(Roshambo.ROCK);
		assertEquals(0, gameResult);

		gameResult = Roshambo.PAPER.roshamboResult(Roshambo.PAPER);
		assertEquals(0, gameResult);

		gameResult = Roshambo.SCISSORS.roshamboResult(Roshambo.SCISSORS);
		assertEquals(0, gameResult);
	}

	@Test
	public void testRoshamboRockWin() {
		gameResult = Roshambo.ROCK.roshamboResult(Roshambo.SCISSORS);
		assertEquals(1, gameResult);
	}

	@Test
	public void testRoshamboPaperWin() {
		gameResult = Roshambo.PAPER.roshamboResult(Roshambo.ROCK);
		assertEquals(1, gameResult);
	}

	@Test
	public void testRoshamboScissorsWin() {
		gameResult = Roshambo.SCISSORS.roshamboResult(Roshambo.PAPER);
		assertEquals(1, gameResult);
	}

	@Test
	public void playRoshamboGame() {
		final Player playerOne = new PlayerBean("My Name");
		final Player computer = new PlayerBean(COMPUTER);

		final Roshambo first = playerOne.play();
		final Roshambo second = computer.play();

		assertNotNull(first);
		assertNotNull(second);

		System.out.printf("Player {%s} play {%s}\n", playerOne.playerName(), first);
		System.out.printf("Player {%s} play {%s}\n", computer.playerName(), second);

		switch (first.roshamboResult(second)) {
		case 0:
			System.out.printf("Game is pair\n");
			break;
		case 1:
			System.out.printf("Player {%s} win the Game\n", playerOne.playerName());
			break;
		case 2:
			System.out.printf("Player {%s} win the Game\n", computer.playerName());
			break;
		default:
			throw new IllegalStateException("Invalid Game Result");
		}
	}

	@Test
	public void playTestGame() {
		final int runningNumber = 3;
		GameResult gameResult = RoshamboUtils.playGames(runningNumber, new PlayerBean("My Name"), new PlayerBean(COMPUTER));
		assertNotNull(gameResult);
		assertEquals(runningNumber, gameResult.getFirstResult().size());
		assertEquals(runningNumber, gameResult.getSecondResult().size());
	}
}
