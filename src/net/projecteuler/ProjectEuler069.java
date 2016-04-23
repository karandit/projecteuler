package net.projecteuler;

import java.util.HashSet;
import java.util.Set;

public class ProjectEuler069 {
	private final static int[] PRIMES = new int[] {
	 2,      3,      5,      7,     11,     13,     17,     19,     23,     29, 
     31,     37,     41,     43,     47,     53,     59,     61,     67,     71, 
     73,     79,     83,     89,     97,    101,    103,    107,    109,    113, 
    127,    131,    137,    139,    149,    151,    157,    163,    167,    173, 
    179,    181,    191,    193,    197,    199,    211,    223,    227,    229, 
    233,    239,    241,    251,    257,    263,    269,    271,    277,    281, 
    283,    293,    307,    311,    313,    317,    331,    337,    347,    349, 
    353,    359,    367,    373,    379,    383,    389,    397,    401,    409, 
    419,    421,    431,    433,    439,    443,    449,    457,    461,    463, 
    467,    479,    487,    491,    499,    503,    509,    521,    523,    541, 
    547,    557,    563,    569,    571,    577,    587,    593,    599,    601, 
    607,    613,    617,    619,    631,    641,    643,    647,    653,    659, 
    661,    673,    677,    683,    691,    701,    709,    719,    727,    733, 
    739,    743,    751,    757,    761,    769,    773,    787,    797,    809, 
    811,    821,    823,    827,    829,    839,    853,    857,    859,    863, 
    877,    881,    883,    887,    907,    911,    919,    929,    937,    941, 
    947,    953,    967,    971,    977,    983,    991,    997,   1009,   1013,
	};
	
	public static void main(String[] args) {
		long start = System.nanoTime();

		double max_n_phin_n = 0;
		int max_n = 2;
		for (int n = 2; n <= 1_000_000; n++) {
			double n_phi_n = (double) n / ((double) totient(n));
			if (n_phi_n >= max_n_phin_n) {
				max_n_phin_n = n_phi_n;
				max_n = n;
			}
		}
		System.out.println(max_n);
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
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
	

	private static Set<Integer> factors(final int d) {
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
	
}
