package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import static baseball.NumberInfo.*;
import static baseball.Message.*;

public class ComputerFunction {
    UserFunction userFunction = new UserFunction();
    public void createRandomNumber(ArrayList<Integer> randomNumber){
        while(randomNumber.size() < SIZE_OF_NUMBER.getNumberInfo()){
            int tmp = Randoms.pickNumberInRange(START_OF_RANGE.getNumberInfo(), END_OF_RANGE.getNumberInfo());

            if(!randomNumber.contains(tmp)){
                randomNumber.add(tmp);
            }
        }
    }
    public void countCalculate(ArrayList<Integer> randomNumber){
        while(true) {
            String userNumber = userFunction.getUserNumber();

            int ballCount = 0;
            int strikeCount = 0;

            for (int i=0; i<SIZE_OF_NUMBER.getNumberInfo(); i++) {
                int tmp = userNumber.charAt(i) - '0';

                if (randomNumber.indexOf(tmp) == i) {
                    strikeCount++;
                }
                if (randomNumber.contains(tmp)) {
                    ballCount++;
                }
            }

            if (strikeCount == SIZE_OF_NUMBER.getNumberInfo()) {
                System.out.println(strikeCount + STRIKE_MESSAGE.getMessage());
                System.out.println(CORRECT_MESSAGE.getMessage());
                break;
            } else if (strikeCount == 0 && ballCount == 0) {
                System.out.println(NOTHING_MESSAGE.getMessage());
                continue;
            }
            System.out.println((ballCount-strikeCount) + BALL_MESSAGE.getMessage() +
                                strikeCount + STRIKE_MESSAGE.getMessage());
        }
    }
}
