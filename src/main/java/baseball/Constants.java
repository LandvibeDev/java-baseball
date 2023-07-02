package baseball;

public class Constants {
	//MESSAGES
	private static final String GUESS_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String END_GAME_MESSAGE = "게임 종료";
	private static final String BALL_STRING = "볼";
	private static final String STRIKE_STRING = "스트라이크";
	private static final String NOTHING_STRING = "낫싱";
	private static final String SPACE = " ";

	//VALUES
	private static final int NUM_OF_DIGIT = 3;
	private static final int MIN_OF_RANGE = 1;
	private static final char MIN_OF_RANGE_CHAR = '1';
	private static final int MAX_OF_RANGE = 9;
	private static final char MAX_OF_RANGE_CHAR = '9';

	private static final char ZERO_CHAR = '0';

	private static final int PLAY_GAME = 1;
	private static final int END_GAME = 2;

	public static String getGuessNumberMessage() {
		return GUESS_NUMBER_MESSAGE;
	}

	public static String getEndGameMessage() {
		return END_GAME_MESSAGE;
	}

	public static String getBallString() {
		return BALL_STRING;
	}

	public static String getStrikeString() {
		return STRIKE_STRING;
	}

	public static String getNothingString() {
		return NOTHING_STRING;
	}

	public static String getSPACE() {
		return SPACE;
	}

	public static int getNumOfDigit() {
		return NUM_OF_DIGIT;
	}

	public static int getMinOfRange() {
		return MIN_OF_RANGE;
	}

	public static char getMinOfRangeChar() {
		return MIN_OF_RANGE_CHAR;
	}

	public static int getMaxOfRange() {
		return MAX_OF_RANGE;
	}

	public static char getMaxOfRangeChar() {
		return MAX_OF_RANGE_CHAR;
	}

	public static char getZeroChar() {
		return ZERO_CHAR;
	}

	public static int getPlayGame() {
		return PLAY_GAME;
	}

	public static int getEndGame() {
		return END_GAME;
	}
}
