package StringCalculatorTest;

import Controller.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



import static org.assertj.core.api.Assertions.assertThat;

public class InputValidationTest {


    @DisplayName("공백만 입력되었는지 검사")
    @ParameterizedTest
    @CsvSource(value = {"3 + 4 - 5:false", " :true", "1:false", "4 / 3:false"}, delimiter = ':')
    void validateSpace(String sourceData, boolean answer) throws Exception {
        boolean result = false;
        String[] inputs = {};
        if (sourceData == null){
            result = true;
        } else {
            inputs = sourceData.split(" ");
        }
        try{
            InputValidation.validateSpace(inputs);
        } catch (Exception e){
            result = true;
        }
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("식의 처음과 끝이 숫자로 되어있는지 검사")
    @ParameterizedTest
    @CsvSource(value = {"3 + 4 - 5:true", "/:false", "1 -:false", "+ 3 / 3:false"}, delimiter = ':')
    void validateFirstAndLast(String sourceData, boolean answer) {
        boolean result = true;
        String[] inputs = {};
        if (sourceData == null){
            result = false;
        } else {
            inputs = sourceData.split(" ");
        }
        try{
            InputValidation.validateFirstAndLast(inputs);
        } catch (Exception e){
            result = false;
        }
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("숫자와 연산자가 번갈아 나오는지 검사")
    @ParameterizedTest
    @CsvSource(value = {"3 + 4 4 - 5:false", "3 + + 4:false", "1 -:true", "+ 3 - / 3:false"}, delimiter = ':')
    void validateRepeat(String sourceData, boolean answer) {
        boolean result = true;
        String[] inputs = {};
        if (sourceData == null){
            result = false;
        } else {
            inputs = sourceData.split(" ");
        }
        try{
            InputValidation.validateRepeat(inputs);
        } catch (Exception e){
            result = false;
        }
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("사칙연산자 이외의 문자가 입력될경우")
    @ParameterizedTest
    @CsvSource(value = {"3 + 4 % - 5:false", "3 + 4 -:true", "1 / 3 @:false", "1 + 3 / 3:true"}, delimiter = ':')
    void validateOperators(String sourceData, boolean answer) {
        boolean result = true;
        String[] inputs = {};
        if (sourceData == null){
            result = false;
        } else {
            inputs = sourceData.split(" ");
        }
        try{
            InputValidation.validateOperators(inputs);
        } catch (Exception e){
            result = false;
        }
        assertThat(result).isEqualTo(answer);
    }

}
