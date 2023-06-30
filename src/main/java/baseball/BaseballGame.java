package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

import static baseball.GameMessage.*;

public class BaseballGame {

    private int strike;
    private int ball;
    private String result;

    private ArrayList<Integer> randomNumbers;
    private ArrayList<Integer> inputNumbers;

    BaseballGame() {
        randomNumbers = new ArrayList<>();
        inputNumbers = new ArrayList<>();
    }

    public void start() {
        getRandomNumbers();
        do {
            getInputNumbers();
            checkStrikeAndBall();
            getResult();
            printResult();
        } while (!isSuccess());
        restartOrExit();
    }

    private void getRandomNumbers() {
        Random random = new Random();
        randomNumbers = random.makeRandomNumbers();
    }

    private void getInputNumbers() {
        inputNumbers.clear();
        System.out.print(ENTER_NUMBERS.message);
        String inputString = Console.readLine();
        Validation validation = new Validation();
        validation.validateInput(inputString);
        for (int i = 0; i < Rule.number; i++) {
            inputNumbers.add(inputString.charAt(i) - '0');
        }
    }

    private void initializeScore() {
        strike = 0;
        ball = 0;
    }

    private void checkStrikeAndBall() {
        initializeScore();
        for (int i = 0; i <Rule.number; i++) {
            if (randomNumbers.get(i) == inputNumbers.get(i)) {
                strike++;
                inputNumbers.set(i, -1);
            }
            for (int j = 0; j < Rule.number; j++) {
                if (randomNumbers.get(i) == inputNumbers.get(j)) {
                    ball++;
                }
            }
        }
    }

    private void getResult() {
        result = "";
        if (strike == 0 && ball == 0) {
            result += NOTTING.message;
        }
        if (ball > 0) {
            result += ball + BALL.message;
        }
        if (strike > 0) {
            result += strike + STRIKE.message;
        }
    }

    private void printResult() {
        System.out.println(result);
    }

    private void printWhenSuccess() {
        System.out.println(Rule.number + SUCCESS.message);
        System.out.println(ASK_RETRY.message);
    }

    private boolean isSuccess() {
        if (strike == Rule.number) {
            printWhenSuccess();
            return true;
        }
        return false;
    }

    private void restartOrExit() {
        String input = Console.readLine();
        if (!input.equals(Constant.RESTART.value)) {
            return;
        }
        start();
    }
}