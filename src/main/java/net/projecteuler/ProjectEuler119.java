package net.projecteuler;

import static net.projecteuler.Util.sumOfDigits;

public class ProjectEuler119 {

	public static void main(String[] args) {
		System.out.println(solve_119());
	}

	public static long solve_119() {
		int found = 0;
		long upperBound = 100;
		long upperN = 18;
		long[] powers = new long [200];
		for (int i = 2; i < 200; i++) { powers[i] = i; }
		while (true) {
			for (int i = 2; i <= upperN; i++) {
				while (powers[i] < upperBound) {
					powers[i] *= i;
					if (sumOfDigits(powers[i]) == i) {
						found++;
//						System.out.println(found + "\t" + powers[i] + "\t" + i);
						if (found == 30) {
							return powers[i];
						}
					}
				}
			}
//			System.out.println("====" + upperBound);
			upperBound *= 10;
			upperN += 9;
		}
	}

}
