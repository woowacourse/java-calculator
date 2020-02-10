package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() { calculator = new Calculator(); }

    @Test
    @DisplayName("더하기 연산 성공")
    void plus() {
        Assertions.assertThat(calculator.run("1 + 2".split(" "))).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기 연산 성공")
    void minus() {
        Assertions.assertThat(calculator.run("1 - 2".split(" "))).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱하기 연산 성공")
    void multiply() {
        Assertions.assertThat(calculator.run("2 * 3".split(" "))).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기 연산 성공")
    void divide() {
        Assertions.assertThat(calculator.run("4 / 2".split(" "))).isEqualTo(2);
    }

    @Test
    @DisplayName("많은 연산이 존재할 때 연산 성공")
    void manyOperatorsWorksProperly() {
        Assertions.assertThat(calculator.run("1 + 3 * 4 / 2 - 7 - 3".split(" "))).isEqualTo(-2);
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }
}
