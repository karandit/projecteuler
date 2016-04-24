package net.projecteuler;

import static java.lang.Math.sqrt;

import java.util.LinkedList;

public class ProjectEuler046 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();

		LinkedList<Integer> primes = new LinkedList<Integer>();
		primes.add(1);
		int n = 3;
		while (true) {
			if (isPrime(n)) {
				primes.add(0, n);
			} else {
				if (!isGoldbach(n, primes)) break;
			}
			n += 2;
		}

		System.out.println(n);
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	private static boolean isPrime(int n) {
		if (n <= 1) return false;
		else if (n <= 3) return true;
		else if (n % 2 == 0 || n % 3 == 0) return false;
		
		int i = 5;
		while (i * i <= n) {
			if (n % i == 0 || n % (i + 2) == 0) return false;
			i += 6;
		}
		return true;	
    }
	
	private static boolean isGoldbach(int n, LinkedList<Integer> primes) {
		for (Integer prime : primes) {
			if (sqrt((n - prime) / 2) % 1 == 0) return true;   
		}
		return false;
	}
	

}
