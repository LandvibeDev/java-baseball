package baseball;

import baseball.ball.Ball;
import baseball.ball.BallBoundary;

public class Application {
    public static String createRandomBall(){
        Ball ball = new Ball(BallBoundary.MAX_VALUE.getValue(), BallBoundary.MIN_VALUE.getValue());
        return ball.getBall_number();
    }

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }
}
