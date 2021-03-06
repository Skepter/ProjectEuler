package io.github.jorelali.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

public class Problem022 {

	/*
	 Begin by sorting it into alphabetical order. 
	 Then working out the alphabetical value for each name, 
	 multiply this value by its alphabetical position in the 
	 list to obtain a name score.

	 For example, when the list is sorted into alphabetical order, 
	 COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th 
	 name in the list. So, COLIN would obtain a score of 938 × 53 = 
	 49714.

	 What is the total of all the name scores in the file?
	 */
	public static void main(final String[] args) throws IOException {

		final URL url = Problem022.class.getResource("/ResourceFiles/names.txt");
		final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine = in.readLine();
		in.close();

		inputLine = inputLine.replace("\"", "");
		final String[] arr = inputLine.split(",");
		Arrays.sort(arr);

		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			final String string = arr[i];
			Long count = 0L;
			for (int j = 0; j < string.length(); j++)
				count += string.charAt(j) - 64;
			//int started at 0, +1 to sort out the positioning
			answer += count * (i + 1);
		}
		System.out.println(answer);
	}
}
