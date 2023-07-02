package baseball.number;

import baseball.constant.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class MakeRandomNumberService {

    private final CheckValidNumberService checkValidNumberService;

    public MakeRandomNumberService(CheckValidNumberService checkValidNumberService) {
        this.checkValidNumberService = checkValidNumberService;
    }

    public Map<Integer, Integer> makeRandomNumberMap() {
        while (true) {
            Map<Integer, Integer> randomNumberMap = new HashMap<>();

            for (int index = 0; index < Number.LENGTH_OF_INPUT.value(); index++) {
                randomNumberMap.put(Randoms.pickNumberInRange(1, 9), index);
            }

            if (checkValidNumberService.isValidNumberMap(randomNumberMap)) {
                return randomNumberMap;
            }
        }
    }
}
