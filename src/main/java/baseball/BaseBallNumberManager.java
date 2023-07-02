package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseBallNumberManager implements NumberManager {
    @Override
    public Number generate(int start, int end, int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int num = Randoms.pickNumberInRange(start, end);
            while (numbers.contains(num)) {
                num = Randoms.pickNumberInRange(start, end);
            }
            numbers.add(num);
        }
        return new Number(numbers);
    }

    @Override
    public Number parseInput(String input) throws IllegalArgumentException {
        if (input.length() <= 0 || input.length() > 3) {
            throw new IllegalArgumentException("입력 값은 세 자리 정수여야 합니다.");
        }

        try {
            int num1 = Integer.parseInt(input.substring(0, 1));
            int num2 = Integer.parseInt(input.substring(1, 2));
            int num3 = Integer.parseInt(input.substring(2, 3));

            if (num1 == 0 || num2 == 0 || num3 == 0) {
                throw new IllegalArgumentException("0은 입력할 수 없습니다.");
            }

            if (num1 == num2 || num2 == num3 || num3 == num1) {
                throw new IllegalArgumentException("서로 다른 세 자리 정수를 입력해 주세요.");
            }
            return new Number(new ArrayList<>(Arrays.asList(num1, num2, num3)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 정수여야 합니다.");
        }
    }

    @Override
    public Score calculate(Number user, Number computer) {
        int ball = 0;
        int strike = 0;

        List<Integer> userNumbers = user.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        for (int i = 0; i < userNumbers.size(); i++) {
            for (int j = 0; j < computerNumbers.size(); j++) {
                if (userNumbers.get(i).equals(computerNumbers.get(j))) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        return new Score(ball, strike);
    }
}
