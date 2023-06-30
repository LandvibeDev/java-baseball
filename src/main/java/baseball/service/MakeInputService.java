package baseball.service;

import baseball.domain.Form;
import baseball.domain.Number;

import static baseball.policy.CheckAllDifferentAndNotZeroPolicy.isValidNumber;
import static baseball.service.SplitService.*;


public class MakeInputService implements MakeNumberService {

    private static final MakeNumberService instance = new MakeInputService();

    public static MakeNumberService getInstance() {
        return instance;
    }

    private MakeInputService() {
    }

    @Override
    public Number makeNumber(int number) {
        Number inputNumber = split(number, Form.INPUT);

        if (!isValidNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
        return inputNumber;
    }

}
