package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.Vector;

public class Judge {
	Target target;
	int strike;
	int ball;
	boolean correct;

	public Judge() {
		Target target = new Target();
		strike = 0;
		ball = 0;
		correct = false;
	}

	public void scoring(ArrayList<Integer> in) {
		this.strike = countStrike(in);
		this.ball = countBall(in) - this.strike;
		this.correct = (this.strike == NUM_OF_DIGIT);
	}

	private int countStrike(ArrayList<Integer> in) {
		int strike = 0;
		for (int i = 0; i < in.size(); i++) {
			if (target.targetArr.get(i).equals(in.get(i)))
				strike++;
		}
		return strike;
	}

	private int countBall(ArrayList<Integer> in) {
		int tmp = 0;
		for (Integer elem : in) {
			if (target.targetArr.contains(elem))
				tmp++;
		}
		return tmp;
	}

}
