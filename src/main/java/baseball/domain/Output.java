package baseball.domain;

public class Output {
    private int strike;
    private int ball;

    public Output() {
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
}
