package baseball.policy;

import baseball.domain.Answer;

public interface AnswerPolicy {
    boolean isValidAnswer(Answer answer);
}
