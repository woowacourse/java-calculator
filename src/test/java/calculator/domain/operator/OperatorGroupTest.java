package calculator.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorGroupTest {

    @DisplayName("연산자에 따른 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"6,+,3,9", "6,-,3,3", "6,*,3,18", "6,/,3,2"})
    void operate(double a, String op, double b, double result) {
        assertThat(OperatorGroup.operate(a, op, b)).isEqualTo(result);
    }

    @DisplayName("등록되지 않은 연산자로 연산을 시도할 경우 Exception 발생")
    @Test
    void name() {
        String notOperator = "~";

        assertThatThrownBy(() -> OperatorGroup.operate(1, notOperator, 2))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage(notOperator + "는 등록되지 않은 연산자 입니다.");
    }
}