package baseball.service;

import baseball.domain.Answer;
import baseball.policy.AnswerPolicy;
import baseball.repository.AnswerRepository;
import camp.nextstep.edu.missionutils.Randoms;

public class MakeRandomAnswerService implements MakeAnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerPolicy answerPolicy;

    public MakeRandomAnswerService(AnswerRepository answerRepository, AnswerPolicy answerPolicy) {
        this.answerRepository = answerRepository;
        this.answerPolicy = answerPolicy;
    }

    @Override
    public Answer split(int number) {
        int first;
        int second;
        int third;

        third = number % 10;
        number /= 10;

        second = number % 10;
        number /= 10;

        first = number;

        return new Answer(first, second, third);
    }

    @Override
    public void makeAnswer() {
        int number = Randoms.pickNumberInRange(100, 999);
        Answer answer = split(number);

        while (true) {
            if (answerPolicy.isValidAnswer(answer)) {
                answerRepository.save(answer);
                break;
            }
            number = Randoms.pickNumberInRange(100, 999);
            answer = split(number);
        }
    }

    @Override
    public Answer findAnswer() {
        return answerRepository.getAnswer();
    }
}
