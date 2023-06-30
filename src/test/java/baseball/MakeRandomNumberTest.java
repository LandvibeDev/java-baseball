package baseball;

import baseball.domain.Number;
import baseball.service.MakeNumberService;
import baseball.service.MakeRandomAnswerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MakeRandomNumberTest {

    @Test
    void 랜덤_숫자_생성확인() {
        //given
        MakeNumberService makeRandomAnswerService = MakeRandomAnswerService.getInstance();

        //when
        Number answerNumber = makeRandomAnswerService.makeNumber(-1);
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
