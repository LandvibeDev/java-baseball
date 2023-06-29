package baseball;

import static baseball.Target.*;

import java.util.Objects;
import java.util.Vector;

public class Judge {

	Target target = new Target();

	int strike;
	int ball;
	boolean correct;

	public void scoring(Vector<Integer> in) {
		this.strike = countStrike(in);
		this.ball = countBall(in) - this.strike;
		this.correct = (this.strike == numOfDigit);
	}

	private int countStrike(Vector<Integer> in) {
		int strike = 0;
		for (int i = 0; i < in.size(); i++) {
			if (target.targetArr.get(i).equals(in.get(i)))
				strike++;
		}
		return strike;
	}

	private int countBall(Vector<Integer> in) {
		int tmp = 0;
		for (Integer elem : in) {
			if (target.targetArr.contains(elem))
				tmp++;
		}
		return tmp;
	}

}
