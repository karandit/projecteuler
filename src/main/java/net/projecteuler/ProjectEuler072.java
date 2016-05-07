package net.projecteuler;

import static net.projecteuler.Primes.factors;

import java.util.Set;

public class ProjectEuler072 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_072());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_072() {
		long sum = 0;
		for (int n = 2; n <= 1_000_000; n++) {
			sum += totient(n);
		}
		return sum;
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
