package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testPlus() {
        assertThat(calculator.plus(3, 5)).isEqualTo(8);
    }

    @Test
    void testMultiply() {
        assertThat(calculator.multiply(3, 5)).isEqualTo(15);
    }

    @Test
    void testMinus() {
        assertThat(calculator.minus(3, 5)).isEqualTo(-2);
    }

    @Test
    void testDivide() {
        assertThat(calculator.divide(3, 5)).isEqualTo(0.6);
    }
}