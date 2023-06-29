package baseball;

public enum Number {

	NUMBER_OF_DIGITS(3),
	START_NUMBER_RANGE(1),
	END_NUMBER_RANGE(9),
	IS_CONTAIN(-1),
	ZERO(0),
	INIT_STRIKE_COUNT(0),
	INIT_BALL_COUNT(0),
	IS_REPEAT(1),
	IS_NOT_REPEAT(2),
	REPEAT_INPUT_SIZE(1);

	private final int number;

	Number(int number) {
		this.number = number;
	}

	public int get() {
		return number;
	}
}
