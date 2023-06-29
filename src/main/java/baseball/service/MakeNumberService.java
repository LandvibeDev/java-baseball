package baseball.service;


import baseball.domain.Number;

public interface MakeNumberService {
    void makeNumber(int number);
    Number returnNumber();
}
