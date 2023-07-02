package baseball;

import baseball.policy.CheckAllDifferentAndNotZeroPolicy;
import baseball.service.*;

public class AppConfig {

    public CompareNumberService compareNumberService() {
        return new CompareNumberService();
    }

    public MakeInputService makeInputService() {
        return new MakeInputService(splitService(), checkAllDifferentAndNotZeroPolicy());
    }

    public SplitService splitService(){
        return new SplitService();
    }

    public CheckAllDifferentAndNotZeroPolicy checkAllDifferentAndNotZeroPolicy(){
        return new CheckAllDifferentAndNotZeroPolicy();
    }

    public MakeRandomAnswerService makeRandomAnswerService() {
        return new MakeRandomAnswerService(checkAllDifferentAndNotZeroPolicy());
    }

    public ScoreService printScore() {
        return new ScoreService();
    }

    public BaseBallGame baseBallGame() {
        return new BaseBallGame(makeRandomAnswerService(), makeInputService(), compareNumberService(), printScore());
    }


}
