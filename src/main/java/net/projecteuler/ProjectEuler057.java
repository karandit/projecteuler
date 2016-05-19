package net.projecteuler;

import java.math.BigInteger;

public class ProjectEuler057 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_057());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_057() {
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		BigInteger TWO = new BigInteger("2");
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			a = a.add(b.multiply(TWO));
			b = a.subtract(b);
			if (a.toString().length() > b.toString().length()) {
				sum++;
			}
		}
		return sum;
	}
}
