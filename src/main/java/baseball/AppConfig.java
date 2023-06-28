package baseball;

import baseball.policy.AllDifferentAnswerPolicy;
import baseball.policy.AnswerPolicy;
import baseball.repository.AnswerRepository;
import baseball.repository.AnswerRepositoryImpl;
import baseball.service.MakeAnswerService;
import baseball.service.MakeRandomAnswerService;

public class AppConfig {

    public AnswerRepository answerRepository() {
        return new AnswerRepositoryImpl();
    }

    public AnswerPolicy answerPolicy() {
        return new AllDifferentAnswerPolicy();
    }

    public MakeAnswerService makeAnswerService() {
        return new MakeRandomAnswerService(answerRepository(), answerPolicy());
    }

}
