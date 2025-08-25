package java8;

import java.util.Optional;

public class SafeDivider {
	public static void main(String[] args) {
		System.out.println(divide(10, 2)); // Output: 5.0
		System.out.println(divide(10, 0)); // Output: Not Allowed
	}

	public static String divide(double dividend, double divisor) {
		return Optional.ofNullable(divisor).filter(d -> d != 0).map(d -> String.valueOf(dividend / d))
				.orElse("Not Allowed");
	}
}