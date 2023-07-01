package baseball.constant;

public enum Message {
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    ASK_NEW_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL("볼 "),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    CLEAR_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
