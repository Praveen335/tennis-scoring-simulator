package com.challenge.util;

/**
 * The Constants class for all the default user messages to display during game
 * play
 * 
 */
public class Constants {
	public static final String THANKYOU_MESSAGE = "Thanks for playing. Happy New Year 2021!!";
	public static final String WELCOME_MESSAGE = "*** Welcome to Tennis Match ***";
	public static final String ENTER_PLAYER1 = "Please enter the Player 1 name:";
	public static final String ENTER_PLAYER2 = "Please enter the Player 2 name:";
	public static final String VALID_COMMANDS = "Please enter a valid command as below";
	public static final String COMMANDS_LIST = "\'TYPE 1 or 2 to add points for Players accordingly. Options :- ', 1, 2, SCORE, QUIT";
	public static final String INVALID_COMMAND = "Invalid command";
	public static final String QUIT = "QUIT";
	public static final String SCORE = "SCORE";
	public static final String PLAYER_ONE = "1";
	public static final String PLAYER_TWO = "2";
	public static final String MATCH_STATUS = "Current Match Status: ";
	public static final String THANKS_PLAYER_DETAILS = "Thanks for the player details";
	public static final String VALID_OPTION = "Please enter a valid option.";

	private Constants() {
		throw new IllegalStateException("Utility class");
	}
}
