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
		System.out.print("숫자를 입력해주세요 : ");
		String userGuessNumber = Console.readLine();
		return userGuessNumber;
	}

	public static void validateUserGuessNumber(String userGuessNumber) {
		// 3자리 수인지 검증
		if (userGuessNumber.length() != 3) {
			throw new IllegalArgumentException();
		}

		// 1~9 사이의 숫자인지 검증
		if (userGuessNumber.contains("0")) {
			throw new IllegalArgumentException();
		}

		//숫자인지 검증
		if (!userGuessNumber.matches("[+-]?\\d*(\\.\\d+)?")) {
			throw new IllegalArgumentException();
		}

		//서로 다른 수로 이루어졌는지 검증
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
			hint.append(ballCount).append("볼 ");
		}

		if (strikeCount != 0) {
			hint.append(strikeCount).append("스트라이크");
		}

		if (ballCount == 0 && strikeCount == 0) {
			hint.append("낫싱");
		}

		System.out.println(hint);
	}

	public static void proceedGame() {
		String randomNumber = generateRandomNumber();
		//System.out.println("randomNumber = " + randomNumber);
		String userGuessNumber = "";

		while (!randomNumber.equals(userGuessNumber)) {
			userGuessNumber = getUserGuessNumber();

			validateUserGuessNumber(userGuessNumber);

			printHint(randomNumber, userGuessNumber);
		}

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public static boolean repeatGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String isRepeat = Console.readLine();
		if (isRepeat.equals("2")) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
