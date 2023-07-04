package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.NumberRange.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallNumberManagerTest {

    NumberManager numberManager = new BaseBallNumberManager();

    @Test
    void TestGeneratedNumbersAreDifferent() {
        // given
        int start = START.value();
        int end = END.value();
        int count = COUNT.value();

        // when
        Number number = numberManager.generate(start, end, count);
        List<Integer> numbers = number.getNumbers();
        int length = numbers.size();

        // then
        boolean duplicated = false;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    duplicated = true;
                    break;
                }
            }
        }
        assertThat(duplicated).isFalse();
    }

    @Test
    void TestGeneratedNumbersAreInRange() {
        // given
        int start = START.value();
        int end = END.value();
        int count = COUNT.value();

        // when
        Number number = numberManager.generate(start, end, count);

        // then
        for (int n : number.getNumbers()) {
            assertThat(n)
                    .isGreaterThanOrEqualTo(start)
                    .isLessThanOrEqualTo(end);
        }
    }

    @Test
    void TestInputIsThreeInteger() {
        // given
        String input = "123";
        Number expected = new Number(Arrays.asList(1, 2, 3));

        // when
        Number actual = numberManager.parseInput(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }


    @Test
    void TestInputIsNotThreeInteger() {
        assertThatThrownBy(() -> numberManager.parseInput(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> numberManager.parseInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TestInputIsZero() {
        assertThatThrownBy(() -> numberManager.parseInput("023"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> numberManager.parseInput("103"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> numberManager.parseInput("120"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TestInputIsDuplicated() {
        assertThatThrownBy(() -> numberManager.parseInput("113"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> numberManager.parseInput("122"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> numberManager.parseInput("121"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TestInputIsNotInteger() {
        assertThatThrownBy(() -> numberManager.parseInput("x23"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> numberManager.parseInput("1x3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> numberManager.parseInput("12x"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TestCalculate3Strike() {
        // given
        Score expected = new Score(0, 3);
        Number generatedNumber = new Number(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Number inputNumber = new Number(new ArrayList<>(Arrays.asList(1, 2, 3)));

        // when
        Score actual = numberManager.calculate(inputNumber, generatedNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void TestCalculate1Ball1Strike() {
        // given
        Score expected = new Score(1, 1);
        Number generatedNumber = new Number(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Number inputNumber = new Number(new ArrayList<>(Arrays.asList(1, 3, 4)));

        // when
        Score actual = numberManager.calculate(inputNumber, generatedNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void TestCalculate3Ball() {
        // given
        Score expected = new Score(3, 0);
        Number generatedNumber = new Number(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Number inputNumber = new Number(new ArrayList<>(Arrays.asList(2, 3, 1)));

        // when
        Score actual = numberManager.calculate(inputNumber, generatedNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void TestCalculateNothing() {
        // given
        Score expected = new Score(0, 0);
        Number generatedNumber = new Number(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Number inputNumber = new Number(new ArrayList<>(Arrays.asList(4, 5, 6)));

        // when
        Score actual = numberManager.calculate(inputNumber, generatedNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}