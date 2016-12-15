import com.marco.rps.data.GameResult;
import com.marco.rps.player.PlayerBean;
import com.marco.rps.utils.RoshamboUtils;
import org.junit.Test;

import static com.marco.rps.player.Player.COMPUTER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by marco.rotondi on 15/12/2016.
 */
public class RoshamboUtilsTest {

	@Test
	public void playTestGame() {
		final int runningNumber = 3;
		GameResult gameResult = RoshamboUtils.playGames(runningNumber, new PlayerBean("My Name"), new PlayerBean(COMPUTER));
		assertNotNull(gameResult);
		assertEquals(runningNumber, gameResult.getFirstResult().size());
		assertEquals(runningNumber, gameResult.getSecondResult().size());
	}
}
