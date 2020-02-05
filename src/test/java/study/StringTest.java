package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split1() {
        String value = "1,2";
        String[] result = value.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    void split2() {
        String value = "1";
        String[] result = value.split(",");
        assertThat(result).containsExactly("1");
    }
}
