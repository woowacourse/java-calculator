package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringTest {

    @Test
    @DisplayName("String 분할")
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result[0]).isEqualTo("1");   //actual 값과 expected 값이 같은지 확인
        assertThat(result[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("String 추출")
    void subString() {
        String value = "(1,2)";
        String letter = value.substring(1, 4);
        assertThat(letter).isEqualTo("1,2");
    }

    @Test
    @DisplayName("인덱스를 벗어나는 경우")
    void charAt() {
        assertThatThrownBy(() -> {
            String value = "abc";
            char letter = value.charAt(13);
        }).hasMessageContaining("13");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    String value = "abc";
                    char letter = value.charAt(13);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
