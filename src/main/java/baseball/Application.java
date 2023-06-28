package baseball;

import baseball.ball.Ball;
import baseball.ball.BallBoundary;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String createRandomBall(){
        Ball ball = new Ball(BallBoundary.MAX_VALUE.getValue(), BallBoundary.MIN_VALUE.getValue());
        return ball.getBall_number();
    }
    public static String input(){
        System.out.print("숫자를 입력해주세요 : ");
        String temp = Console.readLine();
        return temp;
    }

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }
}
