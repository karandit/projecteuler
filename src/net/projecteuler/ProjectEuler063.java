package net.projecteuler;

import java.math.BigInteger;

public class ProjectEuler063 {
	
	public static void main(String[] args) {
		BigInteger[] powers = new BigInteger[200];
		for (int i = 2; i < powers.length; i++) { powers[i] = BigInteger.valueOf(i); }
		long n = 1;
		int found = 0;
		while (true) {
			for (int i = 2; i < powers.length; i++) {
				if (powers[i].toString().length() == n) {
					found++;
					System.out.println(found + "\t" + n + "\t" + i+ "\t" + powers[i]);
				}
				powers[i] = powers[i].multiply(BigInteger.valueOf(i));
			}
			n++;
		}
	}
}
