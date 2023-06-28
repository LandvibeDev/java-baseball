package baseball.repository;

import baseball.domain.Answer;

public interface AnswerRepository {

    void save(Answer answer);
    Answer getAnswer();
}
