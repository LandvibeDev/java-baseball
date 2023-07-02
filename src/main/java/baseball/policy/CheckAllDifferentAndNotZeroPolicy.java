package baseball.policy;

import baseball.constant.Number;

import java.util.Map;

public class CheckAllDifferentAndNotZeroPolicy {

    public boolean isValidNumber(Map<Integer, Integer> randomNumberMap) {

        if(randomNumberMap.size() != Number.LENGTH_OF_INPUT.value())
            return false;

        for (int key : randomNumberMap.keySet()) {
            if (key == 0)
                return false;
        }

        return true;
    }
}
