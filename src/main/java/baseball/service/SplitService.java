package baseball.service;

import baseball.constant.Number;

import java.util.HashMap;
import java.util.Map;

public class SplitService {

    private boolean isValidRangeNumber(int number) {
        int minRange = (int) Math.pow(10, Number.LENGTH_OF_INPUT.value() - 1);
        int maxRange = (int) Math.pow(10, Number.LENGTH_OF_INPUT.value()) - 1;

        if (minRange <= number && number <= maxRange)
            return true;
        return false;
    }

    public Map<Integer, Integer> split(int number) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        if (!isValidRangeNumber(number)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < Number.LENGTH_OF_INPUT.value(); i++) {
            int key = number % 10;
            int value = Number.LENGTH_OF_INPUT.value() - 1 - i;

            numberMap.put(key, value);
            number /= 10;
        }

        return numberMap;
    }

}
