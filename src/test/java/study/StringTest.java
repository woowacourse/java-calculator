package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

/**
 * 클래스 이름 : StringTest.java
 *
 * @author S.W.PARK
 * @author K.S.KIM
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/05
 */
public class StringTest {
    @Test
    @DisplayName("split test")
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        Assertions.assertThat(result).contains("1");
        Assertions.assertThat(result).contains("2");
        Assertions.assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring test")
    void substring() {
        String value = "(1, 2)";
        String result = value.substring(1, value.length() - 1);
        Assertions.assertThat(result).contains("1, 2");
    }

    @Test
    @DisplayName("charAt test")
    void charAt() {
        Assertions.assertThatThrownBy(() -> {
            String value = "abc";
            value.charAt(0);
            value.charAt(1);
            value.charAt(2);
            value.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
