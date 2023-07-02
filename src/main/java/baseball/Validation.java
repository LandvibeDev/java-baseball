package baseball;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {

    public void validateInput(String inputString) {
        lengthCheck(inputString);
        characterCheck(inputString);
        duplicationCheck(inputString);
    }

    private void lengthCheck(String inputString) {
        if (inputString.length() != Rule.NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_LENGTH.message);
        }
    }

    private void characterCheck(String inputString) {
        String pattern = makeRegularExpression();
        for (int i = 0; i < Rule.NUMBER; i++) {
            if (!Pattern.matches(pattern, inputString)) {
                throw new IllegalArgumentException(ExceptionMessage.WRONG_CHARACTER.message);
            }
        }
    }

    private String makeRegularExpression() {
        return "^[" + Rule.START + "-" + Rule.END +"]*$";
    }

    private void duplicationCheck(String inputString) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            set.add(inputString.charAt(i) - '0');
        }
        if (set.size() != inputString.length()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION.message);
        }
    }

}