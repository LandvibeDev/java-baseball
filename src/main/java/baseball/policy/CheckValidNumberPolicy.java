package baseball.policy;

import baseball.domain.Number;

public interface CheckValidNumberPolicy {
    boolean isValidNumber(Number number);
}
