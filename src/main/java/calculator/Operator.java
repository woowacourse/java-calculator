package calculator;

public enum Operator {

    PLUS("+") {
        @Override
        public double calculate(double prev, double next) {
            return prev + next;
        }
    },
    MULTIPLY("*") {
        @Override
        public double calculate(double prev, double next) {
            return prev * next;
        }
    },
    MINUS("-") {
        @Override
        public double calculate(double prev, double next) {
            return prev - next;
        }
    },
    DIVIDE("/") {
        @Override
        public double calculate(double prev, double next) {
            return prev / next;
        }
    };

    private String name;

    Operator(String name) {
        this.name = name;
    }

    public static Operator from(String name) {
        if (PLUS.name.equals(name)) {
            return PLUS;
        }
        if (MULTIPLY.name.equals(name)) {
            return MULTIPLY;
        }
        if (MINUS.name.equals(name)) {
            return MINUS;
        }
        if (DIVIDE.name.equals(name)) {
            return DIVIDE;
        }
        throw new IllegalArgumentException();
    }

    public abstract double calculate(double prev, double next);
}
