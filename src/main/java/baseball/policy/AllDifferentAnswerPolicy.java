package baseball.policy;

import baseball.domain.Answer;

public class AllDifferentAnswerPolicy implements AnswerPolicy {

    public boolean isValidAnswer(Answer answer) {
        if (answer.getFirst() == 0) {
            return false;
        }
        if (answer.getFirst() == answer.getSecond()) {
            return false;
        }
        if (answer.getSecond() == answer.getThird()) {
            return false;
        }
        if (answer.getFirst() == answer.getThird()) {
            return false;
        }

        return true;
    }
}
