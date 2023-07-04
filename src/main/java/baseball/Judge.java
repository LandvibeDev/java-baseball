package baseball;

import static Constants.Values.*;
import static Constants.Messages.*;

import java.util.ArrayList;

public class Judge {
	Target target;
	private int strike;
	private int ball;
	private boolean correct;

	public Judge(Target target) {
		this.target = target;
		strike = 0;
		ball = 0;
		correct = false;
	}

	public void scoring(ArrayList<Integer> in) {
		this.strike = countStrike(in);
		this.ball = countBall(in) - this.strike;
		this.correct = (this.strike == getNumOfDigit());
	}

	private int countStrike(ArrayList<Integer> in) {
		int strike = 0;
		for (int i = 0; i < in.size(); i++) {
			if (target.getTarget().get(i).equals(in.get(i)))
				strike++;
		}
		return strike;
	}

	private int countBall(ArrayList<Integer> in) {
		int tmp = 0;
		for (Integer elem : in) {
			if (target.getTarget().contains(elem))
				tmp++;
		}
		return tmp;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean isCorrect() {
		return correct;
	}

}
