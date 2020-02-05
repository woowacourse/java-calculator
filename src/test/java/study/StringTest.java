package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class StringTest {
    @Test
    @DisplayName("String Test")
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        Assertions.assertThat(result).contains("1");
        Assertions.assertThat(result).contains("2");
        Assertions.assertThat(result).containsExactly("1", "2");
    }
}
