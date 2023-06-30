package baseball;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballGame {
    private int strikes;
    private int balls;
    private Vector<Integer> userNumber;
    private Vector<Integer> computerNumber;

    private void createRandomNumber() {
        computerNumber = new Vector<>();
        while (computerNumber.size() < Constants.Number.LENGTH) {
            int newNumber = Randoms.pickNumberInRange(Constants.Number.MIN_VALUE, Constants.Number.MAX_VALUE);
            if (computerNumber.contains(newNumber)) {
                continue;
            }
            computerNumber.add(newNumber);
        }
    }
}
