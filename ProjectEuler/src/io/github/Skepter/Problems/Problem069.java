package io.github.Skepter.Problems;

import io.github.Skepter.Utils.LoadingBar;
import io.github.Skepter.Utils.RT;
import io.github.Skepter.Utils.Utils;

public class Problem069 extends RT {

	/* https://projecteuler.net/problem=69 */
	public static void main(final String[] args) {
		double max = 0.0D;
		int m = 1000000;
		LoadingBar bar = new LoadingBar("Problem 69",m);
		for(int i = 1; i <= m; i++) {
			if(i/Utils.phi(i) > max) {
				max = i/Utils.phi(i);
			}
			bar.updateBar(i);
		}
		System.out.println(max);
		uptime();
	}
}