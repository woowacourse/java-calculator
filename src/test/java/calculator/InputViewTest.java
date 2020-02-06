package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputViewTest {

    @DisplayName("사용자 입력테스트")
    @Test
    void scanner() {
        String string = "abc def";
        InputStream in = new ByteArrayInputStream(string.getBytes());
        System.setIn(in);

        assertThat(string).isEqualTo(InputView.inputFormula());
    }
}
