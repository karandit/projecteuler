package net.projecteuler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import net.projecteuler.util.Primes;

public class ProjectEuler087 {

	private static final int THRESHOLD = 50_000_000;

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_087());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_087() {
		boolean[] primes = Primes.getPrimes((int) Math.sqrt(50_000_000));

		List<Integer> pw2s = generatePowers(primes, 7069, x -> x * x);
		List<Integer> pw3s = generatePowers(primes, 367, x -> x * x * x);
		List<Integer> pw4s = generatePowers(primes, 83, x -> x * x * x * x);
		
		Set<Integer> numbers = new HashSet<>();
		for (Integer pw2 : pw2s) {
			for (Integer pw3 : pw3s) {
				int pw23 = pw2 + pw3;
				if (pw23 > THRESHOLD) {
					break;
				}
				for (Integer pw4 : pw4s) {
					int pw234 = pw23 + pw4;
					if (pw234 < THRESHOLD) {
						if (!numbers.contains(pw234)) {
							numbers.add(pw234);
						}
					} else {
						break;
					}
				}
			}
			
		}
		
		return numbers.size();
	}

	public static List<Integer> generatePowers(boolean[] primes, int upperLimit, Function<Integer, Integer> f) {
		List<Integer> res = new LinkedList<>();
		for (int i = 2; i <= upperLimit; i++) {
			if (!primes[i]) {
				continue;
			}
			Integer apply = f.apply(i);
			res.add(apply);
		}
		return res;
	}

}
