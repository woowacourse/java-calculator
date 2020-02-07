package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorGroupTest {

    @DisplayName("플러스 연산자 확인 테스트")
    @Test
    void isPlus() {
        OperatorGroup plus = OperatorGroup.PLUS;
        assertThat(plus.isPlus()).isEqualTo(true);
    }
}