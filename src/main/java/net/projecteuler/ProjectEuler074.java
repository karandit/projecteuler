package net.projecteuler;

import static java.util.stream.IntStream.range;

import java.util.HashSet;
import java.util.Set;

public class ProjectEuler074 {
	
	private static final int[]  FACTORIALS = new int[] {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

	public static void main(String[] args) {
		System.out.println(solve_074());
	}

	public static long solve_074() {
		long count = range(1, 1_000_000)
			.map(ProjectEuler074::digitFactorialChain)
			.filter(i -> i == 60)
			.count();
		return count;
	}

	private static int digitFactorialChain(Integer i) {
		Set<Integer> visited = new HashSet<>();
		while (!visited.contains(i)) {
			visited.add(i);
			i = digitFactorialSum(i);
		}
		return visited.size();
	}

	private static int digitFactorialSum(int n) {
		int sum = 0;
		while (n != 0) {
			int digit = n % 10;
			sum += FACTORIALS[digit];
			n = n / 10;
		}
		return sum;
	}
}
