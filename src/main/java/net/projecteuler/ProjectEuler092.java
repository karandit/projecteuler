package net.projecteuler;

import static java.util.stream.IntStream.range;

public class ProjectEuler092 {

	public static void main(String[] args) {
		System.out.println(solve_092());
	}

	public static long solve_092() {
		long count = range(1, 10_000_000)
			.map(ProjectEuler092::chain)
			.filter(i -> i == 89)
			.count();
		return count;
	}

	private static int chain(int n) {
		while (n != 1 && n != 89) {
			n = sumOfSquares(n);
		}
		return n;
	}

	private static int sumOfSquares(int n) {
		int sum = 0;
		while (n != 0) {
			int digit = n % 10;
			sum += digit * digit;
			n = n / 10;
		}
		return sum;
	}
	
}
