package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    void add() {
        assertThat(Calculator.add(3, 4)).isEqualTo(7);
        assertThat(Calculator.add(2, 5)).isEqualTo(7);
        assertThat(Calculator.add(0, 3)).isEqualTo(3);
    }

    @Test
    void subtract() {
        assertThat(Calculator.subtract(3, 4)).isEqualTo(-1);
        assertThat(Calculator.subtract(2, 5)).isEqualTo(-3);
        assertThat(Calculator.subtract(0, 3)).isEqualTo(-3);
        assertThat(Calculator.subtract(7, 3)).isEqualTo(4);
    }

    @Test
    void multiply() {
        assertThat(Calculator.multiply(3, 4)).isEqualTo(12);
        assertThat(Calculator.multiply(2, 5)).isEqualTo(10);
        assertThat(Calculator.multiply(0, 3)).isEqualTo(0);
    }

    @Test
    void divide() {
        assertThat(Calculator.divide(12, 4)).isEqualTo(3);
        assertThat(Calculator.divide(10, 5)).isEqualTo(2);

        assertThatThrownBy(() -> {
            Calculator.divide(12, 0);
        }).isInstanceOf(ArithmeticException.class);
    }


}
