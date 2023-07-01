package baseball.service;

import baseball.domain.Number;
import baseball.domain.Score;

import java.util.HashMap;
import java.util.Map;

public class CompareNumberService {

    public Map<Integer, Integer> setAnswerNumbers(Number answerNumber) {
        Map<Integer, Integer> answerNumberMap = new HashMap<>();

        answerNumberMap.put(answerNumber.getFirst(), 1);
        answerNumberMap.put(answerNumber.getSecond(), 2);
        answerNumberMap.put(answerNumber.getThird(), 3);

        return answerNumberMap;
    }

    private Score compareOne(Map<Integer, Integer> answerNumberMap, Score score, int data, int index) {
        if (answerNumberMap.containsKey(data)) {
            if (answerNumberMap.get(data) == index) {
                score.addStrike();
                return score;
            }
            score.addBall();
        }
        return score;
    }

    public Score compareNumbers(Map<Integer, Integer> answerNumberMap, Number inputNumber) {
        Score score = new Score();

        score = compareOne(answerNumberMap, score, inputNumber.getFirst(), 1);
        score = compareOne(answerNumberMap, score, inputNumber.getSecond(), 2);
        score = compareOne(answerNumberMap, score, inputNumber.getThird(), 3);

        return score;
    }
}
