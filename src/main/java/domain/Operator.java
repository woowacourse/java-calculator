package domain;

public enum Operator {
    PLUS("+"), Minus("-"), Multiply("*"), Divide("/");

    Operator(String symbol) {
    }

    // TODO: 2020-02-07 연산자에 따라 해당 연산객체를 반환해주는 기능 추가 
}
