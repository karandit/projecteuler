package net.projecteuler;

import static net.projecteuler.Primes.factors;

import java.util.Set;

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

	private static int totient(int n) {
		double res = n;
		Set<Integer> factors = factors(n);
		for (Integer f : factors) {
			double factor = f;
			res *= (factor - 1) / factor;
		}
		return (int) res;
	}
	
	
}
