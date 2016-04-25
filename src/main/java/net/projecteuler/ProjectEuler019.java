package net.projecteuler;

public class ProjectEuler019 {

	private final static int[] DAYS 		= new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final static int[] DAYS_LEAP	= new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static void main(String[] args) {
		System.out.println(solve_019());
	}

	public static int solve_019() {
		int day = 2; //tuesday 1901, Jan 1
		int count = 0;
		for (int year = 1901; year <= 2000; year++) {
			int[] days = year % 4 == 0 ? DAYS_LEAP : DAYS;
			for (int month = 0; month < days.length; month++) {
				if (day % 7 == 0) { count++; }
				day = (day + days[month]) % 7;
			}
		}
		return count;
	}	

}
