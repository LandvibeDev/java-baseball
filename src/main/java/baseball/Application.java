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
            if(!(number.charAt(i) > '0' && number.charAt(i) <= '9')) throw new IllegalArgumentException(); //숫자가 아닌지
        }
        for(int i = 0; i < number.length()-1; i++){
            for(int j = i+1; j < number.length(); j++){
                if(number.charAt(i) == number.charAt(j))throw new IllegalArgumentException();
            }
        }
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
    public static void startGame(){
        int strike = 0;
        int ball = 0;
        String randNum = createRandomBall();
        String inputNum = "";
        while(!randNum.equals(inputNum)) {
            inputNum = input();
            checkException(inputNum);
            strike = countStrike(randNum, inputNum);
            ball = countBall(randNum, inputNum);
            String result = setStr(strike, ball);
            System.out.println(result);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }
    public static boolean repeatGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String num = Console.readLine();
        if(num.equals("1")) return true;
        return false;
    }
    public static void game(){
        while(true){
            startGame();
            if(!repeatGame())return;
        }
    }


    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        game();
    }
}
