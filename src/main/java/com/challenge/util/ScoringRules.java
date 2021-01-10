package com.challenge.util;

import com.challenge.game.domain.Player;

/**
 * The Class ScoringRules used to find all the rules specific to the scoring.
 * 
 */
public class ScoringRules {

	/**
	 * Instantiates a new scoring rules.
	 */
	private ScoringRules() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Checks if is deuce.
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return true, if is deuce
	 */
	public static boolean isDeuce(Player player1, Player player2) {
		return player1.getScore() >= 3 && player2.getScore() >= 3 && player1.getScore() == player2.getScore();
	}

	/**
	 * Checks for advantage in a game. At least 3 points have been scored by each
	 * side and a player has one more point than his opponent, the score of the game
	 * is "advantage" for the player in the lead.
	 * 
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return true, if successful
	 */
	public static boolean hasAdvantage(Player player1, Player player2) {
		int player1Score = player1.getScore();
		int player2Score = player2.getScore();

		return (player1Score >= 3 && player2Score >= 3)
				&& ((player2Score <= player1Score - 1) || player1Score <= player2Score - 1);
	}

	/**
	 * Checks for game winner. A game is won by the first player to have won at
	 * least 4 points in total and at least 2 points more than the opponent
	 * 
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return true, if successful
	 */
	public static boolean hasGameWinner(Player player1, Player player2) {

		int player1Score = player1.getScore();
		int player2Score = player2.getScore();

		return (player1Score >= 4 && player2Score <= player1Score - 2)
				|| (player2Score >= 4 && player1Score <= player2Score - 2);

	}

}
