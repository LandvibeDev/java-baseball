package baseball;

import java.util.Scanner;
public class Application {
	static int targetNum = 123;
	static int targetFirst = targetNum / 100;
	static int targetSecond = (targetNum % 100) / 10;
	static int targetThird = targetNum % 10;

	public static void main(String[] args) {
		//TODO: 숫자 야구 게임 구현
		Application app = new Application();
		int in = app.input();

	}

	public int input() {
		int in = 0;
		Scanner scnr = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요");
		scnr.nextInt(in);
		return in;
	}
}



