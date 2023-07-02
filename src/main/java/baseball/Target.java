package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Target {

	ArrayList<Integer> targetArr;

	public Target() {
		targetArr = new ArrayList<>();
		while (targetArr.size() < getNumOfDigit()) {
			int randomNum = Randoms.pickNumberInRange(getMinOfRange(), getMaxOfRange());
			if (!targetArr.contains(randomNum))
				targetArr.add(randomNum);
		}
	}
}
