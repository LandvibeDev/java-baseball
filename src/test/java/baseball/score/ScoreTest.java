package baseball.score;

import baseball.constant.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ScoreTest {


    @Test
    void 스트라이크3_게임종료_메세지출력확인() {
        //given
        Score score = strike3_ball0();

        //when
        String actualMessage = actualSystemOut(score);
        String expectedMessage = Message.CLEAR_GAME.get();

        //then
        Assertions.assertThat(score.checkGameSuccess()).isEqualTo(true);
        Assertions.assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    Score strike3_ball0() {
        Score score = new Score();
        score.addStrike();
        score.addStrike();
        score.addStrike();

        return score;
    }

    String actualSystemOut(Score score) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); // 임시 캡쳐 용도
        PrintStream printStream = new PrintStream(byteArrayOutputStream); // PrintStream 새로 생성

        System.setOut(printStream); // 새로 생성한 printStream 을 System.out 에다가 set

        score.checkGameSuccess(); // 실행, 새로 생성한 byteArrayOutputStream 에 출력물 저장

        return byteArrayOutputStream.toString().trim();
    }
}