package unit.domain;

import java.util.Objects;

public class Token {
	private final String token;

	public Token(final String token) {
		this.token = token;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Token token1 = (Token)o;
		return Objects.equals(token, token1.token);
	}

	@Override
	public int hashCode() {
		return Objects.hash(token);
	}
}
