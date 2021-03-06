package io.github.jorelali.problems;

import io.github.jorelali.utils.RT;
import io.github.jorelali.utils.Utils;

public class Problem034 extends RT {

	/*
	 * https://projecteuler.net/problem=34
	 * 214ms
	 */
    public static void main(String[] args) {
    	int count = -3; //Accounts for numbers 1 and 2
        for(int i = 1; i <= 1000000; i++) {
            if(sumOfDigitsFactorialisedness(i) == i) {
                count += i;
            }
        }
        System.out.println(count);
        uptime();
       
    }
    
    public static long sumOfDigitsFactorialisedness(long input) {
        long count = 0L;
        for(long digit : splitDigits(input)) {
            count += Utils.factorial(digit);
        }
        return count;
    }
    
    public static long[] splitDigits(long input) {
        String word = String.valueOf(input);
        long[] array = new long[word.length()];
        
        int count = 0;
        for(char c : word.toCharArray()) {
            array[count] = Long.parseLong(String.valueOf(c));
            count++;
        }
        return array;
    }
    
}
