package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.NumberRange.*;

public class GameController {

    private final NumberManager numberManager;

    public GameController(NumberManager numberManager) {
        this.numberManager = numberManager;
    }

    public void start() {
        while (true) {
            Number generatedNumber = numberManager.generate(START.value(), END.value(), COUNT.value());

            while (true) {
                Number inputNumber = readInput();
                Score score = numberManager.calculate(inputNumber, generatedNumber);
                println(score.toString());
                if (score.isDone()) {
                    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (isClose()) {
                println("게임 종료");
                break;
            }
        }
    }

    private void println(String str) {
        System.out.println(str);
    }

    private Number readInput() {
        String input = Console.readLine();
        return numberManager.parseInput(input);
    }

    private boolean isClose() {
        String input = Console.readLine();
        return input.equals("2");
    }
}
