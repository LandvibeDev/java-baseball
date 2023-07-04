package Constants;

public class Values {

	private static final char ZERO_CHAR = '0';

	private static final int NUM_OF_DIGIT = 3;
	private static final int MIN_OF_RANGE = 1;
	private static final char MIN_OF_RANGE_CHAR = '1';
	private static final int MAX_OF_RANGE = 9;
	private static final char MAX_OF_RANGE_CHAR = '9';


	private static final int PLAY_GAME_SELECTION = 1;
	private static final int END_GAME_SELECTION = 2;

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

	public static int getPlayGameSelection() {
		return PLAY_GAME_SELECTION;
	}

	public static int getEndGameSelection() {
		return END_GAME_SELECTION;
	}
}
