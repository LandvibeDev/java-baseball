package baseball.number;

import baseball.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MakeInputNumberServiceTest {

    AppConfig testAppConfig = new AppConfig();

    @Test
    void 맵_생성_성공() {
        //given

        //when
        String command = "123";
        Map<Integer, Integer> inputNumberMap = testAppConfig.makeInputNumberService().makeInputNumberMap(command);

        //then

        assertThat(inputNumberMap.get(1)).isEqualTo(0);
        assertThat(inputNumberMap.get(2)).isEqualTo(1);
        assertThat(inputNumberMap.get(3)).isEqualTo(2);

    }

    @Test
    void 에러_발생() {
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