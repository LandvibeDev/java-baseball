package baseball;

import static baseball.Constants.*;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Randoms;

public class Target {


	Vector<Integer> targetArr = new Vector<Integer>();

	public Target() {
		while (targetArr.size() < NUM_OF_DIGIT) {
			int randomNum = Randoms.pickNumberInRange(1, 9);
			if (!targetArr.contains(randomNum))
				targetArr.add(randomNum);
		}
	}
}
