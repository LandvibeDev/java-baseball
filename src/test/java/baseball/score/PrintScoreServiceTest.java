package baseball.score;

import baseball.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PrintScoreServiceTest {

    AppConfig testAppConfig = new AppConfig();
    PrintScoreService printScoreService = testAppConfig.printScoreService();

    void strike1_ball0_출력() {
        Score score_1_0 = new Score();
        score_1_0.addStrike(); // 1 0
        printScoreService.printScore(score_1_0);
    }

    String actualSystemOut() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); // 임시 캡쳐 용도
        PrintStream printStream = new PrintStream(byteArrayOutputStream); // PrintStream 새로 생성

        System.setOut(printStream); // 새로 생성한 printStream 을 System.out 에다가 set

        strike1_ball0_출력(); // 실행, 새로 생성한 byteArrayOutputStream 에 출력물 저장

        return byteArrayOutputStream.toString().trim();
    }

    @Test
    void score_정상_출력() {
        //given

        //when
        String actual = actualSystemOut();
        String expected = "1스트라이크";

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}