package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("요구사항1: split을 통한 String 분리 테스트")
    @Test
    void split() {
        String commaValues = "1,2";
        String[] result = commaValues.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }


    @DisplayName("요구사항2: substring을 통한 String 분리 테스트")
    @Test
    void substring() {
        String subValues = "(1,2)";
        String resultValue = subValues.substring(1, 4);
        assertThat(resultValue).doesNotContain("(", ")");
    }

    @DisplayName("요구사항3: isInstanceOf를 통한 예외사항 검사")
    @Test
    void charAt() {
        String value = "abc";

        assertThatThrownBy(() -> {
            value.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(4);
                }).withMessageContaining("String index out of range:");
    }
}

