package study;

import exception.ValidationCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationCheckTest {
    private List<String> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();
    private ValidationCheck validationCheck = new ValidationCheck();

    @BeforeEach
    void setUp() {  //테스트 전 변수 초기화
        List<String> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        numbers.add("1");
        numbers.add("3");
        numbers.add("4");
        numbers.add("2");

        operators.add("+");
        operators.add("*");
        operators.add("/");
    }

    @Test
    @DisplayName("Exception isNumber Test")
    void isNumberCorrect(){ //numbers에 담긴 숫자가 숫자인지 테스트
        assertThat(validationCheck.isNumber(numbers)).isTrue();
    }

    @Test
    @DisplayName("Exception isValidOperator Test")
    void ValidOperaterTest(){   //opers에 담긴 문자가 사칙연산인지 테스트
        assertThat(validationCheck.isValidOperator(operators)).isTrue();
    }

}
