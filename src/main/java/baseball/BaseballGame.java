package baseball;

import java.util.Queue;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

	private NumberManager numberManager;

	public BaseballGame() {
		this.numberManager = new NumberManager();
	}

	public void startGame() {
		while (true) {
			proceedGame();
			if (repeatGame()) {
				continue;
			}
			break;
		}
	}

	public void proceedGame() {
		ThreeDigitNumber randomNumber = numberManager.generateRandomNumber();

		while (true) {
			ThreeDigitNumber userGuessNumber = numberManager.getUserGuessNumber();
			Score score = numberManager.calculateScore(randomNumber, userGuessNumber);
			int strikeCount = score.getStrikeCount();
			int ballCount = score.getBallCount();
			printHint(strikeCount, ballCount);

			if (randomNumber.equals(userGuessNumber)) {
				break;
			}
		}

		System.out.println(Message.ALL_CORRECT_MESSAGE);
	}

	public boolean repeatGame() {
		System.out.println(Message.REPEAT_MESSAGE);
		String isRepeat = Console.readLine();
		if (isRepeat.equals(Integer.toString(Number.IS_REPEAT.get()))) {
			return false;
		}
		return true;
	}

	public void printHint(int strikeCount, int ballCount) {
		StringBuilder hint = new StringBuilder();

		if (ballCount != Number.ZERO.get()) {
			hint.append(ballCount).append(Message.BALL_MESSAGE);
		}

		if (strikeCount != Number.ZERO.get()) {
			hint.append(strikeCount).append(Message.STRIKE_MESSAGE);
		}

		if (ballCount == Number.ZERO.get() && strikeCount == Number.ZERO.get()) {
			hint.append(Message.NOTHING_MESSAGE);
		}

		System.out.println(hint);
	}

}
