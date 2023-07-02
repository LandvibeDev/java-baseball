package baseball.number;

import baseball.AppConfig;
import baseball.constant.Number;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MakeRandomNumberServiceTest {

    @Test
    void makeRandomNumberMap() {
    }

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