package com.challenge.game;

import com.challenge.game.domain.Player;
import com.challenge.game.service.Scoring;
import com.challenge.util.MatchRules;

/**
 * This class used to get the match score and set points for players .
 */
public class Match {
	
	private final Player player1;
	private final Player player2;
	
	
	/**
	 *
	 * @param player1 the player 1
	 * @param player2 the player 2
	 */
	public Match(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		
	}
	
	/**
	 * Point won by.
	 * calls win point method on player class to increment point
	 *
	 * @param player the player
	 */
	public void pointWonBy(Player player) {
		player.winPoint();
	}


	/**
	 * Score.
	 *
	 * @return game score, winner and set winner
	 */
	public String score() {
		String score = "";
		if (MatchRules.isMatchStarted(player1, player2)) {
			return "0-0";
		} else if (MatchRules.isTieBreak(player1, player2)) {
			score = Scoring.scoreTieBreak(player1, player2);
		} else {
			score = Scoring.getGameScore(player1, player2);
			 if (MatchRules.isMatchOver(player1, player2)) {
				score = String.format("%s-%s, %s wins the match", player1.getWinGame(), player2.getWinGame(), MatchRules.getSetWinner(player1, player2).getName());
			}
				
		}
		return score;
	}

}
