package baseball.service;

import baseball.domain.Form;
import baseball.domain.Number;
import baseball.policy.CheckValidNumberPolicy;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MakeInputService implements MakeNumberService {
    private static final Logger logger = Logger.getLogger(MakeNumberService.class.getName());

    private final CheckValidNumberPolicy checkValidNumberPolicy;
    private final SplitService splitService;
    private Number inputNumber;

    public MakeInputService(CheckValidNumberPolicy checkValidNumberPolicy, SplitService splitService) {
        this.checkValidNumberPolicy = checkValidNumberPolicy;
        this.splitService = splitService;
    }

    @Override
    public void makeNumber(int number) throws IllegalArgumentException {
        inputNumber = splitService.split(number, Form.INPUT);

        if (!checkValidNumberPolicy.isValidNumber(inputNumber)) {
            logger.log(Level.SEVERE, "IllegalArgumentException 발생", IllegalArgumentException.class);
            throw new IllegalArgumentException();
        }
    }


    @Override
    public Number returnNumber() {
        return this.inputNumber;
    }
}
