package baseball.service;

import baseball.domain.Form;
import baseball.domain.Number;

import static baseball.policy.CheckAllDifferentAndNotZeroPolicy.isValidNumber;
import static baseball.service.SplitService.*;


public class MakeInputService implements MakeNumberService {

    @Override
    public Number makeNumber(int number) {
        Number inputNumber = split(number, Form.INPUT);

        if (!isValidNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
        return inputNumber;
    }

}
