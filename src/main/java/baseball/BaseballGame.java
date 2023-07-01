package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseballGame {
    private String userNumber;
    public void run(){
        while(true) {
            playGame();

            if(questRestartGame()){
                continue;
            }
            break;
        }
    }

    private void playGame(){
        ArrayList<Integer> randomNumber = new ArrayList<Integer>();
        createRandomNumber(randomNumber);
        countCalculate(randomNumber);
    }
    private void createRandomNumber(ArrayList<Integer> randomNumber){  //랜덤 숫자 받기

        while(randomNumber.size() < NumberInfo.SIZE_OF_NUMBER.getNumberInfo()){     //중복 불가 3자리 수
            int tmp = Randoms.pickNumberInRange(NumberInfo.START_OF_RANGE.getNumberInfo(), NumberInfo.END_OF_RANGE.getNumberInfo());

            if(!randomNumber.contains(tmp)){
                randomNumber.add(tmp);
            }
        }
    }

    private void giveUserNumber(){  //유저 숫자 받기
        System.out.print(Message.INPUT_USERNUMBER_MESSAGE.getMessage());
        userNumber = Console.readLine();

        if(userNumber.length() != NumberInfo.SIZE_OF_NUMBER.getNumberInfo()){    //입력 받은 숫자가 3자리가 아닐경우 예외처리
            throw new IllegalArgumentException();
        }

        for(int i=0; i<3; i++){     //입력 받은 값이 숫자 이외의 값인 경우 에외처리
            if(!Character.isDigit(userNumber.charAt(i))){
                throw new IllegalArgumentException();
            }
        }

        Set<Character> set = new HashSet<Character>();      //입력 받은 숫자가 중복된 경우 예외처리
        for(int i=0; i<3; i++){
            set.add(userNumber.charAt(i));
        }
        if(!(set.size() == NumberInfo.SIZE_OF_NUMBER.getNumberInfo())){
            throw new IllegalArgumentException();
        }
    }

    private void countCalculate(ArrayList<Integer> randomNumber){
        while(true) {
            giveUserNumber();

            int ballCount = 0;
            int strikeCount = 0;

            for (int i=0; i<NumberInfo.SIZE_OF_NUMBER.getNumberInfo(); i++) {
                int tmp = userNumber.charAt(i) - '0';

                if (randomNumber.indexOf(tmp) == i) {
                    strikeCount++;
                }
                if (randomNumber.contains(tmp)) {
                    ballCount++;
                }
            }

            if (strikeCount == NumberInfo.SIZE_OF_NUMBER.getNumberInfo()) {
                System.out.println(strikeCount + Message.STRIKE_MESSAGE.getMessage());
                System.out.println(Message.CORRECT_MESSAGE.getMessage());
                break;
            } else if (strikeCount == 0 && ballCount == 0) {
                System.out.println(Message.NOTHING_MESSAGE.getMessage());
                continue;
            }
            System.out.println((ballCount-strikeCount) + Message.BALL_MESSAGE.getMessage() + strikeCount + Message.STRIKE_MESSAGE.getMessage());
        }
    }

    private boolean questRestartGame(){
        System.out.println(Message.RESTART_QUESTION_MESSAGE.getMessage());
        String cmd = Console.readLine();
        int restart = Integer.parseInt(cmd);

        if(restart == NumberInfo.RESTART_TRUE_NUMBER.getNumberInfo()){
            return true;
        }
        return false;
    }

}
