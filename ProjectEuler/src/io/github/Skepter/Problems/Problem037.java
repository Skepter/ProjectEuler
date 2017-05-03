package io.github.Skepter.Problems;

import java.util.ArrayList;
import java.util.List;

import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem037 extends RT {

	/*
	 * https://projecteuler.net/problem=37 The number 3797 has an interesting
	 * property. Being prime itself, it is possible to continuously remove
	 * digits from left to right, and remain prime at each stage: 3797, 797, 97,
	 * and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
	 * 
	 * Find the sum of the only eleven primes that are both truncatable from
	 * left to right and right to left.
	 * 
	 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
	 * 
	 * 4.39 minutes !!!!
	 */
	public static void main(final String[] args) {
		List<Integer> primes = new ArrayList<Integer>();
		for(int i = 10; i <= 1000000; i++) {
			if(String.valueOf(i).startsWith("2") || String.valueOf(i).startsWith("3") || String.valueOf(i).startsWith("5") || String.valueOf(i).startsWith("7")) {
				if(String.valueOf(i).endsWith("3") || String.valueOf(i).endsWith("7")) {
					if(Utils.isPrime(i)) {
						primes.add(i);
					}
				}
			}
			
		}
		
		//Utils.printListSingleLine(primes);
		
		List<Integer> primes2 = new ArrayList<Integer>();
		for(int i : primes) {
			boolean isPrime = true;
			for(String prime : Utils.getTruncatedArray(String.valueOf(i), false)) {
				if(!Utils.isPrime(Integer.parseInt(prime))) {
					isPrime = false;
				}
			}
			for(String prime : Utils.getTruncatedArray(String.valueOf(i), true)) {
				if(!Utils.isPrime(Integer.parseInt(prime))) {
					isPrime = false;
				}
			}
			if(isPrime) {
				primes2.add(i);
			}
		}
		
		int count = 0;
		for(int i : primes2) {
			count += i;
		}
		System.out.println(count);
		
		Utils.printList(primes2);
		uptime();
	}
	
	
}
