package com.challenge.util;

import com.challenge.game.domain.Player;

/**
 * The Class MatchRules used to find all the rules for a match.
 */
public class MatchRules {

	/**
	 * Instantiates a new match rules.
	 */
	private MatchRules() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Checks if is tie break. Both player wins 6 games
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return true,
	 */
	
	public static boolean isTieBreak(Player player1, Player player2) {
		return player1.getWinGame() == 6 && player2.getWinGame() == 6;
	}

	/**
	 * Return the Set winner. A player wins a set by winning at least 6 games and at
	 * least 2 games more than the opponent
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return the sets the winning player
	 */
	public static Player getSetWinner(Player player1, Player player2) {

		Player matchWinner = null;

		int playe1WinningGames = player1.getWinGame();
		int playe2WinningGames = player2.getWinGame();

		if (playe1WinningGames >= 6 && playe1WinningGames > playe2WinningGames
				&& (playe1WinningGames - playe2WinningGames) > 1) {
			matchWinner = player1;
		} else if (playe2WinningGames >= 6 && playe2WinningGames > playe1WinningGames
				&& (playe2WinningGames - playe1WinningGames) > 1) {
			matchWinner = player2;
		}

		return matchWinner;
	}

	/**
	 * Checks if is match over based on the each player game points.
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return true, if is match over.
	 */
	public static boolean isMatchOver(Player player1, Player player2) {

		return player1.getWinGame() >= 6 && player1.getWinGame() > player2.getWinGame()
				&& (player1.getWinGame() - player2.getWinGame()) > 1

				|| player2.getWinGame() >= 6 && player2.getWinGame() > player1.getWinGame()
						&& (player2.getWinGame() - player1.getWinGame()) > 1;
	}

	/**
	 * Checks if is match started.
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 * @return true, if is match started
	 */
	public static boolean isMatchStarted(Player player1, Player player2) {
		return player1.getWinGame() == 0 && player2.getWinGame() == 0 && player1.getScore() == 0
				&& player2.getScore() == 0;
	}

}
