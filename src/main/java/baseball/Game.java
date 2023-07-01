package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	Integer playGame;
	ArrayList<Integer> in;
	Judge judge;
	ExceptionHandler handler;
	Target target;
	
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
		target = new Target();
		judge = new Judge(target);
		while (!judge.correct) {
			input();
			judge.scoring(in);
			judge.printScore();
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

}
