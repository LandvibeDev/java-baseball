package baseball;

import static baseball.Application.*;

public class Scoring {
	public class scoreDTO {
		int strike;
		int ball;
		boolean correct;
	}

	public class judge {
		public scoreDTO scoring(int in) {
			int first = in / 100;
			int second = (in % 100) / 10;
			int third = in % 10;
			scoreDTO score = new scoreDTO();
			score.strike = countStrike(first, second, third);
			score.ball = countBall(first, second, third);
			score.correct = (score.strike == 3);

			return score;
		}

		public int countStrike(int[] inputArr) {
			int strike = 0;


			return strike;
		}

		public int countBall(int first, int second, int third) {
			int ball = 0;
			if (first != targetFirst) {
				if (first == targetSecond || first == targetThird)
					ball++;
			}
			if (second != targetSecond) {
				if (second == targetFirst || second == targetThird)
					ball++;
			}
			if (third != targetThird) {
				if (third == targetFirst || third == targetSecond)
					ball++;
			}
			return ball;
		}
	}
}
