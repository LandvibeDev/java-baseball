package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;

public class Judge {
	Target target;
	int strike;
	int ball;
	boolean correct;

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

	public void printScore() {
		if (this.ball == 0 && this.strike == 0) {
			System.out.println(getNothingString());
			return;
		}
		if (this.ball != 0) {
			System.out.print(this.ball + getBallString());
		}
		if (this.strike != 0) {
			if (this.ball != 0) {
				System.out.print(getSPACE());
			}
			System.out.print(this.strike + getStrikeString());
		}
	}

}
