package baseball;

import java.util.HashSet;
import java.util.Set;

public class ExceptionContoller {

    public void notIntegerException(String Number){   //정수 이외 값 불가
        for(int i=0; i<NumberInfo.SIZE_OF_NUMBER.getNumberInfo(); i++){     //입력 받은 값이 숫자 이외의 값인 경우 에외처리
            if(!Character.isDigit(Number.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
    }

    public void reduplicationException(String Number){    //중복 불가
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i<NumberInfo.SIZE_OF_NUMBER.getNumberInfo(); i++){
            set.add(Number.charAt(i));
        }
        if(!(set.size() == NumberInfo.SIZE_OF_NUMBER.getNumberInfo())){
            throw new IllegalArgumentException();
        }
    }

    public void notThreeDigitException(String Number){   //3자리 이외 수 불가
        if(Number.length() != NumberInfo.SIZE_OF_NUMBER.getNumberInfo()){    //입력 받은 숫자가 3자리가 아닐경우 예외처리
            throw new IllegalArgumentException();
        }
    }

    public void zeroValueException(String Number){
        for(int i=0; i<NumberInfo.SIZE_OF_NUMBER.getNumberInfo(); i++){
            if(Number.charAt(i) == '0'){
                throw new IllegalArgumentException();
            }
        }
    }
}
