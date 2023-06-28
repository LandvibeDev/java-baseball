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

    public static void checkException(String number){
        if(number.length() != 3) {
            throw new IllegalArgumentException(); // 세자리 수
        }
        if(number.contains("0")) {
            throw new IllegalArgumentException(); // 0이 있는지
        }
        for(int i = 0; i < number.length(); i++){
            if(!(number.charAt(i) > 0 && number.charAt(i) <= 9)) throw new IllegalArgumentException(); //숫자가 아닌지
        }
        if(number.length() != 3)throw new IllegalArgumentException(); // 길이가 다른지

    }


    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }
}
