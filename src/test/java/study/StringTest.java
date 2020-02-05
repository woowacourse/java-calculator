/*
 * Copyright (c) 2019 by tiger, DDoring
 * All rights reserved.
 *
 * StringTest.java
 * String 클래스에 대한 학습 테스트
 *
 * @author      tiger, DDoring
 * @version     1.0
 * @date        05 Feb 2020
 *
 */

package study;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String value = "1,2";
        String[] result = value.split(",");
        Assertions.assertThat(result).contains("1");
        Assertions.assertThat(result).contains("2");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        String result = value.substring(1,4);
        Assertions.assertThat(result).contains("1,2");
    }

    @DisplayName("지정 위치의 문자를 가져온다.")
    @Test
    void charAt() {
        String value = "abc";
        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");

    }

}
