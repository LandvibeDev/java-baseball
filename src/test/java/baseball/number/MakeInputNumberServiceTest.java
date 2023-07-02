package baseball.number;

import baseball.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MakeInputNumberServiceTest {

    @Test
    void makeInputNumberMap() {
    }

    AppConfig testAppConfig = new AppConfig();

    @Test
    void input_숫자_생성확인() {
        //given

        //when
        String command = "123";
        Map<Integer, Integer> inputNumberMap = testAppConfig.makeInputNumberService().makeInputNumberMap(command);

        //then

        Assertions.assertEquals(0, inputNumberMap.get(1));
        Assertions.assertEquals(1, inputNumberMap.get(2));
        Assertions.assertEquals(2, inputNumberMap.get(3));
    }

    @Test
    void input_에러_확인() {
        //given
        String duplicateErrorNumber = "111";
        String underNumberErrorNumber = "12";
        String overNumberErrorNumber = "1000";

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testAppConfig.makeInputNumberService().makeInputNumberMap(duplicateErrorNumber));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testAppConfig.makeInputNumberService().makeInputNumberMap(underNumberErrorNumber));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testAppConfig.makeInputNumberService().makeInputNumberMap(overNumberErrorNumber));

    }
}