package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputViewTest {

    @DisplayName("출력테스트")
    @Test
    void print() {
        String value = "123.0\r\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        OutputView.printResult(123);
        Assertions.assertThat(outContent.toString()).isEqualTo(value);
    }
}
