package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String commaValues = "1,2";
        String[] result = commaValues.split(",");
        assertThat(result);
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }


}
