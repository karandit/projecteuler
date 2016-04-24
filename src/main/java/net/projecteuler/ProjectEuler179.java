package net.projecteuler;

public class ProjectEuler179 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		int count = 0;
		int lastCountOfDivisors = 2; //for n=2 there are 2 divisors
		for (int n = 3; n <= 10_000_000; n++) {
			int countOfDivisors = Primes.countOfDivisors(n);
			if (countOfDivisors == lastCountOfDivisors) {
				count++;
			}
			lastCountOfDivisors = countOfDivisors;
		}
		
		System.out.println(count);
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

}
