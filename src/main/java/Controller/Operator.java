package Controller;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String sign;

    Operator(String sign){
        this.sign = sign;
    }

    public boolean isOperator(String sign){
        return (sign.equals(Operator.PLUS.sign)
                || sign.equals(Operator.MINUS.sign)
                || sign.equals(Operator.MULTIPLY.sign)
                || sign.equals(Operator.DIVIDE.sign));
    }

    public double compute(double result, int number){
        if (this == PLUS){
            result += number;
            return result;
        }

        if (this == MINUS){
            result -= number;
            return result;
        }

        if (this == MULTIPLY){
            result *= number;
            return result;
        }

        if (this == DIVIDE){
            result /= number;
            return result;
        }
        return result;
    }

}
