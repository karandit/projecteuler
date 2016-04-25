package net.projecteuler;

import static net.projecteuler.Primes.isPrime;

public class ProjectEuler027 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_027());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_027() {
		int max_nr_primes = 0;
		int a_b = 0;
		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				int f = formula(a, b);
				if (f > max_nr_primes) {
					max_nr_primes = f;
					a_b = a * b;
				}
			}
		}
		return a_b;
	}

	private static int formula(int a, int b) {
		int n = 0;
		while (isPrime(n*n + a*n + b)) { n++; }
		return n;
	}
	
}
