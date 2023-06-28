package baseball.repository;

import baseball.domain.Answer;

public class AnswerRepositoryImpl implements AnswerRepository {

    private Answer answer;

    @Override
    public void save(Answer answer) {
        this.answer = answer;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }
}
