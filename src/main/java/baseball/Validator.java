package baseball;

public class Validator {
	public static void validateUserInput(String userInput) {
		if (userInput.length() != Number.NUMBER_OF_DIGITS.get()) {
			throw new IllegalArgumentException();
		}

		if (userInput.contains(Integer.toString(Number.ZERO.get()))) {
			throw new IllegalArgumentException();
		}

		if (!userInput.matches(RegexPattern.IS_NUMBER.getRegexPattern())) {
			throw new IllegalArgumentException();
		}

		for (char digit : userInput.toCharArray()) {
			if (!Character.isDigit(digit)) {
				throw new IllegalArgumentException();
			}
		}

		int userInputNumber = Integer.parseInt(userInput);
		int hundredDigit = userInputNumber / 100;
		int tenDigit = (userInputNumber % 100) / 10;
		int oneDigit = userInputNumber % 10;
		if (hundredDigit == tenDigit || tenDigit == oneDigit || oneDigit == hundredDigit) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateThreeDigitNumber(ThreeDigitNumber randomNumber, ThreeDigitNumber userGuessNumber) {
		if (randomNumber == null || userGuessNumber == null) {
			throw new NullPointerException();
		}
	}

	public static void validateIsRepeat(String userInput) {
		if (userInput.length() != Number.REPEAT_INPUT_SIZE.get()) {
			throw new IllegalArgumentException();
		}

		if (!userInput.matches(RegexPattern.IS_NUMBER.getRegexPattern())) {
			throw new IllegalArgumentException();
		}

		String one = String.valueOf(Number.IS_REPEAT);
		String two = String.valueOf(Number.IS_NOT_REPEAT);

		if (!userInput.equals(one) || !userInput.equals(two)) {
			throw new IllegalArgumentException();
		}
	}
}
