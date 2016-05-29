package net.projecteuler;

import static net.projecteuler.util.Primes.sumOfDivisors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProjectEuler095 {

	private static final int THRESHOLD = 1_000_000;

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_095());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_095() {
		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 2; i < THRESHOLD; i++) {
			int sumOfDivisors = sumOfDivisors(i) - i;
			if (sumOfDivisors < THRESHOLD) {
				cache.put(i, sumOfDivisors);
			}
		}
		int max = 0;
		int longestChainMinValue = 0;
		for (int i = 2; i < THRESHOLD; i++) {
			Set<Integer> chain = getChain(i, cache);
			if (chain != null && chain.size() > max) {
				max = chain.size();
				longestChainMinValue = i;
			}
		}
		return longestChainMinValue;
	}

	private static Set<Integer> getChain(final Integer x, final Map<Integer, Integer> cache) {
		Set<Integer> chain = new HashSet<>();
		Integer n = x;
		chain.add(n);
		while (cache.containsKey(n)) {
			n = cache.get(n);
			if (!chain.contains(n)) {
				chain.add(n);
			} else {
				return n.equals(x) ? chain:  null;
			}
		}
		return null;
	}
}
