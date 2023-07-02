package baseball.service;

import baseball.domain.Score;

import java.util.Map;

public class CompareNumberService {

    private Score checkStrikeOrBall(Score score, int randomValue, int inputValue) {
        if (randomValue == inputValue) {
            score.addStrike();
            return score;
        }
        score.addBall();
        return score;
    }

    public Score compareNumbers(Map<Integer, Integer> randomNumberMap, Map<Integer, Integer> inputNumberMap) {
        Score score = new Score();

        for (int key : inputNumberMap.keySet()) {
            if (randomNumberMap.containsKey(key)) {
                score = checkStrikeOrBall(score, randomNumberMap.get(key), inputNumberMap.get(key));
            }
        }

        return score;
    }
}
