package domain;

public enum Operator {
	PLUS("+"),
	MINUS("-"),
	MULTIPLICATION("*"),
	DIVISION("/");

	private String symbol;

	Operator(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
}
