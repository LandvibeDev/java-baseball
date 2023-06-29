package baseball.domain;


public class Number {
    private int first;
    private int second;
    private int third;
    private Form form;

    public Number(int first, int second, int third, Form form) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.form = form;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public Form getForm() {
        return form;
    }
}
