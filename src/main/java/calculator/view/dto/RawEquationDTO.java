package calculator.view.dto;

public class RawEquationDTO {
    public static final String ERROR_MESSAGE_EMPTY_INPUT = "입력값이 비어있습니다.";
    private String rawEquation;

    public RawEquationDTO(String rawEquation) {
        validate(rawEquation);
        this.rawEquation = rawEquation;
    }

    private void validate(String equation) {
        if (equation.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }

    public String getRawEquation() {
        return rawEquation;
    }
}
