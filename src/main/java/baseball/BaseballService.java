package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class BaseballService {
    private boolean [] vis=new boolean[10];
/*
    public String makeRandomNumber(){
        String randomNumber="";
        List<Integer> arr=Randoms.pickUniqueNumbersInRange(1, 9, 3);
        for(int i=0;i<3;i++) {
            System.out.println(i+": "+arr.get(i));
            vis[arr.get(i)] = true;
            randomNumber += arr.get(i);
        }
       System.out.println(randomNumber);
        return randomNumber;
    }

여기서 왜 런타임인지 생각해보기
 */
    public String makeRandomNumber(){
        boolean[] duplicate=new boolean[10];
        String result="";
        for (int i = 0; i < 3; i++) {
            int num;
            do {
                num = Randoms.pickNumberInRange(1, 9);
            } while (duplicate[num]);
            duplicate[num] = true;
            vis[num]=true;
            result += num;
        }
        System.out.println(result);
        return result;

    }



    public String getResult(List<ResultEnum> enumList){
        List<ResultEnum> enums=enumList;
        int strike=0;
        int ball=0;
        if(enums.isEmpty()){
            return "낫싱";
        }
        for (ResultEnum anEnum : enums) {
            if(anEnum==ResultEnum.STRIKE){
                strike++;
            }else if(anEnum==ResultEnum.BALL){
                ball++;
            }
        }
        if(strike==3){
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }else if(ball==0){
            return strike+"스트라이크";
        }else if(strike==0){
            return ball+"볼";
        }
        return ball+"볼 "+strike+"스트라이크";
    }
    public List<ResultEnum> iter(String randomNumber) throws IllegalArgumentException{
        System.out.println("숫자를 입력해주세요 : ");
        String input="";
        input=Console.readLine();
        checkException(input);
        List<ResultEnum> enums=new ArrayList<>();
        for(int i=0;i<3;i++){
            if(randomNumber.charAt(i)==input.charAt(i)){
                enums.add(ResultEnum.STRIKE);
            }else if(vis[input.charAt(i)-'0']){
                enums.add(ResultEnum.BALL);
            }
        }
        return enums;
    }
    public void checkException(String input) throws IllegalArgumentException{
        boolean[] used=new boolean[10];
        if(input.length()!=3){
            throw new IllegalArgumentException("종료");
        }
        for(int i=0;i<3;i++){
            if(input.charAt(i)-'0'<1||input.charAt(i)-'0'>9){
                throw new IllegalArgumentException("종료");
            }
            if(used[input.charAt(i)-'0']){
                throw new IllegalArgumentException();
            }
            used[input.charAt(i)-'0']=true;
        }
    }
}
