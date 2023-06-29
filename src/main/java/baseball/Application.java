package baseball;

import java.util.List;
import java.util.Scanner;

public class Application {

    private static  BaseballService baseballService=new BaseballService();

    public static void main(String[] args)  {
        //TODO: 숫자 야구 게임 구현
        Scanner scan = new Scanner(System.in);
        String  input="000";
        baseballService.init();
        while(true){
            System.out.println("숫자를 입력해주세요 : ");

            try{//이거의 인덴트를 어떻게 줄여볼까..? 그냥 try없이 해도 되는거 아닌가
                input = scan.nextLine();
                if(input.length()!=3){
                    throw new IllegalAccessException("종료");
                }
                for(int i=0;i<3;i++){
                    if(input.charAt(i)-'0'>10||input.charAt(i)-'0'<0){
                      throw  new IllegalAccessException("종료");
                    }
                }
            }catch (Exception e){
                System.out.println(e);
                break;
            }


            List<ResultEnum> enumList =baseballService.checkVis(input);
            String output=baseballService.finalResult(enumList);
            System.out.println(output);
            if(output.length()>10){
                int a=scan.nextInt();;
                scan.nextLine();
                if(a==1){
                    baseballService.init();;
                }else if(a==2){
                    break;
                }

            }

        }
    }

}
