package baseball.policy;

import baseball.domain.Number;

public class CheckAllDifferentAndNotZeroPolicy implements CheckValidNumberPolicy {

    public boolean isValidNumber(Number number) {
        if (number.getFirst() == 0 || number.getSecond() == 0 || number.getThird() == 0) {
            return false;
        }
        if (number.getFirst() == number.getSecond()) {
            return false;
        }
        if (number.getSecond() == number.getThird()) {
            return false;
        }
        if (number.getFirst() == number.getThird()) {
            return false;
        }

        return true;
    }
}
