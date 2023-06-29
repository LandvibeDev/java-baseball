package baseball;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {

    String inputString;

    Validation(String inputString) {
        this.inputString = inputString;
    }

    public void handleException() {
        lengthCheck();
        wrongInputCheck();
    }

    private void lengthCheck() {
        if (inputString.length() != BaseballGame.number) {
            throw new IllegalArgumentException("정해진 개수의 숫자만 입력해주세요");
        }
    }

    private void wrongInputCheck() {
        Set<Integer> set = new HashSet<>();
        String pattern = "^[" + BaseballGame.start + "-" + BaseballGame.end +"]*$";
        for (int i = 0; i < BaseballGame.number; i++) {
            if (!Pattern.matches(pattern, inputString)) {
                throw new IllegalArgumentException("정해진 범위 안의 숫자만 입력해주세요");
            }
            set.add(inputString.charAt(i) - '0');
        }
        if (set.size() != BaseballGame.number) {
            throw  new IllegalArgumentException();
        }
    }
}
