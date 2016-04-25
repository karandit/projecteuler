package net.projecteuler;

public class ProjectEuler026 {

	public static void main(String[] args) {
		System.out.println(solve_026());
	}

	public static int solve_026() {
		int dMax = 2;
		int lengthMax = 0;
		for (int d = 2; d < 1000; d++) {
			int l = recurringCycle(d);
			if (l > lengthMax) {
				lengthMax = l;
				dMax = d;
			}
		}
		return dMax;
	}

	private static int recurringCycle(int d) {
		int r = 10;
		int[] fracts = new int[d]; 
		int length = 0;
		int mod = 0;
//		StringBuilder sb = new StringBuilder("0.");
		while (r != 0) {
			mod = r % d;
			if (fracts[mod] != 0) { break; } //repeating cycle
//			sb.append(r /d);
			fracts[mod] = ++length;
			r = mod * 10;
		}
//		if (r != 0) {
//			sb.append("(");
//		}
//		System.out.print(sb.toString());
		return r == 0 ? 0 : (length - fracts[mod] +1);
	}
}
