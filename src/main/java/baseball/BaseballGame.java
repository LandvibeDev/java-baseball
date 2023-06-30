package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

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
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        Validation validation = new Validation();
        validation.validateInput(inputString);
        for (int i = 0; i < Rule.number; i++) {
            inputNumbers.add(inputString.charAt(i) - '0');
        }
    }

    private void checkStrikeAndBall() {
        strike = 0;
        ball = 0;
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

    private String getResult() {
        result = "";
        if (strike == 0 && ball == 0) {
            result += "낫싱";
        }
        if (ball > 0) {
            result += ball + "볼 ";
        }
        if (strike > 0) {
            result += strike + "스트라이크";
        }
        return result;
    }

    private void printResult() {
        System.out.println(result);
    }

    private void printWhenSuccess() {
        System.out.println(Rule.number + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
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