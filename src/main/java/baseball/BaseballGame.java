package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BaseballGame {
    private String userNumber = "";
    public void run(){
        while(true) {
            playGame();

            if(questRestartGame()){
                continue;
            }
            break;
        }
    }

    private void playGame(){
        ArrayList<Integer> randomNumber = new ArrayList<Integer>();
        createRandomNumber(randomNumber);
        countCalculate(randomNumber);
    }
    private void createRandomNumber(ArrayList<Integer> randomNumber){  //랜덤 숫자 받기

        while(randomNumber.size() < 3){     //중복 불가 3자리 수
            int tmp = Randoms.pickNumberInRange(1, 9);

            if(!randomNumber.contains(tmp)){
                randomNumber.add(tmp);
            }
        }
    }

    private void giveUserNumber(){  //유저 숫자 받기
        System.out.print("숫자를 입력해 주세요 : ");
        userNumber = Console.readLine();

        if(userNumber.length() != 3){    //입력 받은 숫자가 3자리가 아닐경우 예외처리
            throw new IllegalArgumentException();
        }

        for(int i=0; i<3; i++){     //입력 받은 값이 숫자 이외의 값인 경우 에외처리
            if(!Character.isDigit(userNumber.charAt(i))){
                throw new IllegalArgumentException();
            }
        }

        Set<Character> set = new HashSet<Character>();      //입력 받은 숫자가 중복된 경우 예외처리
        for(int i=0; i<3; i++){
            set.add(userNumber.charAt(i));
        }
        if(!(set.size() == 3)){
            throw new IllegalArgumentException();
        }
    }

    private void countCalculate(ArrayList<Integer> randomNumber){
        while(true) {
            giveUserNumber();

            int ballCount = 0;
            int strikeCount = 0;

            for (int i=0; i<3; i++) {
                int tmp = userNumber.charAt(i) - '0';

                if (randomNumber.indexOf(tmp) == i) {
                    strikeCount++;
                }
                if (randomNumber.contains(tmp)) {
                    ballCount++;
                }
            }

            if (strikeCount == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (strikeCount == 0 && ballCount == 0) {
                System.out.println("낫싱");
                continue;
            }
            System.out.println((ballCount-strikeCount) + "볼 " + strikeCount + "스트라이크");
        }
    }

    private boolean questRestartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String cmd = Console.readLine();

        if(!cmd.equals(1) && !cmd.equals(2)){
            throw new IllegalArgumentException();
        }

        if(cmd.equals("1")){
            return true;
        }
        return false;
    }

}
