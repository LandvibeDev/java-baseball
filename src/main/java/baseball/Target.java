package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.Vector;

import camp.nextstep.edu.missionutils.Randoms;

public class Target {

	ArrayList<Integer> targetArr;

	public Target() {
		targetArr = new ArrayList<>();
		while (targetArr.size() < NUM_OF_DIGIT) {
			int randomNum = Randoms.pickNumberInRange(MIN_OF_RANGE, MAX_OF_RANGE);
			if (!targetArr.contains(randomNum))
				targetArr.add(randomNum);
		}
	}
}
