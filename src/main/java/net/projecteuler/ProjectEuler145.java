package net.projecteuler;

import static java.util.stream.LongStream.range;
import static net.projecteuler.util.Util.digits;
import static net.projecteuler.util.Util.fromDigits;
import static net.projecteuler.util.Util.reverse;

import java.util.Arrays;

public class ProjectEuler145 {

	private static final int THRESHOLD = 1_000_000_000;

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_145());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_145() {
		return range(1, THRESHOLD)
		.filter(x -> x % 10 != 0)
		.map(x -> x + reverseLong(x))
//		.mapToObj(x -> digits(x))
//		.filter(digits -> Arrays.stream(digits).allMatch(x -> x % 2 == 1))
		.count();
	}

	private static long reverseLong(long n) {
		return fromDigits(reverse(digits(n)));
	}

}
