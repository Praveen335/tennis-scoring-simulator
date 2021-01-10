package tennis.simulator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.challenge.game.Match;
import com.challenge.game.domain.Player;

public class MatchWonWithDeuce {
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
	public void testMatchWonByTieBreak() throws Exception {

		
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		Assert.assertEquals("1-0", match.score());
		
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		Assert.assertEquals("2-0", match.score());
		
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		Assert.assertEquals("3-0", match.score());
		
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		Assert.assertEquals("4-0", match.score());
		
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		Assert.assertEquals("4-1", match.score());
		
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		Assert.assertEquals("4-2", match.score());
		
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		Assert.assertEquals("4-3", match.score());
		
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		Assert.assertEquals("4-4", match.score());
		
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		Assert.assertEquals("4-5", match.score());
		
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		Assert.assertEquals("5-5", match.score());
		
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		match.pointWonBy(player1);
		Assert.assertEquals("6-5", match.score());	
		
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		match.pointWonBy(player2);
		Assert.assertEquals("6-6", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("6-6, 1-0", match.score());
		
		match.pointWonBy(player2);
		Assert.assertEquals("6-6, 1-1", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("6-6, 2-1", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("6-6, 3-1", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("6-6, 4-1", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("6-6, 5-1", match.score());
		
		match.pointWonBy(player1);
		Assert.assertEquals("6-6, 6-1", match.score());
		
		match.pointWonBy(player1);

		Assert.assertEquals("7-6, player 1 wins the match", match.score());

	}
}
