package domain;

import calculator.calculate.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    private Calculatable plus;
    private Calculatable minus;
    private Calculatable multiply;
    private Calculatable divide;

    private double prev = 5;
    private double next = 3;

    @BeforeEach
    void setUp() {
        plus = new Plus();
        minus = new Minus();
        multiply = new Multiply();
        divide = new Divide();
    }

    @Test
    void testPlusOperator() {
        assertThat(plus.calculate(prev, next)).isEqualTo(prev + next);
    }

    @Test
    void testMinusOperator() {
        assertThat(minus.calculate(prev, next)).isEqualTo(prev - next);
    }

    @Test
    void testMultiplyOperator() {
        assertThat(multiply.calculate(prev, next)).isEqualTo(prev * next);
    }

    @Test
    void testDivideOperator() {
        assertThat(divide.calculate(prev, next)).isEqualTo(prev / next);
    }
}