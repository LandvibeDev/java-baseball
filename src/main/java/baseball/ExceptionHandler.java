package baseball;

import static baseball.Constants.*;

public class ExceptionHandler {


	public void handleInvalidSelection(Integer selection){
		if (!selection.equals(PLAY_GAME) && !selection.equals(END_GAME)) {
			throw new IllegalArgumentException();
		}
	}
	public void handleInvalidLength(int length){
		if (length != NUM_OF_DIGIT) {
			throw new IllegalArgumentException();
		}
	}
	public void handleOutOfRange(char number){
		if (number < MIN_OF_RANGE_CHAR || number > MAX_OF_RANGE_CHAR) {
			throw new IllegalArgumentException();
		}
	}
}
