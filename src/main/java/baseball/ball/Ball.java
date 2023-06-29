package baseball.ball;

import camp.nextstep.edu.missionutils.Randoms;

public class Ball {
    String ballNumber = new String();


    public Ball(int max_value,int min_value){
        while(ballNumber.length() < 3){
            String temp = String.valueOf(Randoms.pickNumberInRange(min_value,max_value));
            if(!ballNumber.contains(temp)) ballNumber += temp;
        }
    }
    public String getBallNumber(){
        return ballNumber.toString();
    }
}
