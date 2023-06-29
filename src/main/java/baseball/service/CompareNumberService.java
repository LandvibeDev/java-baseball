package baseball.service;

import baseball.domain.Number;
import baseball.domain.Output;

import java.util.HashMap;
import java.util.Map;

public class CompareNumberService {
    Number inputNumber;
    private Map<Integer, Integer> answerNumberMap = new HashMap<>();
    private int strikeCount;
    private int ballCount;

    public void setNumbers(Number inputNumber, Number answerNumber) {
        this.inputNumber = inputNumber;
        answerNumberMap.put(answerNumber.getFirst(), 1);
        answerNumberMap.put(answerNumber.getSecond(), 2);
        answerNumberMap.put(answerNumber.getThird(), 3);
    }

    public void compare(int index, int data) {
        if (answerNumberMap.containsKey(data)) {
            if (answerNumberMap.get(data) == index) {
                strikeCount++;
                return;
            }
            ballCount++;
        }
    }

    public void compareNumbers() {
        compare(1, inputNumber.getFirst());
        compare(2, inputNumber.getSecond());
        compare(3, inputNumber.getThird());
    }

    public Output returnOutput() {
        return new Output(strikeCount, ballCount);
    }
}
