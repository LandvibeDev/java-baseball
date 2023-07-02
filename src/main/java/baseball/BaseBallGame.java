package baseball;

import baseball.constant.*;
import baseball.domain.Score;
import baseball.service.*;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class BaseBallGame {

    private final MakeRandomAnswerService makeAnswerService;
    private final MakeInputService makeInputNumberService;
    private final CompareNumberService compareNumberService;
    private final ScoreService scoreService;

    public BaseBallGame(MakeRandomAnswerService makeAnswerService, MakeInputService makeInputNumberService, CompareNumberService compareNumberService, ScoreService scoreService) {
        this.makeAnswerService = makeAnswerService;
        this.makeInputNumberService = makeInputNumberService;
        this.compareNumberService = compareNumberService;
        this.scoreService = scoreService;
    }

    public Map<Integer, Integer> createRandomNumber() {
        Map<Integer, Integer> randomNumberMap = makeAnswerService.makeRandomNumber();
        return randomNumberMap;
    }

    // 비정상적인 input 이 들어와서 int 로 변환하지 못할 경우 IllegalArgumentException 발생

    public int convertToInt(String command) {
        try {
            return Integer.parseInt(command);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public Map<Integer, Integer> createInputNumber() {
        System.out.print(Message.INPUT_NUMBER.get());

        String inputNumberCommand = Console.readLine();
        int inputNumber = convertToInt(inputNumberCommand);
        Map<Integer, Integer> inputNumberMap = makeInputNumberService.makeNumber(inputNumber);

        return inputNumberMap;
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

    public boolean compareNumbers(Map<Integer, Integer> randomNumberMap) {
        while (true) {
            Map<Integer, Integer> inputNumberMap = createInputNumber();
            Score score = compareNumberService.compareNumbers(randomNumberMap, inputNumberMap);
            scoreService.printScore(score);

            if (scoreService.isGameSuccess(score)) {
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
