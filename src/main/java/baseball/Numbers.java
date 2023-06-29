package baseball;

public enum Numbers {
    LENGTH(3);
    private final int value;
    Numbers(int value) {this.value = value;}
    public int getValue(){return value;}
}
