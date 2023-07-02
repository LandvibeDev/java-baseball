package baseball;

import baseball.number.MakeInputNumberService;
import baseball.number.MakeRandomNumberService;
import baseball.number.SplitService;
import baseball.score.MakeScoreService;
import baseball.score.PrintScoreService;
import baseball.number.CheckValidNumberService;

public class AppConfig {

    public MakeScoreService makeScoreService() {
        return new MakeScoreService();
    }

    public MakeInputNumberService makeInputNumberService() {
        return new MakeInputNumberService(splitService(), checkValidNumberService());
    }

    public SplitService splitService() {
        return new SplitService(checkValidNumberService());
    }

    public CheckValidNumberService checkValidNumberService() {
        return new CheckValidNumberService();
    }

    public MakeRandomNumberService makeRandomNumberService() {
        return new MakeRandomNumberService(checkValidNumberService());
    }

    public PrintScoreService printScoreService() {
        return new PrintScoreService();
    }

    public BaseBallGame baseBallGame() {
        return new BaseBallGame(makeRandomNumberService(), makeInputNumberService(), makeScoreService(), printScoreService(), checkValidNumberService());
    }


}
