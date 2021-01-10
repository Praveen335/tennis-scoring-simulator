package tennis.simulator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.challenge.game.Match;
import com.challenge.game.domain.Player;

public class MatchWonByPlayers {
	private Match match;
	private Player player1;
	private Player player2;

	@Before
	public void setUp() {
		player1 = new Player("player 1");
		player2 = new Player("player 2");
		match = new Match(player1, player2);
	}

	@Test
	public void testMatchWonByPlayer1() throws Exception {

		match.pointWonBy(player1);
		Assert.assertEquals("0-0, 15-0", match.score());

		match.pointWonBy(player1);
		Assert.assertEquals("0-0, 30-0", match.score());

		match.pointWonBy(player2);
		Assert.assertEquals("0-0, 30-15", match.score());

		match.pointWonBy(player1);
		match.pointWonBy(player1);
		Assert.assertEquals("1-0", match.score());

		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);

		Assert.assertEquals("2-0", match.score());

		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);

		Assert.assertEquals("2-1", match.score());

		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);

		Assert.assertEquals("3-1", match.score());

		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);

		Assert.assertEquals("4-1", match.score());

		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);

		Assert.assertEquals("5-1", match.score());

		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);

		Assert.assertEquals("6-1, player 1 wins the match", match.score());

	}

	@Test
	public void testMatchWonByPlayer2() throws Exception {

		match.pointWonBy(player2);
		Assert.assertEquals("0-0, 0-15", match.score());

		match.pointWonBy(player2);
		Assert.assertEquals("0-0, 0-30", match.score());

		match.pointWonBy(player1);
		Assert.assertEquals("0-0, 15-30", match.score());

		match.pointWonBy(player2);
		match.pointWonBy(player2);
		Assert.assertEquals("0-1", match.score());

		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);

		Assert.assertEquals("0-2", match.score());

		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);

		Assert.assertEquals("0-3", match.score());

		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);

		Assert.assertEquals("0-4", match.score());

		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);

		Assert.assertEquals("0-5", match.score());

		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);

		Assert.assertEquals("0-6, player 2 wins the match", match.score());

	}
}
