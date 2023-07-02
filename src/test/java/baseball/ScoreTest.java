package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {

    private class ScoreWithResult {
        Score score;
        boolean isDone;
        String toString;

        public ScoreWithResult(Score score, boolean isDone) {
            this.score = score;
            this.isDone = isDone;
        }

        public ScoreWithResult(Score score, String toString) {
            this.score = score;
            this.toString = toString;
        }
    }

    @Test
    void TestIsDone() {
        // given
        List<ScoreWithResult> tests = new ArrayList<>();
        tests.add(new ScoreWithResult(new Score(0, 3), true));
        tests.add(new ScoreWithResult(new Score(1, 2), false));
        tests.add(new ScoreWithResult(new Score(2, 1), false));
        tests.add(new ScoreWithResult(new Score(3, 0), false));
        tests.add(new ScoreWithResult(new Score(2, 0), false));
        tests.add(new ScoreWithResult(new Score(1, 0), false));
        tests.add(new ScoreWithResult(new Score(0, 0), false));

        for (ScoreWithResult test : tests) {
            // when
            boolean actual = test.score.isDone();

            // then
            assertThat(actual).isEqualTo(test.isDone);
        }
    }

    @Test
    void TestToString() {
        // given
        List<ScoreWithResult> tests = new ArrayList<>();
        tests.add(new ScoreWithResult(new Score(0, 0), "낫싱"));
        tests.add(new ScoreWithResult(new Score(1, 0), "1볼"));
        tests.add(new ScoreWithResult(new Score(0, 1), "1스트라이크"));
        tests.add(new ScoreWithResult(new Score(1, 1), "1볼 1스트라이크"));

        for (ScoreWithResult test : tests) {
            // when
            String actual = test.score.toString();

            // then
            assertThat(actual).isEqualTo(test.toString);
        }
    }
}