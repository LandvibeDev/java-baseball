package baseball;

import baseball.service.*;

public class AppConfig {

    public CompareNumberService compareNumberService() {
        return new CompareNumberService();
    }

    public MakeInputService makeInputService() {
        return new MakeInputService();
    }

    public MakeRandomAnswerService makeRandomAnswerService() {
        return new MakeRandomAnswerService();
    }

    public PrintOutputService printOutputService() {
        return new PrintOutputService();
    }

    public BaseBallGame baseBallGame() {
        return new BaseBallGame(makeRandomAnswerService(), makeInputService(), compareNumberService(), printOutputService());
    }


}
