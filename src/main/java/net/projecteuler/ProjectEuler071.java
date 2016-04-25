package net.projecteuler;

public class ProjectEuler071 {
	
	private static final int THRESHOLD = 1_000_000;

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_071());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_071() {
		double three_seventh = ((double) 3) / 7;
		double maxFraction = 0;
		int nominator = 3;
		int denominator = 7;
		
		for (int d = 2; d <= THRESHOLD; d++) {
			int lower = (int)(d * maxFraction);
			for (int n = lower; n < d; n++) {
				double fraction = ((double) n) /d;
//				print(n + "/" + d + " = " + fraction);
				if (fraction >= three_seventh) {
//					println();
					break;
				}
				if (maxFraction <= fraction) {
					print(n + "/" + d + " = " + fraction);
					print(" \t\t\t CHANGE");
					if (fraction == maxFraction) {
						print(" \t EQUAL");
						if (n < nominator) {
							print(" \t BUT");
							nominator = n;
							denominator = d;
						}
					} else {
						print(" \t SIMPLE");
						nominator = n;
						denominator = d;
					}
					maxFraction = fraction;
					println();
				}
//				println();
			}
//			println();
		}
		print("n: " + nominator + " d: " + denominator + " " + three_seventh);
		return nominator;
	}
	
//	private static void print(String msg) 		{ System.out.print(msg); }
//	private static void println() 				{ System.out.println(); }
	private static void print(String msg) 		{ }
	private static void println() 				{ }
	
}
