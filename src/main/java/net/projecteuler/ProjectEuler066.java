package net.projecteuler;

import static java.util.stream.IntStream.rangeClosed;
import static net.projecteuler.util.Util.isSqrt;

import java.math.BigInteger;

import net.projecteuler.util.Tuple;

public class ProjectEuler066 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_066());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_066() {
		return rangeClosed(1, 1_000)
			.filter(d -> !isSqrt(d))
			.mapToObj(d -> new Tuple<>(d, minSolution(d)))
			.sorted((t1, t2) ->  t2.getB().compareTo(t1.getB()))
//			.peek(System.out::println)
			.findFirst().get().getA();
	}

	private static BigInteger minSolution(int s) {
		BigInteger bigS = new BigInteger(Integer.toString(s));
		int m = 0;
		int d= 1;
		int a = (int) Math.sqrt(s);
		final int a0 = a;

		BigInteger h1 = new BigInteger(Integer.toString(a));
		BigInteger k1 = BigInteger.ONE;
//		System.out.print(h1 + "/" + k1 + "; ");
		
		m = d * a - m;
		d = (s - m * m) / d;
		a = (a0 + m) / d;

		BigInteger h2 = h1.multiply(new BigInteger(Integer.toString(a))).add(BigInteger.ONE);
		BigInteger k2 = new BigInteger(Integer.toString(a));
//		System.out.print(h2 + "/" + k2 + "; ");
		
		while (true) {
			if (h2.multiply(h2).subtract(bigS.multiply(k2).multiply(k2)).equals(BigInteger.ONE)) {
				return h2;
			}
			m = d * a - m;
			d = (s - m * m) / d;
			a = (a0 + m) / d;
			
			BigInteger bigA = new BigInteger(Integer.toString(a));
			BigInteger hNext = h1.add(bigA.multiply(h2));
			BigInteger kNext = k1.add(bigA.multiply(k2));
			h1 = h2;
			k1 = k2;
			h2 = hNext;
			k2 = kNext;
//			System.out.print(h2 + "/" + k2 + "; ");
		}
	}
}
