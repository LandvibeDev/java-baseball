package baseball;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Randoms;

public class Target {
	final int numOfDigit = 3;

	Vector<Integer> target = new Vector<Integer>();

	public void setTarget() {
		while (target.size() < numOfDigit) {
			int randomNum = Randoms.pickNumberInRange(1, 9);
			if (!target.contains(randomNum))
				target.add(randomNum);
		}
	}
}
