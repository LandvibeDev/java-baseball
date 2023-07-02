package baseball.score;

import baseball.constant.Message;
import baseball.constant.Number;

public class Score {
    private int strike;
    private int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

    public boolean checkGameSuccess() {
        if (this.strike == Number.LENGTH_OF_INPUT.value()) {
            System.out.println(Message.CLEAR_GAME.get());
            return true;
        }
        return false;
    }
}
