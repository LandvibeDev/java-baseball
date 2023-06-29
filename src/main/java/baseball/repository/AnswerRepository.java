package baseball.repository;

import baseball.domain.Number;

public interface AnswerRepository {

    void save(Number answerNumber);
    Number getAnswer();
}
