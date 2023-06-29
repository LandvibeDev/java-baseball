package baseball;

import static baseball.Target.*;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	Vector<Integer> in = new Vector<Integer>();
	Judge judge = new Judge();

	public void execution() {
		int playGame = 1;
		while (playGame == 1) {
			this.play();
			System.out.println("게임 종료");
			playGame= Integer.parseInt(Console.readLine());
			if (playGame != 1 && playGame != 2) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void play() {
		do {
			in = input();
			System.out.println();
			judge.scoring(in);
			printScore(judge);
		} while (!judge.correct);
	}

	public Vector<Integer> input() {
		String inStr = "";
		Vector<Integer> IntVec = new Vector<Integer>();
		System.out.print("숫자를 입력해주세요 : ");
		inStr = Console.readLine();
		char[] chars = inStr.toCharArray();
		if (inStr.length() != numOfDigit) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < inStr.length(); i++) {
			if (inStr.charAt(i) < '0' || inStr.charAt(i) > '9') {
				throw new IllegalArgumentException();
			}
			IntVec.add(chars[i] - '0');
		}
		return IntVec;

	}

	public void printScore(Judge judge) {
		if (judge.ball == 0 && judge.strike == 0) {
			System.out.println("낫싱");
			return;
		}
		if (judge.ball != 0) {
			System.out.print(judge.ball + "볼");
		}
		if (judge.strike != 0) {
			if (judge.ball != 0){
				System.out.print(" ");
			}
			System.out.print(judge.strike + "스트라이크");
		}
	}

}
