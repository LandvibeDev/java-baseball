package baseball;

import baseball.constant.Number;
import baseball.service.MakeRandomAnswerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MakeRandomNumberTest {

    AppConfig testAppConfig = new AppConfig();
    MakeRandomAnswerService makeRandomAnswerService = testAppConfig.makeRandomAnswerService();

    @Test
    void 랜덤_숫자_생성확인() {
        //given

        //when
        Map<Integer, Integer> randomNumberMap = makeRandomAnswerService.makeRandomNumber();

        //then
        Assertions.assertFalse(randomNumberMap.containsKey(0));
        Assertions.assertEquals(Number.LENGTH_OF_INPUT.value(), randomNumberMap.size());

    }
}
