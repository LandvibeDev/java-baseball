package baseball.service;

import baseball.domain.Score;

public class PrintOutputService {

    private void printBallScore(Score score) {
        int ball = score.getBall();
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
    }

    private void printStrikeScore(Score score) {
        int strike = score.getStrike();
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
    }

    private void printIfScoreIsNothing(Score score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
    }

    public void printScore(Score score){
        printBallScore(score);
        printStrikeScore(score);
        printIfScoreIsNothing(score);

        System.out.println();
    }

    public boolean isGameSuccess(Score score) {
        int strike = score.getStrike();

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
