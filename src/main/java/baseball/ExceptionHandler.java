package baseball;

import java.util.HashSet;
import java.util.Set;

public class ExceptionHandler {

    public void handleException(String input) {
        lengthCheck(input);
        wrongInputCheck(input);
    }

    private void lengthCheck(String input) {
        if (input.length() < 3 || input.length() > 3) {
            throw new IllegalArgumentException("세개의 숫자만 입력하세요");
        }
    }

    private void wrongInputCheck(String input) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(input.charAt(i) - '0');
            if (input.charAt(i) - '0' <= 0 || input.charAt(i) - '0' > 9) {
                throw new IllegalArgumentException("1-9 숫자만 가능합니다");
            }
        }
        if (set.size() < 3) {
            throw  new IllegalArgumentException();
        }
    }
}
