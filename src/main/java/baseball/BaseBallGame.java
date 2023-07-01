package baseball;

import baseball.domain.Number;
import baseball.domain.Output;
import baseball.service.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class BaseBallGame {

    private final MakeNumberService makeAnswerService;
    private final MakeNumberService makeInputNumberService;
    private final CompareNumberService compareNumberService;
    private final PrintOutputService printOutputService;

    public BaseBallGame(MakeNumberService makeAnswerService, MakeNumberService makeInputNumberService, CompareNumberService compareNumberService, PrintOutputService printOutputService) {
        this.makeAnswerService = makeAnswerService;
        this.makeInputNumberService = makeInputNumberService;
        this.compareNumberService = compareNumberService;
        this.printOutputService = printOutputService;
    }

    public Map<Integer, Integer> createRandomNumber() {
        Number answerNumber = makeAnswerService.makeNumber(-1);
        return compareNumberService.setAnswerNumbers(answerNumber);
    }

    public Number createInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        String inputNumberCommand = Console.readLine();
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(inputNumberCommand);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
        return makeInputNumberService.makeNumber(inputNumber);
    }

    public Output compareNumberObjects(Map<Integer, Integer> answerNumberMap, Number inputNumberObject) {
        return compareNumberService.compareNumbers(answerNumberMap, inputNumberObject);
    }

    public boolean isNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String endGameOrNotCommand = Console.readLine();
        int command;
        try {
            command = Integer.parseInt(endGameOrNotCommand);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }

        if (command == 1) {
            return true;
        }
        if (command == 2) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public boolean compareNumbers(Map<Integer, Integer> answerNumberMap) {
        while (true) {
            Number inputNumber = createInputNumber();
            Output output = compareNumberObjects(answerNumberMap, inputNumber);
            printOutputService.printOutput(output);

            if (printOutputService.isGameSuccess(output)) {
                return isNewGame();
            }
        }
    }

    public void play() {
        while (true) {
            Map<Integer, Integer> answerNumberMap = createRandomNumber();

            boolean isReplay = compareNumbers(answerNumberMap);
            if (!isReplay) {
                return;
            }
        }
    }

}
