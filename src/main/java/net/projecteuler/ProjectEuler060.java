package net.projecteuler;

import static net.projecteuler.Primes.getPrimes;
import static net.projecteuler.Util.digits;

import java.util.LinkedList;
import java.util.List;

import net.projecteuler.graph.Clique;

public class ProjectEuler060 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_060());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_060() {
		boolean[] primes = getPrimes(100_000_000);
		Clique<Integer> clique = new Clique<>();
		
		for (int prime = 10; prime < primes.length; prime++) {
			if (!primes[prime]) { continue; }
			List<Tuple<Integer, Integer>> separatedDigits = separatedDigits(prime);
			for (Tuple<Integer, Integer> tuple : separatedDigits) {
				if (primes[tuple.getA()] && primes[tuple.getB()]) {
					List<List<Integer>> res = clique.connect(tuple.getA(), tuple.getB());
					for (List<Integer> s : res) {
						if (s.size() == 5) {
							int sum = 0;
							for (Integer n : s) {
								sum += n;
							}
							return sum;
						}
					}
				}
			}
		}
		throw new RuntimeException("Solution not found below threshold");
	}

	private static List<Tuple<Integer, Integer>> separatedDigits(int n) {
		List<Tuple<Integer, Integer>> res = new LinkedList<>();
		int[] digits = digits(n);
		for (int sep = 1; sep < digits.length; sep++) {
			if (digits[sep] == 0) { continue; }
			int firstDigit = 0;
			{
				int multi = 1;
				for (int i = sep - 1; i >= 0; i--) {
					firstDigit += digits[i] * multi;
					multi *= 10;
				}
			}
			int secondDigit = 0;
			{
				int multi = 1;
				for (int i = digits.length - 1; i >= sep; i--) {
					secondDigit += digits[i] * multi;
					multi *= 10;
				}
			}
			res.add(new Tuple<>(firstDigit, secondDigit));
		}
		return res;
	}

}
