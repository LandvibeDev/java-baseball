package baseball;

import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;
import baseball.Scoring;

public class PlayGame {

	Target target = new Target();
	public void play() {
		target.setTarget();
	}

	public String input() {
		String in;
		System.out.print("숫자를 입력하세요:");
		in = Console.readLine();
		return in;
	}

	public boolean checkReplay(){
		boolean again;

	}
}
