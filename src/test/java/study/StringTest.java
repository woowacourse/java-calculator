package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StringTest {
    @Test
    void firstRequire() {
        String oneAndTwo = "1,2";
        String onlyOne = "1";

        Assertions.assertThat(oneAndTwo.split(",")).contains("1");
        Assertions.assertThat(oneAndTwo.split(",")).contains("2");
        Assertions.assertThat(onlyOne.split(",")).containsExactly("1");
    }

    @Test
    void secondRequire() {
        String oneAndTwoWithBracket = "(1,2)";

        Assertions.assertThat(oneAndTwoWithBracket.substring(1,4)).isEqualTo("1,2");
    }

}
