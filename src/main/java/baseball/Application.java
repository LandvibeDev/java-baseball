package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Scanner;


public class Application {



    public static void main(String[] args) throws IllegalArgumentException {
        //TODO: 숫자 야구 게임 구현
        BaseballService baseballService=new BaseballService();
        String randomNumber= baseballService.makeRandomNumber();
        String result="";
        int stop=1;
        while (stop == 1) {
            /*
            try {
                List<ResultEnum> enumList = baseballService.iter(randomNumber);
                result = baseballService.getResult(enumList);
                System.out.println(result);
                if (result.length() > 10) {
                    stop = Integer.parseInt(Console.readLine());
                    randomNumber = baseballService.makeRandomNumber();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

             */
            List<ResultEnum> enumList = baseballService.iter(randomNumber);
            result = baseballService.getResult(enumList);
            System.out.println(result);
            if (result.length() > 10) {
                stop = Integer.parseInt(Console.readLine());
                randomNumber = baseballService.makeRandomNumber();
            }
        }

    }
}
