package baseball.domain;

public class Output {
    private int strike;
    private int ball;

    public Output(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
