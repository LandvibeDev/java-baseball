package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	ArrayList<Integer> in;
	Judge judge;

	public Game() {
		in = new ArrayList<>();
		judge = new Judge();
	}

	public void execution() {
		int playGame = 1;
		while (playGame == 1) {
			this.play();
			System.out.print(END_GAME_MESSAGE);
			playGame = Integer.parseInt(Console.readLine());
			
			if (playGame != 1 && playGame != 2) {
				throw new IllegalArgumentException(); // 예외 처리
			}
		}
	}

	public void play() {
		while (!judge.correct) {
			input();
			System.out.println();
			judge.scoring(in);
			printScore(judge);
		}
	}

	public void input() {
		String inStr = "";
		System.out.print(GUESS_NUMBER_MESSAGE);
		inStr = Console.readLine();
		char[] chars = inStr.toCharArray();
		if (inStr.length() != NUM_OF_DIGIT) {
			throw new IllegalArgumentException(); // 예외 처리
		}
		for (int i = 0; i < inStr.length(); i++) {
			if (inStr.charAt(i) < '1' || inStr.charAt(i) > '9') {
				throw new IllegalArgumentException(); // 예외 처리
			}

			in.add(chars[i] - '0');
		}

	}

	public void printScore(Judge judge) {
		if (judge.ball == 0 && judge.strike == 0) {
			System.out.println(NOTHING);
			return;
		}
		if (judge.ball != 0) {
			System.out.print(judge.ball + BALL);
		}
		if (judge.strike != 0) {
			if (judge.ball != 0) {
				System.out.print(" ");
			}
			System.out.print(judge.strike + STRIKE);
		}
	}

}
