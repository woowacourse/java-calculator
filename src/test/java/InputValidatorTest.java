import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {
	private InputValidator inputValidator = new InputValidator();

	@Test
	void returnTrueIfInputIncludesInvalidCharacters() {
		assertThat(inputValidator.validate("1 + 2 + 3 + 4.0 + ^")).isTrue();
	}
}
