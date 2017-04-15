package net.projecteuler.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Primes {

	public final static int[] PRIMES;

	static {
		boolean[] primes = getPrimes(40000);
		int primeIdx = 0;
		PRIMES = new int[6000];
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				PRIMES[primeIdx] = i;
				primeIdx++;
			}
		}
	}

	public static Set<Integer> factors(final int d) {
		Set<Integer> factors = new HashSet<>();
		int n = d;
		if (n < 2) {
			return factors;
		}
		int upper = 1 + ((int) Math.sqrt(n));
		int primeIndex = 0;
		int prime = PRIMES[primeIndex]; 
		while (prime <= upper) {
			if (prime * prime > d) break;
			while (n % prime == 0) {
	            factors.add(prime);
	            n /= prime;
			}
            prime = PRIMES[++primeIndex];
		}
		if (n > 1)
	        factors.add(n);
		return factors;
	}
	
	public static List<Tuple<Integer, Integer>> factorsAndExponents(final int d) {
		List<Tuple<Integer, Integer>> factors = new LinkedList<>();
		int n = d;
		if (n < 2) {
			return factors;
		}
		int upper = 1 + ((int) Math.sqrt(n));
		int primeIndex = 0;
		int prime = PRIMES[primeIndex]; 
		while (prime <= upper) {
			if (prime * prime > d) break;
			int expo = 0;
			while (n % prime == 0) {
	            expo++;
	            n /= prime;
			}
			if (expo != 0) { 
		        factors.add(new Tuple<Integer, Integer>(prime, expo));
			}
            prime = PRIMES[++primeIndex];
		}
		if (n > 1) {
	        factors.add(new Tuple<Integer, Integer>(n, 1));
		}
	    return factors;
	}

	public static int countOfDivisors(final int d) {
		int prod = 1;
		List<Tuple<Integer, Integer>> factors = factorsAndExponents(d);
		for (Tuple<Integer, Integer> tuple : factors) {
			Integer expo = tuple.getB();
			prod *= expo + 1;
		}
		return prod;
	}
	
	
	public static int sumOfDivisors(final int d) {
		int prod = 1;
		List<Tuple<Integer, Integer>> factors = factorsAndExponents(d);
		for (Tuple<Integer, Integer> tuple : factors) {
			Integer factor = tuple.getA();
			Integer expo = tuple.getB();
			prod *= (Math.pow(factor, expo + 1) - 1) / (factor - 1);
		}
		return prod;
	}

	public static boolean isAbundant(final int d) {
		return sumOfDivisors(d) > d * 2;
	}

	/**
	 * Function to calculate all primes less than n.
	 * Uses sieve of Atkin.
	 * 
	 * @param limit the upper limit
	 * @return the bitmap of numbers until n, the primes are true
	 */
	public static boolean[] getPrimes(int limit) {
		/** initialize the sieve **/
		boolean[] prime = new boolean[limit + 1];
		prime[2] = true;
		prime[3] = true;
		int root = (int) Math.ceil(Math.sqrt(limit));

		/**
		 * put in candidate primes:
		 * 
		 * integers which have an odd number of representations by certain
		 * quadratic forms
		 **/
		for (int x = 1; x < root; x++) {
			for (int y = 1; y < root; y++) {
				int n = 4 * x * x + y * y;
				if (n <= limit && (n % 12 == 1 || n % 12 == 5))
					prime[n] = !prime[n];
				n = 3 * x * x + y * y;
				if (n <= limit && n % 12 == 7)
					prime[n] = !prime[n];
				n = 3 * x * x - y * y;
				if ((x > y) && (n <= limit) && (n % 12 == 11))
					prime[n] = !prime[n];
			}
		}

		/** eliminate composites by sieving, omit multiples of its square **/
		for (int i = 5; i <= root; i++)
			if (prime[i])
				for (int j = i * i; j < limit; j += i * i)
					prime[j] = false;
		return prime;
	}


	public static boolean isPrime(int n) {
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
	public static int totient(int n) {
		double res = n;
		Set<Integer> factors = factors(n);
		for (Integer f : factors) {
			double factor = f;
			res *= (factor - 1) / factor;
		}
		return (int) res;
	}
	
	public static long gcd(long a, long b) {
		if (a == 0) {
			return b;
		}
		while (b != 0) {
			if (a > b) 
				a = a- b;
			else 
				b = b - a;
		}
		return a;
	}
}
