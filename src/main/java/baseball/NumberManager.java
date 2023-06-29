package baseball;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberManager {
	public int generateRandomNumber() {
		StringBuilder randomNumber = new StringBuilder();

		while (randomNumber.length() < Number.NUMBER_OF_DIGITS.getNumber()) {
			String randomDigit = String.valueOf(
				Randoms.pickNumberInRange(Number.START_NUMBER_RANGE.getNumber(), Number.END_NUMBER_RANGE.getNumber()));

			if (randomNumber.indexOf(randomDigit) == Number.IS_CONTAIN.getNumber()) {
				randomNumber.append(randomDigit);
			}
		}

		return Integer.parseInt(randomNumber.toString());
	}

	public int getUserGuessNumber() {
		System.out.print(Message.GUESS_NUMBER_REQUEST_MESSAGE);
		String userGuessNumber = Console.readLine();
		return Integer.parseInt(userGuessNumber);
	}

	public void validateUserGuessNumber(String userGuessNumber) {
		if (userGuessNumber.length() != Number.NUMBER_OF_DIGITS.getNumber()) {
			throw new IllegalArgumentException();
		}

		if (userGuessNumber.contains(Integer.toString(Number.ZERO.getNumber()))) {
			throw new IllegalArgumentException();
		}

		if (!userGuessNumber.matches(RegexPattern.IS_NUMBER.getRegexPattern())) {
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

	public Queue<Integer> calculateStrikeBallCount(String randomNumber, String userGuessNumber) {
		int strikeCount = Number.INIT_STRIKE_COUNT.getNumber();
		int ballCount = Number.INIT_BALL_COUNT.getNumber();

		Queue<Integer> strikeBallQueue = new LinkedList<>();

		for (int numberIndex = Number.ZERO.getNumber();
			 numberIndex < Number.NUMBER_OF_DIGITS.getNumber(); numberIndex++) {
			if (randomNumber.charAt(numberIndex) == userGuessNumber.charAt(numberIndex)) {
				strikeCount++;
			}

			String guessDigit = String.valueOf(userGuessNumber.charAt(numberIndex));

			if (randomNumber.contains(guessDigit) && randomNumber.indexOf(guessDigit) != numberIndex) {
				ballCount++;
			}
		}

		strikeBallQueue.add(strikeCount);
		strikeBallQueue.add(ballCount);
		return strikeBallQueue;
	}
}
