package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    static int start = 1;
    static int end = 9;
    static int number = 3;

    int strike = 0;
    int ball = 0;

    ArrayList<Integer> randomNumbers = new ArrayList<>();
    ArrayList<Integer> inputNumbers = new ArrayList<>();

    public void start() {
        getRandomNumbers();
        playGame();
        restartOrExit();
    }

    private void getRandomNumbers() {
        Random random = new Random();
        randomNumbers = random.makeRandomNumbers();
    }

    private void getInputNumbers() {
        inputNumbers.clear();
        System.out.println("숫자를 입력해주세요 :");
        String inputString = Console.readLine();
        Validation validation = new Validation(inputString);
        validation.handleException();
        for (int i = 0; i < number; i++) {
            inputNumbers.add(inputString.charAt(i) - '0');
        }
    }

    private void playGame() {
        while (true) {
            getInputNumbers();
            checkStrikeAndBall();
            getResult();
            if (isSuccess()) {
                break;
            }
        }
    }

    private void restartOrExit() {
        String input = Console.readLine();
        if (input.equals(Constant.RESTART.value)) {
            start();
        }
    }

    private void checkStrikeAndBall() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < number; i++) {
            if (randomNumbers.get(i) == inputNumbers.get(i)) {
                strike++;
                inputNumbers.set(i, -1);
            }
            for (int j = 0; j < number; j++) {
                if (randomNumbers.get(i) == inputNumbers.get(j)) {
                    ball++;
                }
            }
        }
    }

    private boolean isSuccess() {
        if (strike == number) {
            System.out.println(number + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            return true;
        }
        return false;
    }

    private void getResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
            if (strike == 0) {
                System.out.println();
            }
        }
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
    }
}