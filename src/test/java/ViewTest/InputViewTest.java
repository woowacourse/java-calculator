package ViewTest;

import View.InputView;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    void InputViewTest() {
        String Test1 = "3 + 4 / 10 / 10";
        String[] result = {"3", "+", "4","/","10","/","10"};
        assertThat(Test1.trim().split(" ")).isEqualTo(result);
    }
}
