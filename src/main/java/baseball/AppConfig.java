package baseball;

import baseball.policy.CheckAllDifferentAndNotZeroPolicy;
import baseball.policy.CheckValidNumberPolicy;
import baseball.repository.AnswerRepository;
import baseball.repository.AnswerRepositoryImpl;
import baseball.service.MakeInputService;
import baseball.service.MakeNumberService;
import baseball.service.MakeRandomAnswerService;
import baseball.service.SplitService;

public class AppConfig {

    public AnswerRepository answerRepository() {
        return new AnswerRepositoryImpl();
    }

    public CheckValidNumberPolicy checkValidNumberPolicy() {
        return new CheckAllDifferentAndNotZeroPolicy();
    }

    public SplitService splitService() {
        return new SplitService();
    }

    public MakeNumberService makeRandomAnswerService() {
        return new MakeRandomAnswerService(answerRepository(), checkValidNumberPolicy(), splitService());
    }

    public MakeNumberService makeInputService() {
        return new MakeInputService(checkValidNumberPolicy(), splitService());
    }

}
