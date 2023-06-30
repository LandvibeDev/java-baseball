package baseball;

public enum ExceptionMessage {
    WRONG_LENGTH("정해진 개수의 숫자만 입력해주세요"),
    WRONG_CHARACTER("정해진 범위 안의 숫자만 입력해주세요"),
    DUPLICATION("중복된 숫자가 입력되었습니다");

    public String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
