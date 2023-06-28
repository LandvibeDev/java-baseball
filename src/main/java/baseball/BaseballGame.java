package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    int[] randomNumbers = new int[3];
    int[] inputNumbers = new int[3];

    public void start() {
        getRandomNumbers();
        playGame();
        goOrStop();
    }

    private void getRandomNumbers() {
        Random random = new Random();
        randomNumbers = random.makeRandomNumbers();
    }

    private void getInputNumbers() {
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        exceptionHandler.handleException(input);
        for (int i = 0; i < 3; i++) {
            inputNumbers[i] = input.charAt(i) - '0';
        }
    }

    private void playGame() {
        while (true) {
            getInputNumbers();
            int strike = checkStrike();
            int ball = checkBall();
            if (getResult(strike, ball)) {
                break;
            }
        }
    }

    private void goOrStop() {
        String input = Console.readLine();
        if (input.contains("1")) {
            start();
        }
    }

    private int checkStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumbers[i] == inputNumbers[i]) {
                strike++;
                inputNumbers[i] = -1;
            }
        }
        return strike;
    }

    private int checkBall() {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (randomNumbers[i] == inputNumbers[j]) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private boolean getResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
            if (strike == 0) {
                System.out.println();
            }
        }
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                return true;
            }
        }
        return false;
    }
}