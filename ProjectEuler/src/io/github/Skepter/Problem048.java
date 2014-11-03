package io.github.Skepter;

import java.math.BigInteger;

public class Problem048 {

	/*
	 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

	Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
	 */
	public static void main(final String[] args) {
		BigInteger integer = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++) {
			integer = integer.add(new BigInteger(String.valueOf(i)).pow(i));
		}
		System.out.println(integer.toString().substring(integer.toString().length() - 10));
	}
}
