package net.projecteuler;

import static java.util.stream.LongStream.iterate;
import static net.projecteuler.util.Util.sumOfDigits;

public class ProjectEuler551 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_551());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	private static long solve_551() {
		return iterate(1, x -> x + sumOfDigits(x))
			.limit(1_000_000L)
			.reduce((acc, x) -> x)
			.getAsLong();
	}

}
