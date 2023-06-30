package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	Integer playGame;
	ArrayList<Integer> in;
	Judge judge;
	ExceptionHandler handler;

	public Game() {
		handler = new ExceptionHandler();

	}

	public void execution() {
		playGame = PLAY_GAME;
		while (playGame == PLAY_GAME) {
			this.play();
			System.out.print(END_GAME_MESSAGE);
			playGame = Integer.parseInt(Console.readLine());
			handler.handleInvalidSelection(playGame);

		}
	}

	public void play() {
		judge = new Judge();
		while (!judge.correct) {
			input();
			judge.scoring(in);
			printScore(judge);
			System.out.println();
		}
	}

	public void input() {
		in = new ArrayList<>();
		String inStr = "";
		System.out.print(GUESS_NUMBER_MESSAGE);
		inStr = Console.readLine();
		handler.handleInvalidLength(inStr.length());

		for (int i = 0; i < inStr.length(); i++) {
			char curNum = inStr.charAt(i);
			handler.handleOutOfRange(curNum);
			handler.handleDuplication(curNum, in);
			in.add(curNum - ZERO_CHAR);
		}

	}

	public void printScore(Judge judge) {
		if (judge.ball == 0 && judge.strike == 0) {
			System.out.println(NOTHING_STRING);
			return;
		}
		if (judge.ball != 0) {
			System.out.print(judge.ball + BALL_STRING);
		}
		if (judge.strike != 0) {
			if (judge.ball != 0) {
				System.out.print(SPACE);
			}
			System.out.print(judge.strike + STRIKE_STRING);
		}
	}

}
