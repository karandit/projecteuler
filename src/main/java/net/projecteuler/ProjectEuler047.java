package net.projecteuler;

import java.util.HashSet;
import java.util.Set;

import net.projecteuler.util.Primes;

public class ProjectEuler047 {
	private final static int DESIRED_LENGTH = 4 - 1;
	private final static int DESIRED_DIFF = 4;
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_047());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_047() {
		Set<Integer> lastFactors = new HashSet<>();
		int lastFactorsSize = 0;
		int found_length = 0;
		int first_n = 1;
		int n = 2;
		while (found_length <  DESIRED_LENGTH) {
			Set<Integer> factors = Primes.factors(n);
			HashSet<Integer> union = new HashSet<>(factors);
			union.addAll(lastFactors);
			if (lastFactorsSize >= DESIRED_DIFF && union.size() >= lastFactorsSize + DESIRED_DIFF) {
				found_length++;
			} else {
				found_length = 0;
				first_n = n;
			}
			lastFactors = factors;
			lastFactorsSize = lastFactors.size();
			n++;
		}
		return first_n;
	}

}
