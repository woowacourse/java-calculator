package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class OperatorGroupTest {

    @DisplayName("OperatorGroup Plus 변환 테스트")
    @Test
    void plusStringToOperator() {
        String plus = "+";
        OperatorGroup result = OperatorGroup.stringToOperator(plus);
        assertThat(result).isEqualTo(OperatorGroup.PLUS);
    }

    @DisplayName("OperatorGroup Minus 변환 테스트")
    @Test
    void minusStringToOperator() {
        String minus = "-";
        OperatorGroup result = OperatorGroup.stringToOperator(minus);
        assertThat(result).isEqualTo(OperatorGroup.MINUS);
    }

    @DisplayName("OperatorGroup Multiple 변환 테스트")
    @Test
    void multipleStringToOperator() {
        String multiple = "*";
        OperatorGroup result = OperatorGroup.stringToOperator(multiple);
        assertThat(result).isEqualTo(OperatorGroup.MULTIPLY);
    }

    @DisplayName("OperatorGroup DIVIDE 변환 테스트")
    @Test
    void stringToOperator() {
        String divide = "/";
        OperatorGroup result = OperatorGroup.stringToOperator(divide);
        assertThat(result).isEqualTo(OperatorGroup.DIVIDE);
    }
}