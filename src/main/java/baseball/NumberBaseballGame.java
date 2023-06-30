package baseball;

import java.util.Vector;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballGame {
    private int strikes;
    private int balls;
    private Vector<Integer> userNumber;
    private Vector<Integer> computerNumber;

    private void createRandomNumber() {
        computerNumber = new Vector<>();
        while(computerNumber.size() < Constants.Number.LENGTH) {
            int newNumber = Randoms.pickNumberInRange(Constants.Number.MIN_VALUE, Constants.Number.MAX_VALUE);
            if(computerNumber.contains(newNumber)) {
                continue;
            }
            computerNumber.add(newNumber);
        }
    }

    private void inputUserNumber() {
        userNumber = new Vector<>();
        System.out.println(Constants.GameMessage.INPUT_NUMBER);
        String input = Console.readLine();
        validTestInputUserNumber(input);
        for(char c : input.toCharArray()) {
            String letter = String.valueOf(c);
            userNumber.add(Integer.parseInt(letter));
        }
    }

    private void validTestInputUserNumber(String input) {
        boolean isValid = Pattern.matches(Constants.REGEX_PATTERN, input);
        if(!isValid) {
            throw new IllegalArgumentException(Constants.ExceptionMessage.USER_INPUT);
        }
    }

    private void checkAccuracy() {
        strikes = 0;
        balls = 0;
        for(int i = 0; i < 3; i++) {
            if(userNumber.get(i).equals(computerNumber.get(i))) {
                strikes++;
                continue;
            }
            if(computerNumber.contains(userNumber.get(i))) {
                balls++;
            }
        }
    }
}
