package com.challenge.game.service;

import com.challenge.game.domain.Player;
import com.challenge.util.ScoringRules;

/**
 * The Class used to calculate all the scoring based on the match current
 * points.
 */
public class Scoring {

	/**
	 * Determines the player's game -> score, Deuce, advantage or winner It
	 * increments the game won by player
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return score which display games won by each players and current game score
	 */
	public static String getGameScore(Player player1, Player player2) {
		if (player1.getScore() >= 3 || player2.getScore() >= 3) {
			if (ScoringRules.isDeuce(player1, player2)) {
				return String.format("%s-%s, %s", player1.getWinGame(), player2.getWinGame(), "Deuce");
			} else if (ScoringRules.hasGameWinner(player1, player2)) {
				Player player = gameWinner(player1, player2);
				if (null != player)
					player.winGame();
				resetPlayersPoints(player1, player2);
				return String.format("%s-%s", player1.getWinGame(), player2.getWinGame());

			} else if (ScoringRules.hasAdvantage(player1, player2)) {
				return String.format("%s-%s, %s", player1.getWinGame(), player2.getWinGame(),
						"Advantage " + advantagePlayer(player1, player2).getName());
			}
		}
		return String.format("%s-%s, %s-%s", player1.getWinGame(), player2.getWinGame(), player1.getPoint(),
				player2.getPoint());
	}

	/**
	 * This method is responsible for calculating the tie break.
	 * 
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return tie-break score or the match winner player name
	 */
	public static String scoreTieBreak(Player player1, Player player2) {
		int player1Score = player1.getScore();
		int player2Score = player2.getScore();

		if (player1Score >= 7 && player1Score > player2Score && (player1Score - player2Score) >= 2) {
			player1.winGame();
			return String.format("%s-%s, %s wins the match", player1.getWinGame(), player2.getWinGame(),
					player1.getName());
		} else if (player2Score >= 7 && player2Score > player1Score && (player2Score - player1Score) >= 2) {
			player2.winGame();
			return String.format("%s-%s, %s wins the match", player1.getWinGame(), player2.getWinGame(),
					player2.getName());
		}
		return String.format("%s-%s, %s-%s", player1.getWinGame(), player2.getWinGame(), player1.getScore(),
				player2.getScore());
	}

	/**
	 * Reset players points.
	 * 
	 * @param player1 the player 1
	 * @param player2 the player 2
	 */
	private static void resetPlayersPoints(Player player1, Player player2) {
		player1.resetScore();
		player2.resetScore();

	}

	/**
	 * Determine which player has advantage over another player in a game.
	 * 
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return the advantage player
	 */
	private static Player advantagePlayer(Player player1, Player player2) {

		Player winner = new Player("");
		int player1Score = player1.getScore();
		int player2Score = player2.getScore();

		// At least 3 points have been scored by each side and a player has one more
		// point than his opponent, the score of the game is "advantage" for the player
		// in the lead.
		if (player1Score >= 3 && player2Score >= 3) {

			if (player2Score <= player1Score - 1) {
				winner = player1;
			} else if (player1Score <= player2Score - 1) {
				winner = player2;
			}
		}
		return winner;
	}

	/**
	 * Game winner. A game is won by the first player to have won at least 4 points
	 * in total and at least 2 points more than the opponent
	 * 
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return the player
	 */
	private static Player gameWinner(Player player1, Player player2) {

		Player winner = null;
		int player1Score = player1.getScore();
		int player2Score = player2.getScore();

		// Player to have won at least 4 points in total and at least 2 points more than
		// the opponent
		if (player1Score >= 4 && player2Score <= player1Score - 2) {
			winner = player1;
		} else if (player2Score >= 4 && player1Score <= player2Score - 2) {
			winner = player2;
		}
		return winner;

	}

	private Scoring() {
		throw new IllegalStateException("Utility class");
	}

}
