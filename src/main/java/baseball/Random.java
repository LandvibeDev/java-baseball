package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public ArrayList<Integer> makeRandomNumbers() {
        Set<Integer> numberSet = new HashSet<>();
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        while (numberSet.size() < BaseballGame.number) {
            int randomNumber = Randoms.pickNumberInRange(BaseballGame.start, BaseballGame.end);
            if (numberSet.contains(randomNumber)) {
               continue;
            }
            randomNumbers.add(randomNumber);
            numberSet.add(randomNumber);
        }
        return randomNumbers;
    }
}
