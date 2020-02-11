package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionTest {
    @Test
    @DisplayName("비정상적인 입력을 비정상으로 인식하는지")
    public void abnormalInputTest() {
        String[] abnormalCases = {"2 + 3 *2", "", "히히", "5 3"};

        for (String testcase : abnormalCases) {
            Assertions.assertThatThrownBy(()->new Expression(testcase))
                .isInstanceOf(IllegalArgumentException.class);
        }

    }
}
