package baseball.score;

import baseball.AppConfig;
import baseball.number.MakeInputNumberService;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class MakeScoreServiceTest {

    AppConfig testAppConfig = new AppConfig();
    MakeScoreService makeScoreService = testAppConfig.makeScoreService();
    MakeInputNumberService makeInputNumberService = testAppConfig.makeInputNumberService();

    @Test
    void score_결과_테스트() {
        //given
        Map<Integer, Integer> randomNumberMap135 = makeInputNumberService.makeInputNumberMap("135");
        Map<Integer, Integer> randomNumberMap589 = makeInputNumberService.makeInputNumberMap("589");

        Map<Integer, Integer> inputNumberMap246 = makeInputNumberService.makeInputNumberMap("246");
        Map<Integer, Integer> inputNumberMap135 = makeInputNumberService.makeInputNumberMap("135");
        Map<Integer, Integer> inputNumberMap597 = makeInputNumberService.makeInputNumberMap("597");
        Map<Integer, Integer> inputNumberMap589 = makeInputNumberService.makeInputNumberMap("589");

        //when
        Score score_135_246 = makeScoreService.compareNumbersAndMakeScore(randomNumberMap135, inputNumberMap246);
        Score score_135_135 = makeScoreService.compareNumbersAndMakeScore(randomNumberMap135, inputNumberMap135);
        Score score_589_597 = makeScoreService.compareNumbersAndMakeScore(randomNumberMap589, inputNumberMap597);
        Score score_589_589 = makeScoreService.compareNumbersAndMakeScore(randomNumberMap589, inputNumberMap589);


        //then
        assertThat(score_135_246.getStrike()).isEqualTo(0);
        assertThat(score_135_246.getBall()).isEqualTo(0);

        assertThat(score_135_135.getStrike()).isEqualTo(3);
        assertThat(score_135_135.getBall()).isEqualTo(0);

        assertThat(score_589_597.getStrike()).isEqualTo(1);
        assertThat(score_589_597.getBall()).isEqualTo(1);

        assertThat(score_589_589.getStrike()).isEqualTo(3);
        assertThat(score_589_589.getBall()).isEqualTo(0);

    }
}