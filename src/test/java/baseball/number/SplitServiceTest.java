package baseball.number;

import baseball.AppConfig;
import baseball.constant.Number;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplitServiceTest {

    AppConfig testAppConfig = new AppConfig();
    SplitService splitService = testAppConfig.splitService();

    @Test
    void 범위_벗어나면_에러발생() {
        //given
        int errorNumber = 10000;

        //when

        //then
        assertThrows(IllegalArgumentException.class, () ->
                splitService.split(errorNumber)
        );
    }

    @Test
    void split_정상_수행() {
        //given
        int number = 123;

        //when
        Map<Integer, Integer> numberMap = splitService.split(number);

        //then
        assertThat(numberMap.size()).isEqualTo(Number.LENGTH_OF_INPUT.value());
        assertThat(numberMap.containsKey(0)).isEqualTo(false);

    }
}