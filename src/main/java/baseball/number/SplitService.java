package baseball.number;

import baseball.constant.Number;

import java.util.HashMap;
import java.util.Map;

public class SplitService {

    private final CheckValidNumberService checkValidNumberService;

    public SplitService(CheckValidNumberService checkValidNumberService) {
        this.checkValidNumberService = checkValidNumberService;
    }

    public Map<Integer, Integer> split(int number) {
        if (!checkValidNumberService.isValidRangeNumber(number)) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < Number.LENGTH_OF_INPUT.value(); i++) {
            int key = number % 10;
            int value = Number.LENGTH_OF_INPUT.value() - 1 - i;

            numberMap.put(key, value);
            number /= 10;
        }

        return numberMap;
    }

}
