package baseball.domain;

public class Input {
    private int first;
    private int second;
    private int third;
    private Status status;

    public Input(int first, int second, int third, Status status) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.status = status;
    }
}
