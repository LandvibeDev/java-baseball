package baseball;

import baseball.service.MakeAnswerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogicTest {

    @Test
    void 랜덤_숫자_생성확인() {
        //given
        AppConfig appConfig = new AppConfig();
        MakeAnswerService makeAnswerService = appConfig.makeAnswerService();

        //when
        makeAnswerService.makeAnswer();
        int first = makeAnswerService.findAnswer().getFirst();
        int second = makeAnswerService.findAnswer().getSecond();
        int third = makeAnswerService.findAnswer().getThird();

        //then
        Assertions.assertNotEquals(first, second);
        Assertions.assertNotEquals(first, 0);
        Assertions.assertNotEquals(second, third);
        Assertions.assertNotEquals(first, third);
    }
}
