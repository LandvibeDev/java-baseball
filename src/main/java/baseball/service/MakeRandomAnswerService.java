package baseball.service;

import baseball.domain.Form;
import baseball.domain.Number;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.policy.CheckAllDifferentAndNotZeroPolicy.isValidNumber;

public class MakeRandomAnswerService implements MakeNumberService {

    @Override
    public Number makeNumber(int number) {
        while (true) {
            int first = Randoms.pickNumberInRange(1, 9);
            int second = Randoms.pickNumberInRange(1, 9);
            int third = Randoms.pickNumberInRange(1, 9);
            //System.out.println("debug :: " + number);
            Number answerNumber = new Number(first, second, third, Form.ANSWER);

            if (isValidNumber(answerNumber)) {
                return answerNumber;
            }
        }
    }
}
