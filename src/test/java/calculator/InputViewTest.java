package calculator;

import calculator.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("비어있는 입력값 받는 경우")
    @Test
    void inputEquation() {
        InputStream input = new ByteArrayInputStream("  ".getBytes());
        Scanner scanner = new Scanner(input);
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::inputEquation)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 비어있습니다.");
    }
}