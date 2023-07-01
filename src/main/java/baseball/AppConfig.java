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

    public PrintScore printScore() {
        return new PrintScore();
    }

    public BaseBallGame baseBallGame() {
        return new BaseBallGame(makeRandomAnswerService(), makeInputService(), compareNumberService(), printScore());
    }


}
