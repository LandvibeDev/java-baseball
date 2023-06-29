package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.*;


public class BaseballService {
    private boolean[] vis = new boolean[10];


    public String makeRandomNumber() {
        boolean[] duplicate = new boolean[10];
        duplicate[0] = true;
        String result = "";
        for (int i = 0; i < DIGITS; i++) {
            int num = 0;
            while (duplicate[num]) {
                num = Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
            }
            duplicate[num] = true;
            vis[num] = true;
            result += num;
        }
        System.out.println(result);
        return result;

    }

    public ResultDto getResult(List<ResultEnum> enumList) {
        ResultDto resultDto = new ResultDto();
        if (enumList.isEmpty()) {
            return resultDto;
        }
        for (ResultEnum anEnum : enumList) {
            if (anEnum == ResultEnum.STRIKE) {
                resultDto.plusStrikeCount();
            } else if (anEnum == ResultEnum.BALL) {
                resultDto.plusBallCount();
            }
        }
        return resultDto;
    }

    public String finalResult(ResultDto resultDto) {
        if (resultDto.getStrikeCount() == DIGITS) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }
        if (resultDto.getBallCount() == 0 && resultDto.getStrikeCount() == 0) {
            return "낫싱";
        }
        if (resultDto.getBallCount() == 0) {
            return resultDto.getStrikeCount() + "스트라이크";
        }
        if (resultDto.getStrikeCount() == 0) {
            return resultDto.getBallCount() + "볼";
        }
        return resultDto.getBallCount() + "볼 " + resultDto.getStrikeCount() + "스트라이크";
    }

    public List<ResultEnum> iter(String randomNumber) throws IllegalArgumentException {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        checkException(input);
        List<ResultEnum> enums = new ArrayList<>();
        for (int i = 0; i < DIGITS; i++) {
            if (randomNumber.charAt(i) == input.charAt(i)) {
                enums.add(ResultEnum.STRIKE);
            } else if (vis[input.charAt(i) - '0']) {
                enums.add(ResultEnum.BALL);
            }
        }
        return enums;
    }

    public void checkException(String input) throws IllegalArgumentException {
        boolean[] used = new boolean[10];
        if (input.length() != DIGITS) {
            throw new IllegalArgumentException("종료");
        }
        for (int i = 0; i < DIGITS; i++) {
            if (input.charAt(i) - '0' < MIN_BOUND || input.charAt(i) - '0' > MAX_BOUND) {
                throw new IllegalArgumentException("종료");
            }
            if (used[input.charAt(i) - '0']) {
                throw new IllegalArgumentException();
            }
            used[input.charAt(i) - '0'] = true;
        }
    }
}
