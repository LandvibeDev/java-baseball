package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    int[] randomNumbers = new int[3];
    int[] inputNumbers = new int[3];

    private void getRandomNumbers() {
        Random random = new Random();
        randomNumbers = random.makeRandomNumbers();
    }

    private void getInputNumbers() {
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        exceptionHandler.handleException(input);
        for (int i=0; i<3; i++) {
            inputNumbers[i] = input.charAt(i) - '0';
        }
    }

    private int checkStrike() {
        int strike = 0;
        for (int i=0; i<3; i++) {
            if (randomNumbers[i] == inputNumbers[i]) {
                strike++;
                inputNumbers[i] = -1;
            }
        }
        return strike;
    }

    private int checkBall() {
        int ball = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (randomNumbers[i] == inputNumbers[j]) {
                    ball++;
                }
            }
        }
        return ball;
    }
}
