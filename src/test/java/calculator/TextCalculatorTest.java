package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TextCalculatorTest {
    TextCalculator calculator = new TextCalculator();

    @Test
    @DisplayName("올바른 입력값에서 올바른 결과를 출력하는지 테스트")
    public void testCalculator1() {
        String example = "2 + 3 * 4 / 2";
        assertThat(calculator.run(example)).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3332", "123123", "2", "32", "4235"})
    @DisplayName("숫자만 입력되는 경우 그 수를 리턴하는지")
    public void testCalculator5(String input) {
        assertThat(calculator.run(input)).isEqualTo(Double.parseDouble(input));
    }

    @Test
    @DisplayName("공백이 들어왔을 때 예외를 발생시키는 지 테스트")
    public void testCalculator2() {
        String input = "";
        assertThatThrownBy(() -> {
            calculator.run(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Null 값이 들어왔을 때 예외를 발생시키는 지 테스트")
    public void testCalculator3() {
        String input = null;
        assertThatThrownBy(() -> {
            calculator.run(input);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("0으로 나누는 경우 예외가 발생하는지")
    public void testCalculator4() {
        String input = "3 + 4 + 2 / 0";
        assertThatThrownBy(() -> {
            calculator.run(input);
        }).isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"하세요", "안녕", "ㅂㅈㄷ", "+++", "ㅁㄴㅇㄴㅁ"})
    @DisplayName("문자만 입력되는 경우 예외가 발생하는지")
    public void testCalculator6(String input) {
        assertThatThrownBy(() -> {
            calculator.run(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 + 2 +", "1 + ", "1 + 3 / 4 +", "1 + 4 + 3 / "})
    @DisplayName("길이가 적절하지 않은 경우 예외가 발생하는지")
    public void testCalculator7(String input) {
        assertThatThrownBy(() -> {
            calculator.run(input);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}