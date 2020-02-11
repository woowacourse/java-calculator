package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OperatorTest {
    @Test
    @DisplayName("getOperatorByString 메서드에 정상적인 input을 넣는 경우")
    public void getOperatorByStringAtCorrectUse() {
        Assertions.assertThat(Operator.getOperatorByString("+")).isEqualTo(Operator.ADD);
        Assertions.assertThat(Operator.getOperatorByString("-")).isEqualTo(Operator.SUBTRACT);
        Assertions.assertThat(Operator.getOperatorByString("*")).isEqualTo(Operator.MULTIPLY);
        Assertions.assertThat(Operator.getOperatorByString("/")).isEqualTo(Operator.DIVIDE);
    }

    @ParameterizedTest
    @CsvSource({"aa", "+-", "0", "%"})
    @DisplayName("getOperatorByString 메서드에 비정상적인 input을 넣는 경우")
    public void getOperatorByStringAtAbnormalUse(String input) {
        Assertions.assertThatThrownBy(
            () -> System.out.println(input + ":" + Operator.getOperatorByString(input))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
