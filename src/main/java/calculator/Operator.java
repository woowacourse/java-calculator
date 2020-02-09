package calculator;

public enum Operator {
    PLUS {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    MINUS {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
    };

    public abstract int calculate(int a, int b);
}
