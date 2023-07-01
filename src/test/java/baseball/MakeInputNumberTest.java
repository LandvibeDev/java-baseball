package baseball;

import baseball.domain.Form;
import baseball.domain.Number;
import baseball.service.MakeInputService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MakeInputNumberTest {

    AppConfig appConfig = new AppConfig();
    @Test
    void input_숫자_생성확인() {
        //given

        //when
        int number = 123;
        Number inputNumber = appConfig.makeInputService().makeNumber(number);

        int first = inputNumber.getFirst();
        int second = inputNumber.getSecond();
        int third = inputNumber.getThird();
        Form form = inputNumber.getForm();

        //then
        Assertions.assertEquals(number, first * 100 + second * 10 + third);
        Assertions.assertEquals(form, Form.INPUT);
    }

    @Test
    void input_에러_확인() {
        //given
        MakeInputService makeInputService = appConfig.makeInputService();

        //when
        int errorNumber = 111;

        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> makeInputService.makeNumber(errorNumber));

    }
}
