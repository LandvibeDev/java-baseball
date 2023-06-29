package baseball.service;

import baseball.domain.Form;
import baseball.domain.Number;
import baseball.policy.CheckValidNumberPolicy;
import baseball.repository.AnswerRepository;
import camp.nextstep.edu.missionutils.Randoms;

public class MakeRandomAnswerService implements MakeNumberService {

    private final AnswerRepository answerRepository;
    private final CheckValidNumberPolicy checkValidNumberPolicy;
    private final SplitService splitService;

    public MakeRandomAnswerService(AnswerRepository answerRepository, CheckValidNumberPolicy checkValidNumberPolicy, SplitService splitService) {
        this.answerRepository = answerRepository;
        this.checkValidNumberPolicy = checkValidNumberPolicy;
        this.splitService = splitService;
    }

    @Override
    public void makeNumber(int number) throws IllegalArgumentException {
        while (true) {
            number = Randoms.pickNumberInRange(100, 999);
            Number answerNumber = splitService.split(number, Form.ANSWER);

            if (checkValidNumberPolicy.isValidNumber(answerNumber)) {
                answerRepository.save(answerNumber);
                return;
            }
        }
    }

    @Override
    public Number returnNumber() {
        return answerRepository.getAnswer();
    }
}
