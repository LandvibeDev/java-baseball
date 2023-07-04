package baseball;

import static Constants.Messages.*;
import static Constants.Values.*;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	Integer playGame;
	ArrayList<Integer> in;
	Judge judge;
	ExceptionHandler handler;
	Target target;
	Printer printer;

	public Game() {
		handler = new ExceptionHandler();
		printer = new Printer();
	}

	public void execution() {
		playGame = getPlayGameSelection();
		while (playGame == getPlayGameSelection()) {
			play();
			printer.printEndGameMessage();
			playGame = Integer.parseInt(Console.readLine());
			handler.handleInvalidSelection(playGame);

		}
	}

	public void play() {
		target = new Target();
		judge = new Judge(target);
		while (!judge.isCorrect()) {
			input();
			judge.scoring(in);
			printer.printScore(judge.getStrike(), judge.getBall());
			printer.printEndLine();
		}
	}

	public void input() {
		in = new ArrayList<>();
		String inStr = "";
		printer.printGuessNumberMessage();
		inStr = Console.readLine();
		handler.handleInvalidLength(inStr.length());

		for (char cur : inStr.toCharArray()) {
			handler.handleOutOfRange(cur);
			handler.handleDuplication(cur, in);
			in.add(cur - getZeroChar());
		}

	}

}
