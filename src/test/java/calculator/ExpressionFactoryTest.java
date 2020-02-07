package calculator;

import com.woowacourse.calculator.domain.Expression;
import com.woowacourse.calculator.domain.ExpressionFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 클래스 이름 : ExpressionFactoryTest.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/06
 */
public class ExpressionFactoryTest {
    @ParameterizedTest
    @DisplayName("normal test")
    @ValueSource(strings = {"2 + 3 * 4", "2 - 332 / 4", "2112 + 3 - 4"})
    void normalTest(String input) {
        Assertions.assertThat(ExpressionFactory.create(input))
                .isInstanceOf(Expression.class);
    }

    @Test
    @DisplayName("null case test")
    void nullTest() {
        Assertions.assertThatThrownBy(() -> {
            ExpressionFactory.create(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @DisplayName("wrong input test")
    @ValueSource(strings = {"2 & 3 * 4", "12 - - 332 / 4", "2112 323 + 3 - 4"})
    void wrongInputTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            ExpressionFactory.create(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 형식으로 입력하셨습니다.");
    }
}
