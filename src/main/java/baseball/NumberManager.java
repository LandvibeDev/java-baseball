package baseball;

public interface NumberManager {
    Number generate(int start, int end, int count);

    Number parseInput(String input) throws IllegalArgumentException;

    Score calculate(Number user, Number computer);
}
