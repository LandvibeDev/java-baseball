package baseball.service;

import baseball.domain.Output;

public class PrintOutputService {

    public void printOutput(Output output) {
        int strike = output.getStrike();
        int ball = output.getBall();

        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println();
    }

    public boolean isGameSuccess(Output output) {
        int strike = output.getStrike();

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
