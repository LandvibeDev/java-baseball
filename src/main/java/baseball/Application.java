package baseball;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	public static String generateRandomNumber() {
		StringBuilder randomNumber = new StringBuilder();

		while (randomNumber.length() < Number.NUMBER_OF_DIGITS.getNumber()) {
			String randomDigit = String.valueOf(
				Randoms.pickNumberInRange(Number.START_NUMBER_RANGE.getNumber(), Number.END_NUMBER_RANGE.getNumber()));

			if (randomNumber.indexOf(randomDigit) == Number.IS_CONTAIN.getNumber()) {
				randomNumber.append(randomDigit);
			}
		}

		return randomNumber.toString();
	}

	public static String getUserGuessNumber() {
		System.out.print(Message.GUESS_NUMBER_REQUEST_MESSAGE.getMessage());
		String userGuessNumber = Console.readLine();
		return userGuessNumber;
	}

	public static void validateUserGuessNumber(String userGuessNumber) {
		if (userGuessNumber.length() != Number.NUMBER_OF_DIGITS.getNumber()) {
			throw new IllegalArgumentException();
		}

		if (userGuessNumber.contains(Integer.toString(Number.ZERO.getNumber()))) {
			throw new IllegalArgumentException();
		}

		if (!userGuessNumber.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException();
		}

		Set<Character> digitSet = new HashSet<>();
		for (char digit : userGuessNumber.toCharArray()) {
			if (!Character.isDigit(digit)) {
				throw new IllegalArgumentException();
			}
			digitSet.add(digit);
		}

		if (digitSet.size() != Number.NUMBER_OF_DIGITS.getNumber()) {
			throw new IllegalArgumentException();
		}
	}

	public static int calculateStrikeCount(String randomNumber, String userGuessNumber) {
		int strikeCount = Number.INIT_STRIKE_COUNT.getNumber();

		for (int numberIndex = Number.ZERO.getNumber();
			 numberIndex < Number.NUMBER_OF_DIGITS.getNumber(); numberIndex++) {
			if (randomNumber.charAt(numberIndex) == userGuessNumber.charAt(numberIndex)) {
				strikeCount++;
			}
		}

		return strikeCount;
	}

	public static int calculateBallCount(String randomNumber, String userGuessNumber) {
		int ballCount = Number.INIT_BALL_COUNT.getNumber();

		for (int numberIndex = Number.ZERO.getNumber();
			 numberIndex < Number.NUMBER_OF_DIGITS.getNumber(); numberIndex++) {
			String guessDigit = String.valueOf(userGuessNumber.charAt(numberIndex));

			if (randomNumber.contains(guessDigit) && randomNumber.indexOf(guessDigit) != numberIndex) {
				ballCount++;
			}
		}

		return ballCount;
	}

	public static void printHint(String randomNumber, String userGuessNumber) {
		int strikeCount = calculateStrikeCount(randomNumber, userGuessNumber);
		int ballCount = calculateBallCount(randomNumber, userGuessNumber);

		StringBuilder hint = new StringBuilder();

		if (ballCount != Number.ZERO.getNumber()) {
			hint.append(ballCount).append(Message.BALL_MESSAGE.getMessage());
		}

		if (strikeCount != Number.ZERO.getNumber()) {
			hint.append(strikeCount).append(Message.STRIKE_MESSAGE.getMessage());
		}

		if (ballCount == Number.ZERO.getNumber() && strikeCount == Number.ZERO.getNumber()) {
			hint.append(Message.NOTHING_MESSAGE.getMessage());
		}

		System.out.println(hint);
	}

	public static void proceedGame() {
		String randomNumber = generateRandomNumber();

		while (true) {
			String userGuessNumber = getUserGuessNumber();
			validateUserGuessNumber(userGuessNumber);
			printHint(randomNumber, userGuessNumber);

			if (randomNumber.equals(userGuessNumber)) {
				break;
			}
		}

		System.out.println(Message.ALL_CORRECT_MESSAGE.getMessage());
	}

	public static boolean repeatGame() {
		System.out.println(Message.REPEAT_MESSAGE.getMessage());
		String isRepeat = Console.readLine();
		if (isRepeat.equals(Integer.toString(Number.IS_REPEAT.getNumber()))) {
			return false;
		}
		return true;
	}

	public static void startGame() {
		while (true) {
			proceedGame();
			if (repeatGame()) {
				continue;
			}
			break;
		}
	}

	public static void main(String[] args) {
		startGame();
	}
}
