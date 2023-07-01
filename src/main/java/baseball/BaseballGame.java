package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class BaseballGame {
    ComputerFunction computerFunction = new ComputerFunction();
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
        ArrayList<Integer> randomNumberlist = new ArrayList<Integer>();
        computerFunction.createRandomNumber(randomNumberlist);
        computerFunction.countCalculate(randomNumberlist);
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
