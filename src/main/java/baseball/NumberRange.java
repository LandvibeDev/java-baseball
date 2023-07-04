package baseball;

public enum NumberRange {
    START(1), END(9), COUNT(3);

    public int value() {
        return value;
    }

    private final int value;

    NumberRange(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
