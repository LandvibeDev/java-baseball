package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;



public class Application {


    public static void main(String[] args) throws IllegalArgumentException {
        //TODO: 숫자 야구 게임 구현
        BaseballService baseballService = new BaseballService();
        String randomNumber = baseballService.makeRandomNumber();
        while (true) {
            List<ResultEnum> enumList = baseballService.iter(randomNumber);
            ResultDto result = baseballService.getResult(enumList);
            String finalResult = baseballService.finalResult(result);
            System.out.println(finalResult);
            if (finalResult.length() > 10) {
                String input = Console.readLine();
                int stop = Integer.parseInt(input);
                if (stop == 2) {
                    break;
                }
                randomNumber = baseballService.makeRandomNumber();
            }
        }
        System.out.println("게임 종료");

    }
}
