package net.projecteuler;

import java.util.LinkedList;
import java.util.List;

import net.projecteuler.util.Primes;

public class ProjectEuler023 {

	private static final int LIMIT = 28123;

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_023());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_023() {
		List<Integer> abundants = new LinkedList<>();
		int n = 1;
		while (n <= LIMIT) {
			if (Primes.isAbundant(n)) {
				abundants.add(n);
			}
			n++;
		}
		
		boolean[] numbers = new boolean[LIMIT + 1];
		
		for (Integer a : abundants) {
			for (Integer b : abundants) {
				int abundantsSum = a + b;
				if (abundantsSum > LIMIT) break;
				numbers[abundantsSum] = true;
			}
		}
		long sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (!numbers[i]) sum += i;
		}
		return sum;
	}
}
