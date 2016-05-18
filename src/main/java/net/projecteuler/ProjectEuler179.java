package net.projecteuler;

import net.projecteuler.util.Primes;

public class ProjectEuler179 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_179());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_179() {
		int count = 0;
		int lastCountOfDivisors = 2; //for n=2 there are 2 divisors
		for (int n = 3; n <= 10_000_000; n++) {
			int countOfDivisors = Primes.countOfDivisors(n);
			if (countOfDivisors == lastCountOfDivisors) {
				count++;
			}
			lastCountOfDivisors = countOfDivisors;
		}
		return count;
	}

}
