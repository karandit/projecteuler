package net.projecteuler;

import static net.projecteuler.util.Primes.totient;

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
	
}
