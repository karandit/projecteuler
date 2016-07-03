package net.projecteuler;

import static java.util.stream.IntStream.rangeClosed;
import static net.projecteuler.util.Util.isSqrt;

import java.util.HashSet;
import java.util.Set;

import net.projecteuler.util.Triple;

public class ProjectEuler064 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_064());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_064() {
		return rangeClosed(1, 10_000)
		.filter(x -> !isSqrt(x))
		.filter(x -> contFraction(x) % 2 == 1)
		.count();
	}

	private static int contFraction(int s) {
		int m = 0;
		int d= 1;
		int a = (int) Math.sqrt(s);
		final int a0 = a;

		int step = 0;
		Set<Triple<Integer, Integer, Integer>> fractions = new HashSet<>(); 
		while (true) {
//			System.out.println("m = " + m + ";\td = " + d + ";\ta = " + a);
//			System.out.print(a + ", ");
			m = d * a - m;
			d = (s - m * m) / d;
			a = (a0 + m) / d;
			Triple<Integer, Integer, Integer> triple = new Triple<>(m, d, a);
			if (fractions.contains(triple)) {
				return step;
			}
			fractions.add(triple);
			step++;
		}
	}

}
