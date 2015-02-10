package io.github.Skepter.Problems;
import io.github.Skepter.Utils.Utils;

import java.math.BigInteger;

public class Problem020 {

	//Find the sum of the digits in the number 100!
	public static void main(final String[] args) {
		BigInteger value = new BigInteger("1");
		for(int i = 1; i <=100; i++)
			value = value.multiply(new BigInteger(String.valueOf(i)));
		System.out.println(Utils.sumOfDigits(value.toString()));
	}
}
