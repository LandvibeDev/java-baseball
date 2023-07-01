package baseball;

import baseball.policy.CheckAllDifferentAndNotZeroPolicy;
import baseball.service.CompareNumberService;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        appConfig.baseBallGame().play();
    }
}
