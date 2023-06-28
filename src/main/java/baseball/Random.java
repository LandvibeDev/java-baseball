package baseball;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;


public class Random {

    public int[] makeRandomNumbers() {
        Set<Integer> s = new HashSet<>();
        int[] randomNumbers = new int[3];
        while (s.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (s.contains(randomNumber)) {
               continue;
            }
            randomNumbers[s.size()] = randomNumber;
            s.add(randomNumber);
        }
        return randomNumbers;
    }
}
