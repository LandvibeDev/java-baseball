package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MakeInputNumberTest {

    AppConfig testAppConfig = new AppConfig();

    @Test
    void input_숫자_생성확인() {
        //given

        //when
        int number = 123;
        Map<Integer, Integer> inputNumberMap = testAppConfig.makeInputService().makeNumber(number);

        //then

        Assertions.assertEquals(0, inputNumberMap.get(1));
        Assertions.assertEquals(1, inputNumberMap.get(2));
        Assertions.assertEquals(2, inputNumberMap.get(3));
    }

    @Test
    void input_에러_확인() {
        //given
        int duplicateError = 111;
        int underNumberError = 12;
        int overNumberError = 1000;

        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testAppConfig.makeInputService().makeNumber(duplicateError));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testAppConfig.makeInputService().makeNumber(underNumberError));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testAppConfig.makeInputService().makeNumber(overNumberError));

    }

}
