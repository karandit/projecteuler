package net.projecteuler;

import static java.util.stream.IntStream.range;

public class ProjectEuler001 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_001());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_001() {
		return range(1, 1000).filter(n -> n % 3 == 0 || n % 5 == 0).sum();
	}
}
