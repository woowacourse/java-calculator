package domain;

import domain.errors.UnAcceptableOperatorException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {
    private Calculator calculator = new Calculator();
    private int first = 1;
    private int second = 2;

    @Test
    void calculateAdd() {
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(first, second), new LinkedList<>(Collections.singletonList("+")));

        assertThat(calculator.calculate(numberSentence)).isEqualTo(first + second);
    }

    @Test
    void calculateSubstract() {
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(first, second), new LinkedList<>(Collections.singletonList("-")));

        assertThat(calculator.calculate(numberSentence)).isEqualTo(first - second);
    }

    @Test
    void calculateMultiple() {
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(first, second), new LinkedList<>(Collections.singletonList("*")));

        assertThat(calculator.calculate(numberSentence)).isEqualTo(first * second);
    }

    @Test
    void calculateDivide() {
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(first, second), new LinkedList<>(Collections.singletonList("/")));

        assertThat(calculator.calculate(numberSentence)).isEqualTo(first / second);
    }

    @Test
    void calculateUnacceptableOperator() {
        String unAcceptableOperator = "{";
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(first, second), new LinkedList<>(Collections.singletonList(unAcceptableOperator)));

        assertThatExceptionOfType(UnAcceptableOperatorException.class)
                .isThrownBy(() -> {
                    calculator.calculate(numberSentence);
                });
    }
}