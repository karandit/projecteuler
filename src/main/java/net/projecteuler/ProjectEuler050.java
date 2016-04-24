package net.projecteuler;

import java.util.LinkedList;
import java.util.List;

public class ProjectEuler050 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		int UPPER = 1000_000;
		List<Integer> primeList = new LinkedList<>();
		for (int i = 0; i < UPPER; i++) {
			if (Primes.isPrime(i)) {
				primeList.add(i);
			}
		}
		int[] primes = new int[primeList.size()];
		int id = 0;
		for (Integer p : primeList) {
			primes[id++] = p;
		}
		int ALL = primes.length;
		
		int max_length = 0;
		int found = 0;
		for (int lower = 0; lower < ALL; lower++) {
			int sum = 0;
			for (int upper = lower; upper < ALL; upper++) {
				sum += primes[upper];
				if (sum > UPPER) break;
				if (Primes.isPrime(sum) && upper - lower + 1 > max_length) {
					max_length = upper - lower + 1;
					found = sum;
				}
			}
		}
		System.out.println("Found: " + found + " max_lenght: " + max_length);
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}
}
