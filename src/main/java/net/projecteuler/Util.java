package net.projecteuler;

public class Util {
	
	static long sumOfDigits(long n) {
		long sum = 0;
		while (n != 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
	
	static int countOfDigits(long n) {
		return 1 + (int) Math.log10(n);
	}
	
	static double factorial(final int n) {
		if (n == 0) return 1;
		double res = 1;
		long x = n;
		while (x > 0) { res *= x--; }
		return res;
	}
}
