package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split메서드를 사용하면 delimiter를 기준으로 분리된 배열 반환 ")
    void splitWithDelimiter() {
        String value = "1,2";
        String[] result = value.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("delimiter를 포함하지 않는 문자열을 split하면 문자열 전체를 포함하는 배열 반환")
    void splitWithoutDelimiter() {
        String value = "1";
        String[] result = value.split(",");

        assertThat(result).containsExactly(value);
    }

    @Test
    @DisplayName("substring을 사용하면 지정한 범위의 String을 반환")
    void substring() {
        String expectedValue = "1,2";
        String prefix = "(";
        String suffix = ")";
        String combinedValue = prefix + expectedValue + suffix;
        String result = combinedValue.substring(prefix.length(), combinedValue.length() - suffix.length());

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("charAt 메서드를 사용하면 해당 index의 char 값을 반환")
    void charAt() {
        String value = "abc";

        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메서드에 범위 밖 인덱스를 넣으면 IndexOutOfBoundsException 발생")
    void charAtUsingIndexOutOfBounds() {
        String value = "abc";

        assertThatThrownBy(() -> value.charAt(value.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: " + value.length());

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> value.charAt(value.length()))
                .withMessageContaining("range: " + value.length());
    }

}
