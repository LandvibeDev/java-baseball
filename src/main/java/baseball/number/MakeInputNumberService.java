package baseball.number;

import java.util.Map;

public class MakeInputNumberService {

    private final SplitService splitService;
    private final CheckValidNumberService checkValidNumberService;

    public MakeInputNumberService(SplitService splitService, CheckValidNumberService checkValidNumberService) {
        this.splitService = splitService;
        this.checkValidNumberService = checkValidNumberService;
    }

    public Map<Integer, Integer> makeInputNumberMap(String inputString) {
        int inputNumber = checkValidNumberService.convertToInt(inputString);
        Map<Integer, Integer> inputNumberMap = splitService.split(inputNumber);

        if (!checkValidNumberService.isValidNumberMap(inputNumberMap)) {
            throw new IllegalArgumentException();
        }
        return inputNumberMap;
    }

}
