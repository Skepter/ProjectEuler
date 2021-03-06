package io.github.jorelali.foreignutils;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Uses a BitSet to calculate the SieveOfEratosthenes.
 * This is used to generate a list of prime numbers up to a maximum value
 * 
 * https://gist.github.com/rmfbarker/6314416
 * http://stackoverflow.com/a/32417991
 */
public class SieveWithBitset {
	private final BitSet sieve;

	public SieveWithBitset(final int size) {
		sieve = new BitSet((size + 1) / 2);
	}

	public boolean isComposite(final int k) {
		if (((k >= 3) && ((k % 2) == 1)) == false) {
			throw new AssertionError();
		}
		return sieve.get((k - 3) / 2);
	}

	public void setComposite(final int k) {
		if((k >= 3) && ((k % 2) == 1) == false) {
			throw new AssertionError();
		}
		sieve.set((k - 3) / 2);
	}

	/**
	 * @return A set of integers of the prime numbers <= max
	 */
	public static Set<Integer> getPrimesAsSet(final int max) {
		final SieveWithBitset sieve = new SieveWithBitset(max + 1); // +1 to include max itself
		for (int i = 3; (i * i) <= max; i += 2) {
			if (sieve.isComposite(i))
				continue;

			// We increment by 2*i to skip even multiples of i
			for (int multiple_i = i * i; multiple_i <= max; multiple_i += 2 * i)
				sieve.setComposite(multiple_i);
		}

		final Set<Integer> primes = new HashSet<Integer>();
		primes.add(2);
		for (int i = 3; i <= max; i += 2)
			if (!sieve.isComposite(i))
				primes.add(i);
		return primes;
	}
	
	/**
	 * @return A list of integers of the prime numbers <= max
	 */
	public static List<Integer> getPrimes(final int max) {
		final SieveWithBitset sieve = new SieveWithBitset(max + 1); // +1 to include max itself
		for (int i = 3; (i * i) <= max; i += 2) {
			if (sieve.isComposite(i))
				continue;

			// We increment by 2*i to skip even multiples of i
			for (int multiple_i = i * i; multiple_i <= max; multiple_i += 2 * i)
				sieve.setComposite(multiple_i);
		}

		final List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for (int i = 3; i <= max; i += 2)
			if (!sieve.isComposite(i))
				primes.add(i);
		return primes;
	}
}