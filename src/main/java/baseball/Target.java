package baseball;

import static Constants.Values.*;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Target {

	private final ArrayList<Integer> target;

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
