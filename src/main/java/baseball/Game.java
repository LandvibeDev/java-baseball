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
		playGame = getPlayGame();
		while (playGame == getPlayGame()) {
			this.play();
			System.out.print(getEndGameMessage());
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
		System.out.print(getGuessNumberMessage());
		inStr = Console.readLine();
		handler.handleInvalidLength(inStr.length());

		for (char cur : inStr.toCharArray()) {
			handler.handleOutOfRange(cur);
			handler.handleDuplication(cur, in);
			in.add(cur - getZeroChar());
		}

	}

}
