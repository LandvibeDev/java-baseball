package baseball.service;

import baseball.constant.Number;
import baseball.policy.CheckAllDifferentAndNotZeroPolicy;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class MakeRandomAnswerService {

    private final CheckAllDifferentAndNotZeroPolicy checkAllDifferentAndNotZeroPolicy;

    public MakeRandomAnswerService(CheckAllDifferentAndNotZeroPolicy checkAllDifferentAndNotZeroPolicy) {
        this.checkAllDifferentAndNotZeroPolicy = checkAllDifferentAndNotZeroPolicy;
    }

    public Map<Integer, Integer> makeRandomNumber() {
        while (true) {
            Map<Integer, Integer> randomNumberMap = new HashMap<>();

            for (int index = 0; index < Number.LENGTH_OF_INPUT.value(); index++) {
                randomNumberMap.put(Randoms.pickNumberInRange(1, 9), index);
            }

/*            System.out.println("debug ::");
            for (int key : randomNumberMap.keySet())
                System.out.print(key);
            System.out.println();*/

            if (checkAllDifferentAndNotZeroPolicy.isValidNumber(randomNumberMap)) {
                return randomNumberMap;
            }
        }
    }
}
