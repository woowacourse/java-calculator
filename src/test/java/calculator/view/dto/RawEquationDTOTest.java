package calculator.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RawEquationDTOTest {

    @DisplayName("빈칸을 입력받은 경우 IllegalException 발생")
    @Test
    void getRawEquation() {
        String wrongInput = "       ";
        assertThatThrownBy(() -> new RawEquationDTO(wrongInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}