package baseball;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Randoms;

public class Target {
	final static int numOfDigit = 3;

	Vector<Integer> targetArr = new Vector<Integer>();

	public Target() {
		while (targetArr.size() < numOfDigit) {
			int randomNum = Randoms.pickNumberInRange(1, 9);
			if (!targetArr.contains(randomNum))
				targetArr.add(randomNum);
		}
	}
}
