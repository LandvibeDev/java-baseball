package baseball.service;

import baseball.domain.Form;
import baseball.domain.Number;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SplitService {
    private static final Logger logger = Logger.getLogger(MakeNumberService.class.getName());

    public Number split(int number, Form form) throws IllegalArgumentException {
        if (number < 100 || number > 999) {
            logger.log(Level.SEVERE, "IllegalArgumentException 발생", IllegalArgumentException.class);
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
