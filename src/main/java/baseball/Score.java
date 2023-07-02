package baseball;

import java.util.Objects;

public class Score {
    int ball;
    int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isDone() {
        return this.strike == 3;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        return ball + "볼 " + strike + "스트라이크";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return ball == score.ball && strike == score.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }

}
