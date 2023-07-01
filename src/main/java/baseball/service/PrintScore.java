package baseball.service;

import baseball.constant.Message;
import baseball.domain.Score;

public class PrintScore {

    private void printBallScore(Score score) {
        int ball = score.getBall();
        if (ball != 0) {
            System.out.print(ball + Message.BALL.get());
        }
    }

    private void printStrikeScore(Score score) {
        int strike = score.getStrike();
        if (strike != 0) {
            System.out.print(strike + Message.STRIKE.get());
        }
    }

    private void printIfScoreIsNothing(Score score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (ball == 0 && strike == 0) {
            System.out.print(Message.NOTHING.get());
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
            System.out.println(Message.CLEAR_GAME.get());
            return true;
        }
        return false;
    }
}
