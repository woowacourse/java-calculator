package calculator;

public class ElementValidator {
    public void checkEquationElementValue(String[] equations) {
        checkOperatorValue(equations);
        checkNumberValue(equations);
    }

    private void checkOperatorValue(String[] equations) {
        for(int i=1; i<equations.length; i += 2) {
            if(isWrongOperator(equations, i)) { throw new NumberFormatException(); }
            if(isInvalidEquation(equations)) { throw new NumberFormatException(); }
            if(isDividedByZero(equations, i)) { throw new NumberFormatException(); }
        }
    }

    public boolean isWrongOperator(String[] equations, int index) {
        return !equations[index].equals("+") && !equations[index].equals("-") && !equations[index].equals("*") && !equations[index].equals("/");
    }

    public boolean isInvalidEquation(String[] equations) {
        return equations.length % 2 == 0;
    }

    public boolean isDividedByZero(String[] equations, int index) {
        return equations[index].equals("/") && Double.parseDouble(equations[index+1]) == 0.0;
    }

    public void checkNumberValue(String[] equations) {
        for(int i=0; i<equations.length; i += 2) {
            if(Double.parseDouble(equations[i]) > (double) Integer.MAX_VALUE
                    || Double.parseDouble(equations[i]) < -(double) Integer.MAX_VALUE) {
                throw new NumberFormatException();
            }
        }
    }
}
