package baseball;

import baseball.ball.Ball;
import baseball.ball.BallBoundary;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String createRandomBall(){
        Ball ball = new Ball(BallBoundary.MAX_VALUE.getValue(), BallBoundary.MIN_VALUE.getValue());
        return ball.getBallNumber();
    }
    public static String input(){
        System.out.print("숫자를 입력해주세요 : ");
        String temp = Console.readLine();
        return temp;
    }

    public static void checkException(String number){
        if(number.length() != Numbers.LENGTH.getValue()) {
            throw new IllegalArgumentException(); // 세자리 수
        }
        if(number.contains("0")) {
            throw new IllegalArgumentException(); // 0이 있는지
        }
        for(int i = 0; i < number.length(); i++){
            if(!(number.charAt(i) > '0' && number.charAt(i) <= '9')) throw new IllegalArgumentException(); //숫자가 아닌지
        }
        checkRepeated(number);
    }

    private static void checkRepeated(String number) {
        for(int i = 0; i < number.length()-1; i++){
            for(int j = i+1; j < number.length(); j++){
                if(number.charAt(i) == number.charAt(j))throw new IllegalArgumentException();
            }
        }
    }

    public static int countStrike(String randomNum, String inputNum){
        int count = 0;
        for(int i = 0; i < Numbers.LENGTH.getValue(); i++){
            if(randomNum.charAt(i) == inputNum.charAt(i)) count++;
        }
        return count;
    }
    public static int countBall(String randomNum, String inputNum){
        int count = 0;
        for(int i = 0; i < Numbers.LENGTH.getValue(); i++) {
            for(int j = 0; j < Numbers.LENGTH.getValue(); j++){
                if(randomNum.charAt(i) == inputNum.charAt(j) && i != j) count++;
            }
        }
        return count;
    }
    public static String printHint(int strike, int ball){
        String str;
        if(strike != 0 && ball != 0){
            str = ball + HintString.BALL.getValue() + strike + HintString.STRIKE.getValue();;
            return str;
        }
        else if(strike == 0 && ball != 0){
            str = ball +HintString.BALL.getValue();;
            return str;
        }
        else if(strike != 0 && ball == 0){
            str = strike + HintString.STRIKE.getValue();
            return str;
        }
        return HintString.NOTHING.getValue();
    }
    public static void startGame(){
        String randNum = createRandomBall();
        String inputNum = "";
        while(!randNum.equals(inputNum)) {
            inputNum = input();
            checkException(inputNum);
            int strike = countStrike(randNum, inputNum);
            int ball = countBall(randNum, inputNum);
            String result = printHint(strike, ball);
            System.out.println(result);
            if (strike == Numbers.LENGTH.getValue()) {
                System.out.println("Numbers.LENGTH.getValue()개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
