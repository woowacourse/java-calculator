package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SourceTest {
    private Source source = new Source();

    @BeforeEach
    void setUp() {
        String input = "1 + 2 +";
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 +", "1 / 3 + 4 *", "4 4"})
    void sizeOfInputs_ShouldBeOdds(String input) {
        System.out.println(input);
        String[] inputs = input.split(" ");
        assertThatThrownBy(() -> {
            source.validateSizeOfInputsIsOdds(inputs);
        }).isInstanceOf(Exception.class)
                .hasMessageMatching("inputs의 사이즈가 홀수가 아님");
    }
}
