package net.projecteuler;

public class ProjectEuler040 {
	
	public static void main(String[] args) {
		long prod = 1;
		int[] ns = new int[] {1, 10, 100, 1_000, 10_000, 100_000};
		for (int i = 0; i < ns.length; i++) {
			prod *= nthDigit(ns[i]);
		}
		System.out.println(prod);
	}

	private static int nthDigit(int n) {
		int c = n;
		int power = 1;
		int nine = 9;
		long rangeBound = nine * power;
		while (!(c < rangeBound)) { //9, 180, 2700, 36_000
			c -= rangeBound;
			power++;
			nine *= 10;
			rangeBound = nine * power; //9 * 1, 90 * 2, 900 * 3 
		}
		c--;
		int offset = c / power;
		int modulo = c % power;
		return digits((nine / 9) + offset)[modulo];
	}
	
	private static int[] digits(int n) {
		int nDigits = 1 + (int) Math.log10(n);
		int[] res = new int[nDigits];
		int i = nDigits - 1;
		while (n != 0) {
			res[i--] = n % 10;
			n /= 10;
		}
		return res;
	}
}
