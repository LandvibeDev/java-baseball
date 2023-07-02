package baseball.number;

import baseball.AppConfig;
import baseball.constant.Number;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class MakeRandomNumberServiceTest {

    AppConfig testAppConfig = new AppConfig();
    MakeRandomNumberService makeRandomAnswerService = testAppConfig.makeRandomNumberService();

    @Test
    void 랜덤_숫자_생성_성공() {
        //given

        //when
        Map<Integer, Integer> randomNumberMap = makeRandomAnswerService.makeRandomNumberMap();

        //then
        assertThat(Number.LENGTH_OF_INPUT.value()).isEqualTo(randomNumberMap.size());
        assertThat(randomNumberMap.containsKey(0)).isEqualTo(false);
    }
}