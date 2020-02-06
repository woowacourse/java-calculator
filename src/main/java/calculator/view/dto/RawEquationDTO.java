package calculator.view.dto;

public class RawEquationDTO {
    private final String rawEquation;

    public RawEquationDTO(String rawEquation) {
        validate(rawEquation);
        this.rawEquation = rawEquation;
    }

    private void validate(String equation) {
        if (equation.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public String getRawEquation() {
        return rawEquation;
    }
}
