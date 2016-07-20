package net.projecteuler;

import static net.projecteuler.util.Primes.gcd;

public class ProjectEuler073 {

	private static final double UPPER = 1d / 2d;
	private static final double LOWER = 1d / 3d;

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_073());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_073() {
		int count = 0;
		for (int d = 2; d <= 12_000; d++) {
			int n_min = d / 3;
			int n_max = d / 2;
			for (int n = n_min; n <= n_max; n++) {
				if (gcd(n, d) == 1) {
					double fraction = (double) n / (double) d;
					if (fraction > LOWER && fraction < UPPER) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
}
