package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class OperatorTest {
    private Operator plusOperator;
    private Operator minusOperator;
    private Operator multiplyOperator;
    private Operator divideOperator;

    private double prev = 5;
    private double next = 3;

    @BeforeEach
    void setUp() {
        plusOperator = Operator.from("+");
        minusOperator = Operator.from("-");
        multiplyOperator = Operator.from("*");
        divideOperator = Operator.from("/");
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

    @Test
    void testOperatorException() {
        assertThatThrownBy(() -> Operator.from("j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}