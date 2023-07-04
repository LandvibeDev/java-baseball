package Constants;

public class Messages {
	//MESSAGES
	private static final String GUESS_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String END_GAME_MESSAGE = "게임 종료";
	private static final String BALL_STRING = "볼";
	private static final String STRIKE_STRING = "스트라이크";
	private static final String NOTHING_STRING = "낫싱";
	private static final String SPACE = " ";

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

}
