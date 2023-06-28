package baseball;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	public static String generateRandomNumber() {
		StringBuilder randomNumber = new StringBuilder();

		while (randomNumber.length() < 3) {
			String randomDigit = String.valueOf(Randoms.pickNumberInRange(1, 9));

			if (randomNumber.indexOf(randomDigit) == -1) {
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
		if (userGuessNumber.length() != 3) {
			throw new IllegalArgumentException();
		}

		if (userGuessNumber.contains("0")) {
			throw new IllegalArgumentException();
		}

		if (!userGuessNumber.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException();
		}

		Set<Character> digitSet = new HashSet<>();
		for (char digit : userGuessNumber.toCharArray()) {
			digitSet.add(digit);
		}

		if (digitSet.size() != 3) {
			throw new IllegalArgumentException();
		}
	}

	public static int calculateStrikeCount(String randomNumber, String userGuessNumber) {
		int strikeCount = 0;

		for (int numberIndex = 0; numberIndex < 3; numberIndex++) {
			if (randomNumber.charAt(numberIndex) == userGuessNumber.charAt(numberIndex)) {
				strikeCount++;
			}
		}

		return strikeCount;
	}

	public static int calculateBallCount(String randomNumber, String userGuessNumber) {
		int ballCount = 0;

		for (int numberIndex = 0; numberIndex < 3; numberIndex++) {
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

		if (ballCount != 0) {
			hint.append(ballCount).append(Message.BALL_MESSAGE.getMessage());
		}

		if (strikeCount != 0) {
			hint.append(strikeCount).append(Message.STRIKE_MESSAGE.getMessage());
		}

		if (ballCount == 0 && strikeCount == 0) {
			hint.append(Message.NOTHING_MESSAGE.getMessage());
		}

		System.out.println(hint);
	}

	public static void proceedGame() {
		String randomNumber = generateRandomNumber();
		String userGuessNumber = "";

		while (!randomNumber.equals(userGuessNumber)) {
			userGuessNumber = getUserGuessNumber();

			validateUserGuessNumber(userGuessNumber);

			printHint(randomNumber, userGuessNumber);
		}

		System.out.println(Message.ALL_CORRECT_MESSAGE.getMessage());
	}

	public static boolean repeatGame() {
		System.out.println(Message.REPEAT_MESSAGE.getMessage());
		String isRepeat = Console.readLine();
		if (isRepeat.equals("2")) {
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
