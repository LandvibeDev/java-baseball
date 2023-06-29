package baseball;

import baseball.domain.Number;
import baseball.service.MakeNumberService;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        AppConfig appConfig = new AppConfig();
        MakeNumberService makeRandomAnswerService = appConfig.makeRandomAnswerService();
        MakeNumberService makeInputNumberService = appConfig.makeInputService();

        // random Number 객체 생성

        makeRandomAnswerService.makeNumber(-1);
        Number answerNumber = makeInputNumberService.returnNumber();

        //Input Number 객체 생성

        System.out.print("숫자를 입력해주세요 : ");

        String command = Console.readLine();
        int number = Integer.parseInt(command);
        makeInputNumberService.makeNumber(number);
        Number inputNumber = makeInputNumberService.returnNumber();



    }
}
