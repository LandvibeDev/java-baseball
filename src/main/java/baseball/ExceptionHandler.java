package baseball;

import static Constants.Values.*;

import java.util.ArrayList;

public class ExceptionHandler {

	public void handleInvalidSelection(Integer selection) {
		if (!selection.equals(getPlayGameSelection()) && !selection.equals(getEndGameSelection())) {
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
