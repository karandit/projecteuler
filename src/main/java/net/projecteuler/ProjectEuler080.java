package net.projecteuler;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static java.util.stream.LongStream.rangeClosed;
import static net.projecteuler.util.Util.sumOfDigits;

import java.math.BigDecimal;

import net.projecteuler.util.Util;

public class ProjectEuler080 {
	
	private static BigDecimal TWO 	= new BigDecimal("2");
	private static int SCALE        = 110;

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_080());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_080() {
        return rangeClosed(1, 99)
        	.filter(x -> !Util.isSqrt(x))
        	.map(x -> sumOfDigits(calcSqrt(x).toString().replace(".", "").substring(0, 100)))
        	.sum();
	}
	
	private static BigDecimal calcSqrt(long x) {
		BigDecimal n = new BigDecimal(x);
		BigDecimal lastGuess = ZERO;
		BigDecimal guess = ONE; 
		while (true) {
			lastGuess = guess;
			guess = n.divide(guess, SCALE, BigDecimal.ROUND_HALF_UP);
			guess = guess.add(lastGuess);
			guess = guess.divide(TWO, SCALE, BigDecimal.ROUND_HALF_UP);
			if (lastGuess.equals(guess)) {
				BigDecimal error = n.subtract(guess.multiply(guess));
				boolean more = error.abs().compareTo(ONE) >= 0;
				if (!more) {
					return guess;
				}
			}
		}
	}
	
}
