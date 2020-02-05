package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        String value = "1,2";
        String[] split = value.split(",");

        assertThat(split.length).isEqualTo(2);
        assertThat(split).contains("2", "1");
        assertThat(split).doesNotContain(",");
        assertThat(value.split(",")).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1,4);
        assertThat(result).isEqualTo("1,2");
        assertThat(result).doesNotContain("(",")");
    }
}
