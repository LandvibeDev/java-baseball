package baseball;

import baseball.number.CheckValidNumberService;
import baseball.number.MakeInputNumberService;
import baseball.number.MakeRandomNumberService;
import baseball.score.MakeScoreService;
import baseball.score.PrintScoreService;
import baseball.constant.*;
import baseball.score.Score;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class BaseBallGame {

    private final MakeRandomNumberService makeRandomNumberService;
    private final MakeInputNumberService makeInputNumberService;
    private final MakeScoreService makeScoreService;
    private final PrintScoreService printScoreService;
    private final CheckValidNumberService checkValidNumberService;

    public BaseBallGame(MakeRandomNumberService makeRandomNumberService, MakeInputNumberService makeInputNumberService, MakeScoreService makeScoreService, PrintScoreService printScoreService, CheckValidNumberService checkValidNumberService) {
        this.makeRandomNumberService = makeRandomNumberService;
        this.makeInputNumberService = makeInputNumberService;
        this.makeScoreService = makeScoreService;
        this.printScoreService = printScoreService;
        this.checkValidNumberService = checkValidNumberService;
    }

    private String readInputNumberString() {
        System.out.print(Message.INPUT_NUMBER.get());
        String inputNumberString = Console.readLine();

        return inputNumberString;
    }

    private String readEndGameOrNotString() {
        System.out.println(Message.ASK_NEW_GAME.get());
        String endGameOrNotCommand = Console.readLine();

        return endGameOrNotCommand;
    }


    public boolean isNewGame() {
        String endGameOrNotCommand;
        endGameOrNotCommand = readEndGameOrNotString();

        int command;
        command = checkValidNumberService.convertToInt(endGameOrNotCommand);

        if (command == baseball.constant.Number.REPLAY_GAME.value()) {
            return true;
        }

        if (command == baseball.constant.Number.END_GAME.value()) {
            return false;
        }

        throw new IllegalArgumentException();
    }


    public boolean matchRandomNumber(Map<Integer, Integer> randomNumberMap) {
        while (true) {
            String inputNumberString;
            inputNumberString = readInputNumberString();

            Map<Integer, Integer> inputNumberMap;
            inputNumberMap = makeInputNumberService.makeInputNumberMap(inputNumberString);

            Score score;
            score = makeScoreService.compareNumbersAndMakeScore(randomNumberMap, inputNumberMap);

            printScoreService.printScore(score);

            if (score.checkGameSuccess()) {
                boolean isReplay = isNewGame();
                return isReplay;
            }
        }
    }

    public void playBaseBallGame() {
        while (true) {
            Map<Integer, Integer> randomNumberMap;
            randomNumberMap = makeRandomNumberService.makeRandomNumberMap();

            boolean isReplay;
            isReplay = matchRandomNumber(randomNumberMap);

            if (!isReplay) {
                return;
            }
        }
    }

}
