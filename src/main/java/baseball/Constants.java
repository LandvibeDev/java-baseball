package baseball;

public final class Constants {
    public final class Number {
        public static final int LENGTH = 3;
        public static final int MIN_VALUE = 1;
        public static final int MAX_VALUE = 9;
    }

    public final class Symbol {
        public static final String END_GAME = "2";
        public static final String RESTART_GAME = "1";
    }

    public final class GameMessage {
        public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
        public static final String END_GAME = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        public static final String RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        public static final String STRIKES = "스트라이크";
        public static final String BALLS = "볼 ";
        public static final String NOTHING_ = "낫싱";
    }

    public final class ExceptionMessage {
        public static final String USER_INPUT = "1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해주세요.";
        public static final String STATE_OF_GAME = "1 또는 2를 입력해주세요.";
    }

    public static final String REGEX_PATTERN = "^[1-9](?!.*([1-9]).*\1)[1-9](?!.*\2)[1-9]$";
}