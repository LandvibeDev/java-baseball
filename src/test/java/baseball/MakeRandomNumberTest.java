package baseball;

import baseball.constant.Number;
import baseball.number.MakeRandomNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MakeRandomNumberTest {

    AppConfig testAppConfig = new AppConfig();
    MakeRandomNumberService makeRandomAnswerService = testAppConfig.makeRandomNumberService();

    @Test
    void 랜덤_숫자_생성확인() {
        //given

        //when
        Map<Integer, Integer> randomNumberMap = makeRandomAnswerService.makeRandomNumberMap();

        //then
        Assertions.assertFalse(randomNumberMap.containsKey(0));
        Assertions.assertEquals(Number.LENGTH_OF_INPUT.value(), randomNumberMap.size());

    }
}
