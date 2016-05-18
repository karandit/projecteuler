package net.projecteuler;

import java.math.BigInteger;

public class ProjectEuler097 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_097());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_097() {
		BigInteger mod = new BigInteger("10000000000");
		return new BigInteger("2").modPow(new BigInteger("7830457"), mod)
				.multiply(new BigInteger("28433"))
				.add(BigInteger.ONE)
				.mod(mod).longValue();
	}

}
