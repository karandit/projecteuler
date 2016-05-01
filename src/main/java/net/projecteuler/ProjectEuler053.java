package net.projecteuler;

import static net.projecteuler.Util.factorial;

public class ProjectEuler053 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_053());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_053() {
		int res = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r <= n; r++) {
				if (factorial(n) / (factorial(r) * factorial(n - r)) > 1_000_000) {
					res++;
				}
			}
		}
		return res;
	}
}
