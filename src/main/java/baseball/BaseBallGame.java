package baseball;

import baseball.constant.*;
import baseball.domain.Number;
import baseball.domain.Score;
import baseball.service.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class BaseBallGame {

    private final MakeNumberService makeAnswerService;
    private final MakeNumberService makeInputNumberService;
    private final CompareNumberService compareNumberService;
    private final PrintScore printScore;

    public BaseBallGame(MakeNumberService makeAnswerService, MakeNumberService makeInputNumberService, CompareNumberService compareNumberService, PrintScore printScore) {
        this.makeAnswerService = makeAnswerService;
        this.makeInputNumberService = makeInputNumberService;
        this.compareNumberService = compareNumberService;
        this.printScore = printScore;
    }

    public Map<Integer, Integer> createRandomNumber() {
        Number answerNumber = makeAnswerService.makeNumber(-1);
        Map<Integer, Integer> answerNumberMap = compareNumberService.setAnswerNumbers(answerNumber);
        return answerNumberMap;
    }

    public Number createInputNumber() {
        System.out.print(Message.INPUT_NUMBER.get());

        String inputNumberCommand = Console.readLine();
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(inputNumberCommand);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
        Number inputNumberObject = makeInputNumberService.makeNumber(inputNumber);
        return inputNumberObject;
    }

    public Score compareNumberObjects(Map<Integer, Integer> answerNumberMap, Number inputNumberObject) {
        Score score = compareNumberService.compareNumbers(answerNumberMap, inputNumberObject);
        return score;
    }

    public boolean isNewGame() {
        System.out.println(Message.ASK_NEW_GAME.get());
        String endGameOrNotCommand = Console.readLine();
        int command;
        try {
            command = Integer.parseInt(endGameOrNotCommand);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }

        if (command == baseball.constant.Number.REPLAY_GAME.value()) {
            return true;
        }
        if (command == baseball.constant.Number.END_GAME.value()) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    public boolean compareNumbers(Map<Integer, Integer> answerNumberMap) {
        while (true) {
            Number inputNumber = createInputNumber();
            Score output = compareNumberObjects(answerNumberMap, inputNumber);
            printScore.printScore(output);

            if (printScore.isGameSuccess(output)) {
                boolean isReplay = isNewGame();
                return isReplay;
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
