package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StringTest {
    @Test
    void firstRequire() {
        String stringWithOneTwo = "1,2";
        String stringWithOnlyOne = "1";

        Assertions.assertThat(stringWithOneTwo.split(",")).contains("1");
        Assertions.assertThat(stringWithOneTwo.split(",")).contains("2");
        Assertions.assertThat(stringWithOnlyOne.split(",")).containsExactly("1");
    }
}
