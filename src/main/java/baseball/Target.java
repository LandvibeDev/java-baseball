package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Target {

	private ArrayList<Integer> target;

	public Target() {
		target = new ArrayList<>();
		while (getTarget().size() < getNumOfDigit()) {
			int randomNum = Randoms.pickNumberInRange(getMinOfRange(), getMaxOfRange());
			if (!getTarget().contains(randomNum))
				getTarget().add(randomNum);
		}
	}

	public ArrayList<Integer> getTarget() {
		return target;
	}
}
