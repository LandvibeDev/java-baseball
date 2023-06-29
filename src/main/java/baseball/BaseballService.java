package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballService {
    private boolean[] vis=new boolean[10];//1~9까지 존재하는 숫자들을 true로 표시
    private int[] table=new int[3];//3개의 랜덤 숫자

    public int[] randomNumber(){
        int [] arr=new int[3];
        Random random=new Random();
        boolean [] temp=new boolean[10];
        for(int i=0;i<3;i++){
            while(true){
                int randomNumber = random.nextInt(9) + 1;
                if(!temp[randomNumber]){
                    temp[randomNumber]=true;
                    arr[i]=randomNumber;
                    break;
                }
            }
        }
        return arr;
    }

    public void init(){
        for(int i=0;i<10;i++){
            vis[i]=false;
        }

        table=randomNumber();
    }
    public List<ResultEnum> checkVis(String input){
        List<ResultEnum> enumList=new ArrayList<>();
        for(int i=0;i<3;i++){
            vis[table[i]]=true;//맞고
        }

        for(int i=0;i<3;i++){
            if(!vis[input.charAt(i)-'0']){// input 문자열의 길이가 0인 상태에서 input.charAt(i)를 실행하려고 하여 발생
                //없는 경
                continue;
            }//일단 여기부터는 숫자가 겹치긴 한다는거지

            if(input.charAt(i)-'0'== table[i]){
                enumList.add(ResultEnum.STRIKE);
                continue;
            }
            enumList.add(ResultEnum.BALL);
        }

        return enumList;
    }
    public String finalResult(List<ResultEnum> list){
        if (list.isEmpty()){
            return "낫싱";
        }
        int strike=0;
        int ball=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==ResultEnum.STRIKE){
                strike++;
            }else if(list.get(i)==ResultEnum.BALL){
                ball++;
            }
        }
        if(strike==3) {
            return "3스트라이크.\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요\n";
        }else if(ball==0){
            return strike+"스트라이크";
        }else if(strike==0){
            return ball+"볼";
        }else{
            return ball+"볼 "+strike+"스트라이크";
        }
    }

}
