package baseball.number;

import baseball.AppConfig;
import baseball.constant.Number;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckValidNumberServiceTest {

    AppConfig testAppConfig = new AppConfig();
    CheckValidNumberService checkValidNumberService = testAppConfig.checkValidNumberService();

    @Test
    @DisplayName("숫자_범위_확인")
    void isValidRangeNumber() {
        //given
        int length = Number.LENGTH_OF_INPUT.value();
        Assertions.assertThat(length).isEqualTo(3);

        //when

        //then
        Assertions.assertThat(checkValidNumberService.isValidRangeNumber(99)).isEqualTo(false);
        Assertions.assertThat(checkValidNumberService.isValidRangeNumber(1000)).isEqualTo(false);
        Assertions.assertThat(checkValidNumberService.isValidRangeNumber(100)).isEqualTo(true);
    }

    @Test
    @DisplayName("적절한 데이터는 상수와 map의 사이즈가 동일하고, 0이 없어야 하며 invalid 할 시 false 반환")
    void isValidNumberMap() {
        //given
        Map<Integer, Integer> zeroInMap = new HashMap<>();
        zeroInMap.put(0, 0);
        zeroInMap.put(1, 1);
        zeroInMap.put(2, 2);

        Map<Integer, Integer> duplicatedMap = new HashMap<>();
        duplicatedMap.put(1, 0);
        duplicatedMap.put(1, 1);
        duplicatedMap.put(1, 2);

        //when

        //then
        Assertions.assertThat(checkValidNumberService.isValidNumberMap(zeroInMap)).isEqualTo(false);
        Assertions.assertThat(checkValidNumberService.isValidNumberMap(duplicatedMap)).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자가 아닌 input을 정수로 변환시 NumberFormatException 발생해서 IllegalArgumentException로 변환")
    void convertToInt() {
        //given
        String errorInput = "not integer, string input";

        //when

        //then
        assertThrows(IllegalArgumentException.class, () ->
                checkValidNumberService.convertToInt(errorInput)
        );
    }
}