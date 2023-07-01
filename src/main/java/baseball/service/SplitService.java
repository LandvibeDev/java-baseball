package baseball.service;

import baseball.domain.Form;
import baseball.domain.Number;

public class SplitService {

    public static Number split(int number, Form form) {
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException();
        }

        int first;
        int second;
        int third;

        third = number % 10;
        number /= 10;

        second = number % 10;
        number /= 10;

        first = number;

        return new Number(first, second, third, form);
    }

}
