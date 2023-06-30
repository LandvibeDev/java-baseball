package baseball.policy;

import baseball.domain.Number;

public class CheckAllDifferentAndNotZeroPolicy {

    private static final CheckAllDifferentAndNotZeroPolicy instance = new CheckAllDifferentAndNotZeroPolicy();

    public static CheckAllDifferentAndNotZeroPolicy getInstance() {
        return instance;
    }

    private CheckAllDifferentAndNotZeroPolicy() {
    }

    public static boolean isValidNumber(Number number) {
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
