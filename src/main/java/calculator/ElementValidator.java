package calculator;

public class ElementValidator {
    public void checkEquationElementValue(String[] equations) {
        checkOperatorValue(equations);
        checkNumberValue(equations);
    }

    private void checkOperatorValue(String[] equations) {
        for (int i = 1; i < equations.length; i += 2) {
            if (isInvalidEquation(equations)) {
                throw new NumberFormatException();
            }
        }
    }

    public void checkNumberValue(String[] equations) {
        for (int i = 0; i < equations.length; i += 2) {
            if (Double.parseDouble(equations[i]) > (double) Integer.MAX_VALUE
                    || Double.parseDouble(equations[i]) < -(double) Integer.MAX_VALUE) {
                throw new NumberFormatException();
            }
        }
    }

    public boolean isInvalidEquation(String[] equations) {
        return equations.length % 2 == 0;
    }

}
