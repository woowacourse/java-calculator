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
    @CsvSource(value = {"6,PLUS,3,9", "6,MINUS,3,3", "6,MULTIPLE,3,18", "6,DIVIDE,3,2"})
    void operate(double a, OperatorGroup operatorGroup, double b, double result) {
        assertThat(operatorGroup.operate(a, b)).isEqualTo(result);
    }

    @DisplayName("등록되지 않은 연산자로 연산을 시도할 경우 Exception 발생")
    @Test
    void name() {
        String notOperator = "~";

        assertThatThrownBy(() -> OperatorGroup.findByDelimiter(notOperator))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage(notOperator + "는 등록되지 않은 연산자 입니다.");
    }

    @DisplayName("구분자를 입력받아 연산자 Enum 을 찾아내기")
    @ParameterizedTest
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLE", "/,DIVIDE"})
    void findByDelimiter(String delimiter, OperatorGroup operatorGroup) {
        assertThat(OperatorGroup.findByDelimiter(delimiter)).isEqualTo(operatorGroup);
    }
}