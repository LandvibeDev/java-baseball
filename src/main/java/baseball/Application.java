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
    public static int countStrike(String random_num, String input_num){
        int count = 0;
        for(int i = 0; i < 3; i++){
            if(random_num.charAt(i) == input_num.charAt(i)) count++;
        }
        return count;
    }
    public static int countBall(String random_num, String input_num){
        int count = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                if(random_num.charAt(i) == input_num.charAt(j) && i != j) count++;
            }
        }
        return count;
    }
    public static String setStr(int strike, int ball){
        String str;
        if(strike != 0 && ball != 0){
            str = ball + "볼 " + strike + "스트라이크";
            return str;
        }
        else if(strike == 0 && ball != 0){
            str = ball +"볼 ";
            return str;
        }
        else if(strike != 0 && ball == 0){
            str = strike + "스트라이크 ";
            return str;
        }
        return "낫싱";
    }

    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
    }
}
