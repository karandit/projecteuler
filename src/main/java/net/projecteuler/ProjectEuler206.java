package net.projecteuler;

/**
 * Heuristics:
 * - the last number of the square is 0, it means the original number ends also with 0.
 * - it means the other number is 0, so we have 900
 * - only squares of 30 (30 * 30 = 900) and 70 (70 * 70 = 4900) ends with 900
 * - it is enough to check just the numbers which end with 30 or 70  
 * 
 * @author Kárándi Tamás
 */
public class ProjectEuler206 {

	private static final long LOWER = (((long) Math.sqrt(1020304050607080900L)) / 100) * 100 + 30;
	private static final long UPPER = (long) Math.sqrt(1929394959697989990L);

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_206());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_206() {
		int delta = 40;
		for (long i = LOWER; i <= UPPER; i += delta, delta = delta == 40 ? 60: 40 ) {
			if (matchPattern(Util.digits(i * i))) {
				return i;
			}
		}
		throw new RuntimeException("Solution not found between " + LOWER + " and " + UPPER);
	}

	private static boolean matchPattern(int[] digits) {
		if (digits.length != 19) {
			return false;
		}
		for (int i = 0; i < 9; i++) {
			if (digits[i * 2] != i + 1) {
				return false;
			}
		}

		return true;
	}

}
