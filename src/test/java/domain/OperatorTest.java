package domain;

import domain.operator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    private Operator plusOperator;
    private Operator minusOperator;
    private Operator multiplyOperator;
    private Operator divideOperator;

    private double prev = 5;
    private double next = 3;

    @BeforeEach
    void setUp() {
        plusOperator = new Plus();
        minusOperator = new Minus();
        multiplyOperator = new Multiply();
        divideOperator = new Divide();
    }

    @Test
    void testPlusOperator() {
        assertThat(plusOperator.calculate(prev, next)).isEqualTo(prev + next);
    }

    @Test
    void testMinusOperator() {
        assertThat(minusOperator.calculate(prev, next)).isEqualTo(prev - next);
    }

    @Test
    void testMultiplyOperator() {
        assertThat(multiplyOperator.calculate(prev, next)).isEqualTo(prev * next);
    }

    @Test
    void testDivideOperator() {
        assertThat(divideOperator.calculate(prev, next)).isEqualTo(prev / next);
    }
}