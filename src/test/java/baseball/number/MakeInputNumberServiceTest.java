package baseball.number;

import baseball.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MakeInputNumberServiceTest {

    AppConfig testAppConfig = new AppConfig();
    CheckValidNumberService checkValidNumberService = testAppConfig.checkValidNumberService();
    SplitService splitService = testAppConfig.splitService();

    @Test
    void 맵_생성_성공() {
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

    @Test
    void 에러_인풋_통합_확인() {
        //given
        int zeroErrorInput = checkValidNumberService.convertToInt("012");
        Map<Integer, Integer> zeroErrorMap = splitService.split(zeroErrorInput);

        int duplicateErrorInput = checkValidNumberService.convertToInt("111");
        Map<Integer, Integer> duplicateErrorMap = splitService.split(duplicateErrorInput);

        int normalInput = checkValidNumberService.convertToInt("123");
        Map<Integer, Integer> normalMap = splitService.split(normalInput);

        //when

        //then
        assertThat(checkValidNumberService.isValidNumberMap(zeroErrorMap)).isEqualTo(false);
        assertThat(checkValidNumberService.isValidNumberMap(duplicateErrorMap)).isEqualTo(false);
        assertThat(checkValidNumberService.isValidNumberMap(normalMap)).isEqualTo(true);
    }
}