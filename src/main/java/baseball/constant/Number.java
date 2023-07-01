package baseball.constant;

public enum Number {
    REPLAY_GAME(1), END_GAME(2), LENGTH_OF_INPUT(3);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
