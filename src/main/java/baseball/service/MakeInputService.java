package baseball.service;

import baseball.policy.CheckAllDifferentAndNotZeroPolicy;

import java.util.Map;



public class MakeInputService {

    private final SplitService splitService;
    private final CheckAllDifferentAndNotZeroPolicy checkAllDifferentAndNotZeroPolicy;

    public MakeInputService(SplitService splitService, CheckAllDifferentAndNotZeroPolicy checkAllDifferentAndNotZeroPolicy) {
        this.splitService = splitService;
        this.checkAllDifferentAndNotZeroPolicy = checkAllDifferentAndNotZeroPolicy;
    }

    public Map<Integer, Integer> makeNumber(int number) {
        Map<Integer, Integer> inputNumber = splitService.split(number);

        if (!checkAllDifferentAndNotZeroPolicy.isValidNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
        return inputNumber;
    }

}
