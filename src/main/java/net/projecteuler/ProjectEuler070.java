package net.projecteuler;

import java.util.Arrays;
import java.util.Set;

public class ProjectEuler070 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();

		double min_n_phin_n = 10_000_000;
		int min_n = 2;
		for (int n = 9_999_999; n > 1; n--) {
			int totient = totient(n);
			double n_phi_n = (double) n / (double) totient;
			if (n_phi_n <= min_n_phin_n && Arrays.equals(digits(n), digits(totient)) ) {
				min_n_phin_n = n_phi_n;
				min_n = n;
			}
		}
		System.out.println(min_n);
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	private static int[] digits(int n) {
		int[] res = new int[10];
		int d = n;
		while (d != 0) {
			res[d % 10]++;
			d /= 10;
		}
		return res;
	}
	
	private static int totient(int n) {
		double res = n;
		Set<Integer> factors = Primes.factors(n);
		for (Integer f : factors) {
			double factor = f;
			res *= (factor - 1) / factor;
		}
		return (int) res;
	}

}