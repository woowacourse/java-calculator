package domain;

public enum Operator {
	PLUS("+"),
	MINUS("-"),
	MULTIPLICATION("*"),
	DIVISION("/");

	private String operator;

	Operator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}
}
