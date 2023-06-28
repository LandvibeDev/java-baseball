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
}
