package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;

public class ExceptionHandler {

	public void handleInvalidSelection(Integer selection) {
		if (!selection.equals(getPlayGame()) && !selection.equals(getEndGame())) {
			throw new IllegalArgumentException();
		}
	}

	public void handleInvalidLength(int length) {
		if (length != getNumOfDigit()) {
			throw new IllegalArgumentException();
		}
	}

	public void handleOutOfRange(char number) {
		if (number < getMinOfRangeChar() || number > getMaxOfRangeChar()) {
			throw new IllegalArgumentException();
		}
	}

	public void handleDuplication(char cur, ArrayList<Integer> oldNums) {
		if (oldNums.contains(cur - getZeroChar())) {
			throw new IllegalArgumentException();
		}
	}
}
