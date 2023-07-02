package baseball.number;

import baseball.constant.Number;

import java.util.Map;

public class CheckValidNumberService {

    public boolean isValidRangeNumber(int number) {
        int lowerBound = (int) Math.pow(10, Number.LENGTH_OF_INPUT.value() - 1);
        int upperBound = (int) Math.pow(10, Number.LENGTH_OF_INPUT.value());

        boolean isValidRange = (lowerBound <= number && number < upperBound);
        return isValidRange;
    }

    public boolean isValidNumberMap(Map<Integer, Integer> randomNumberMap) {
        if (randomNumberMap.size() != Number.LENGTH_OF_INPUT.value())
            return false;

        if (randomNumberMap.containsKey(0))
            return false;

        return true;
    }

    // 비정상적인 input 이 들어와서 int 로 변환하지 못할 경우 IllegalArgumentException 발생

    public int convertToInt(String inputString) {
        try {
            int inputNumber = Integer.parseInt(inputString);
            return inputNumber;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
