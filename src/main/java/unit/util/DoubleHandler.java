package unit.util;

import java.text.DecimalFormat;

public class DoubleHandler {
	public static String round(double number) {
		final DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return decimalFormat.format(number);
	}
}
