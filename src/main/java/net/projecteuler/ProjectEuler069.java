package net.projecteuler;

import static net.projecteuler.util.Primes.totient;

public class ProjectEuler069 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_069());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_069() {
		double max_n_phin_n = 0;
		int max_n = 2;
		for (int n = 2; n <= 1_000_000; n++) {
			double n_phi_n = (double) n / ((double) totient(n));
			if (n_phi_n >= max_n_phin_n) {
				max_n_phin_n = n_phi_n;
				max_n = n;
			}
		}
		return max_n;
	}

}
