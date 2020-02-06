package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static String inputMathematicalExpression() throws IOException {
		return bufferedReader.readLine();
	}
}
