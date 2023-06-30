package baseball;

public enum GameMessage {
    ENTER_NUMBERS_MESSAGE("숫자를 입력해주세요 : "),
    SUCCESS_MESSAGE("개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTTING("낫싱");

    public String message;

    GameMessage(String message) {
        this.message = message;
    }
}