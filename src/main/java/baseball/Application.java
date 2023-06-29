package baseball;

import baseball.domain.Number;
import baseball.domain.Output;
import baseball.service.CompareNumberService;
import baseball.service.MakeNumberService;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        AppConfig appConfig = new AppConfig();
        MakeNumberService makeAnswerService = appConfig.makeRandomAnswerService();
        MakeNumberService makeInputNumberService = appConfig.makeInputService();
        CompareNumberService compareNumberService = appConfig.compareNumberService();

        // random Number 객체 생성

        makeAnswerService.makeNumber(-1);
        Number answerNumber = makeAnswerService.returnNumber();

        //Input Number 객체 생성

        System.out.print("숫자를 입력해주세요 : ");

        String command = Console.readLine();
        int number = Integer.parseInt(command);
        makeInputNumberService.makeNumber(number);
        Number inputNumber = makeInputNumberService.returnNumber();

        // answer, input 비교
        compareNumberService.setNumbers(inputNumber,answerNumber);
        compareNumberService.compareNumbers();
        Output output = compareNumberService.returnOutput();

        //
    }
}
