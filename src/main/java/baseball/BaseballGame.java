package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class BaseballGame {
    private String userNumber;
    ExceptionContoller exeptionContol = new ExceptionContoller();
    public void run(){
        while(true) {
            playGame();

            if(askRestartGame()){
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
    private void createRandomNumber(ArrayList<Integer> randomNumber){

        while(randomNumber.size() < NumberInfo.SIZE_OF_NUMBER.getNumberInfo()){
            int tmp = Randoms.pickNumberInRange(NumberInfo.START_OF_RANGE.getNumberInfo(), NumberInfo.END_OF_RANGE.getNumberInfo());

            if(!randomNumber.contains(tmp)){
                randomNumber.add(tmp);
            }
        }
    }

    private void giveUserNumber(){  //유저 숫자 받기
        System.out.print(Message.INPUT_USERNUMBER_MESSAGE.getMessage());
        userNumber = Console.readLine();

        exeptionContol.notIntegerException(userNumber);
        exeptionContol.notThreeDigitException(userNumber);
        exeptionContol.reduplicationException(userNumber);
        exeptionContol.zeroValueException(userNumber);

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

    private boolean askRestartGame(){
        System.out.println(Message.RESTART_QUESTION_MESSAGE.getMessage());
        String cmd = Console.readLine();
        int restart = Integer.parseInt(cmd);

        if(restart == NumberInfo.RESTART_TRUE_NUMBER.getNumberInfo()){
            return true;
        }
        else if(restart == NumberInfo.RESTART_FALSE_NUMBER.getNumberInfo()){
            return false;
        }

        throw new IllegalArgumentException();
    }

}
