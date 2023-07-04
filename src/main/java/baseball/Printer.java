package baseball;
import static Constants.Messages.*;
public class Printer {
	public void printGuessNumberMessage(){
		System.out.println(getGuessNumberMessage());
	}
	public void printEndLine(){
		System.out.println();
	}
	public void printEndGameMessage(){
		System.out.println(getEndGameMessage());
	}
	public void printScore(int strike, int ball) {
		if (ball == 0 && strike == 0) {
			System.out.println(getNothingString());
			return;
		}
		if (ball != 0) {
			System.out.print(ball + getBallString());
		}
		if (strike != 0) {
			if (ball != 0) {
				System.out.print(getSPACE());
			}
			System.out.print(strike + getStrikeString());
		}
	}
}
