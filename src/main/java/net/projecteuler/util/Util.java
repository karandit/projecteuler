package net.projecteuler.util;

public class Util {
	
	public static long sumOfDigits(long n) {
		long sum = 0;
		while (n != 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
	
	public static long sumOfDigits(String n) {
		char[] charArray = n.toString().toCharArray();
		long sum = 0;
		for (int i = 0; i < charArray.length; i++) {
			sum += charArray[i] - '0';
		}
		return sum;
	}
	
	public static int[] digits(long n) {
		int[] digits = new int[countOfDigits(n)];
		int i = digits.length - 1;
		while (n != 0) {
			digits[i--] += n % 10;
			n = n / 10;
		}
		return digits;
	}

	public static long fromDigits(int[] digits) {
		long res = 0;
		for (int i = 0; i < digits.length; i++) {
			res = res * 10 + digits[i];
		}
		return res;
	}

	public static int[] reverse(int[] inp) {
		int length = inp.length;
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			res[length - i -1] = inp[i];
		}
		return res;
	}
	
	
	static int countOfDigits(long n) {
		return 1 + (int) Math.log10(n);
	}
	
	public static double factorial(final int n) {
		if (n == 0) return 1;
		double res = 1;
		long x = n;
		while (x > 0) { res *= x--; }
		return res;
	}
	
	public static boolean[] inBinaryRepr(int number, int digits) {
		boolean[] bits = new boolean[digits];
		
		for (int i = digits - 1; i >= 0; i--) {
			bits[i] = number % 2 != 0;
			number /= 2;
		}

		return bits;
	}

	public static boolean isSqrt(long n) {
		double sqrt = Math.sqrt(n);
		return (sqrt - Math.floor(sqrt)) == 0.0;
	}


}
