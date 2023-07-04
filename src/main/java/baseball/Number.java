package baseball;

import java.util.List;
import java.util.Objects;

public class Number {

    private final List<Integer> numbers;

    public Number(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(numbers, number.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
