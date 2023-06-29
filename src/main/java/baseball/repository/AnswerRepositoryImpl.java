package baseball.repository;

import baseball.domain.Number;

public class AnswerRepositoryImpl implements AnswerRepository {

    private Number answerNumber;

    @Override
    public void save(Number answerNumber) {
        this.answerNumber = answerNumber;
    }

    @Override
    public Number getAnswer() {
        return answerNumber;
    }
}
