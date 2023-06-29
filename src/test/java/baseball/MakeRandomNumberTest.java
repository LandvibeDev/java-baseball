package baseball;

import baseball.domain.Number;
import baseball.service.MakeNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MakeRandomNumberTest {

    @Test
    void 랜덤_숫자_생성확인() {
        //given
        AppConfig appConfig = new AppConfig();
        MakeNumberService makeRandomAnswerService = appConfig.makeRandomAnswerService();

        //when
        makeRandomAnswerService.makeNumber(-1);
        Number answerNumber = makeRandomAnswerService.returnNumber();
        int first = answerNumber.getFirst();
        int second = answerNumber.getSecond();
        int third = answerNumber.getThird();

        //then
        Assertions.assertNotEquals(first, 0);
        Assertions.assertNotEquals(second, 0);
        Assertions.assertNotEquals(third, 0);

        Assertions.assertNotEquals(first, second);
        Assertions.assertNotEquals(second, third);
        Assertions.assertNotEquals(first, third);

    }
}
