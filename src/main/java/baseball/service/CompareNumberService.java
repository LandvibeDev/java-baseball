package baseball.service;

import baseball.domain.Number;
import baseball.domain.Output;

import java.util.HashMap;
import java.util.Map;

public class CompareNumberService {

    private static final CompareNumberService instance = new CompareNumberService();

    public static CompareNumberService getInstance() {
        return instance;
    }

    private CompareNumberService() {
    }

    public Map<Integer, Integer> setAnswerNumbers(Number answerNumber) {
        Map<Integer, Integer> answerNumberMap = new HashMap<>();

        answerNumberMap.put(answerNumber.getFirst(), 1);
        answerNumberMap.put(answerNumber.getSecond(), 2);
        answerNumberMap.put(answerNumber.getThird(), 3);

        return answerNumberMap;
    }

    private Output compareOne(Map<Integer, Integer> answerNumberMap, Output output, int data, int index) {
        if (answerNumberMap.containsKey(data)) {
            if (answerNumberMap.get(data) == index) {
                output.addStrike();
                return output;
            }
            output.addBall();
        }
        return output;
    }

    public Output compareNumbers(Map<Integer, Integer> answerNumberMap, Number inputNumber) {
        Output output = new Output();

        output = compareOne(answerNumberMap, output, inputNumber.getFirst(), 1);
        output = compareOne(answerNumberMap, output, inputNumber.getSecond(), 2);
        output = compareOne(answerNumberMap, output, inputNumber.getThird(), 3);

        return output;
    }
}
