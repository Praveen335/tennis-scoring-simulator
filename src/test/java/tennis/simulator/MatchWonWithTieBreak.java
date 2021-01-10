package tennis.simulator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.challenge.game.Match;
import com.challenge.game.domain.Player;

public class MatchWonWithTieBreak {
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
	public void testMatchWithDeuce() throws Exception {

		match.pointWonBy(player1);
		Assert.assertEquals("0-0, 15-0", match.score());

		match.pointWonBy(player1);
		Assert.assertEquals("0-0, 30-0", match.score());

		match.pointWonBy(player2);
		Assert.assertEquals("0-0, 30-15", match.score());
		
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		Assert.assertEquals("0-0, 30-40", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("0-0, Deuce", match.score());
		
	
	}
	
	public void testMatchWithAdvantage() throws Exception {

		match.pointWonBy(player1);
		Assert.assertEquals("0-0, 15-0", match.score());

		match.pointWonBy(player1);
		Assert.assertEquals("0-0, 30-0", match.score());

		match.pointWonBy(player2);
		Assert.assertEquals("0-0, 30-15", match.score());
		
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		Assert.assertEquals("0-0, 30-40", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("0-0, Deuce", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("0-0, Advantage player 1", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("1-0", match.score());
	}
}
