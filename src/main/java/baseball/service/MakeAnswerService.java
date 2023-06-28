package baseball.service;

import baseball.domain.Answer;

public interface MakeAnswerService {
    void makeAnswer();
    Answer split(int number);
    Answer findAnswer();
}
