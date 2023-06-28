package baseball.ball;

import camp.nextstep.edu.missionutils.Randoms;

public class Ball {
    String ball_number = new String();


    public Ball(int max_value,int min_value){
        while(ball_number.length() < 3){
            String temp = String.valueOf(Randoms.pickNumberInRange(min_value,max_value));
            if(!ball_number.contains(temp)) ball_number += temp;
        }
    }
    public String getBall_number(){
        return ball_number.toString();
    }
}
