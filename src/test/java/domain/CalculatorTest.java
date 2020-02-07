package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    void calculateAdd() {
        int first = 1;
        int second = 2;
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(first, second), new LinkedList<>(Collections.singletonList("+")));

        assertThat(calculator.calculate(numberSentence)).isEqualTo(first + second);
    }

    @Test
    void calculateSubstract() {
        int first = 1;
        int second = 2;
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(first, second), new LinkedList<>(Collections.singletonList("-")));

        assertThat(calculator.calculate(numberSentence)).isEqualTo(first - second);
    }

    @Test
    void calculateMultiple() {
        int first = 1;
        int second = 2;
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(first, second), new LinkedList<>(Collections.singletonList("*")));

        assertThat(calculator.calculate(numberSentence)).isEqualTo(first * second);
    }

    @Test
    void calculateDivide() {
        int first = 1;
        int second = 2;
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(first, second), new LinkedList<>(Collections.singletonList("/")));

        assertThat(calculator.calculate(numberSentence)).isEqualTo(first / second);
    }
}