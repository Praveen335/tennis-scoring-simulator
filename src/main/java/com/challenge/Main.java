package com.challenge;

import java.util.Scanner;

import com.challenge.game.Match;
import com.challenge.game.domain.Player;
import com.challenge.util.Constants;

/**
 * This class is used to get simulate the Tennis game
 * 
 * @author Praveen
 *
 */
public class Main {

	/**
	 * The main method to get the user inputs using scanner and return reports based
	 * on the current match status.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {

		System.out.println(Constants.WELCOME_MESSAGE);

		Scanner scanner = new Scanner(System.in);
		System.out.println(Constants.ENTER_PLAYER1);

		Player player1 = new Player(scanner.nextLine());
		System.out.println(Constants.ENTER_PLAYER2);

		Player player2 = new Player(scanner.nextLine()); // Create Player Object
		Match match = new Match(player1, player2);

		System.out.println(Constants.THANKS_PLAYER_DETAILS);
		System.out.println(Constants.VALID_COMMANDS);
		System.out.println(Constants.COMMANDS_LIST);

		String userInput = null;
		String matchScore = null;

		while (scanner.hasNextLine()) { // Condition in while loop is always true here
			userInput = scanner.nextLine();

			switch (userInput.toUpperCase()) {
			case Constants.QUIT:
				System.out.println(Constants.MATCH_STATUS + match.score());
				System.out.println(Constants.THANKYOU_MESSAGE);
				break;
			case Constants.SCORE:
				System.out.println(match.score());
				break;
			case Constants.PLAYER_ONE:
				match.pointWonBy(player1);
				matchScore = match.score();
				System.out.println(matchScore);
				break;
			case Constants.PLAYER_TWO:
				match.pointWonBy(player2);
				matchScore = match.score();
				System.out.println(matchScore);
				break;
			default:
				System.out.println(Constants.VALID_OPTION);
				break;
			}

			if (Constants.QUIT.equals(userInput)) { // Exit from the game when user commands as QUIT
				scanner.close();
				break;
			} else if (null != matchScore && matchScore.contains("wins")) {
				System.out.println("Congrats!!. Thanks for playing the game.");
				scanner.close();
				break;
			}

		}

	}

}
