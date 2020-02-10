package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator = new Calculator();
    private int first = 1;
    private int second = 2;

    @Test
    @DisplayName("calculate() : return result of addition")
    void calculateAdd() {
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(new Number(first), new Number(second)), new LinkedList<>(Collections.singletonList(Operator.PLUS)));

        assertThat(calculator.calculateNumberSentence(numberSentence)).isEqualTo(new Number(first + second));
    }

    @Test
    @DisplayName("calculate() : return result of Substraction")
    void calculateSubstract() {
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(new Number(first), new Number(second)), new LinkedList<>(Collections.singletonList(Operator.MINUS)));

        assertThat(calculator.calculateNumberSentence(numberSentence)).isEqualTo(new Number(first - second));
    }

    @Test
    @DisplayName("calculate() : return result of multiplification")
    void calculateMultiple() {
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(new Number(first), new Number(second)), new LinkedList<>(Collections.singletonList(Operator.MULTIPLIFICATION)));

        assertThat(calculator.calculateNumberSentence(numberSentence)).isEqualTo(new Number(first * second));
    }

    @Test
    @DisplayName("calculate() : return result of division")
    void calculateDivide() {
        NumberSentence numberSentence = new NumberSentence(Arrays.asList(new Number(first), new Number(second)), new LinkedList<>(Collections.singletonList(Operator.DIVISION)));

        assertThat(calculator.calculateNumberSentence(numberSentence)).isEqualTo(new Number(first / second));
    }
}