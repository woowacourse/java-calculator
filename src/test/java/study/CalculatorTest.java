package study;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;  //ParameterizedTest를 활용하면 더 많은 테스트 가능.
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import calculator.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator cal = new Calculator();
    List<Integer> nums = new ArrayList<>();
    List<String> opers = new ArrayList<>();

    @Test
    @DisplayName("Test calculate method")
    public void 계산결과가_잘_나오는지_테스트() {
        List<Integer> nums = Arrays.asList(1, 5, 4, 2);
        List<String> opers = Arrays.asList("+", "*", "/");
        assertThat(cal.runCalculator(nums, opers)).isEqualTo(12);
        nums = Arrays.asList(5, 2, 7, 10, 10, 2);
        opers = Arrays.asList("*", "-", "*", "+", "/");
        assertThat(cal.runCalculator(nums, opers)).isEqualTo(20);
        nums = Arrays.asList(100, 20, 30, 2);
        opers = Arrays.asList("-", "-", "*");
        assertThat(cal.runCalculator(nums, opers)).isEqualTo(100);
    }

    @Test
    @DisplayName("Test Divide By Zero")
    void 어떤수를_0으로_나누었을때_발생하는_예외_확인() {
        List<Integer> nums = Arrays.asList(1, 0);
        List<String> opers = Arrays.asList("/");

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    cal.runCalculator(nums, opers);
                }).withMessage("/ by zero");
    }
}
