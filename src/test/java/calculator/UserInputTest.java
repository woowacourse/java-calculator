package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserInputTest {
    UserInput userInput = new UserInput();
    @Test
    void isNumberAtEvenIndex() {
        String[] testString = {"1", "asdf", "2", "asdfwerwer"};
        Assertions.assertThat(userInput.isNumberAtEvenIndex(testString)).isTrue();
    }
}
