package net.projecteuler;

import static java.lang.System.nanoTime;
import static net.projecteuler.Primes.getPrimes;
import static net.projecteuler.Util.inBinaryRepr;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProjectEuler051 {

	public static void main(String[] args) {
		long start = nanoTime();
		System.out.println(solve_051());
		System.out.println("Elapsed time: " + ((nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_051() {
		boolean[] primes = getPrimes(1_000_000);

		int actMax = 1;
		Map<String, List<Integer>> cache = new HashMap<>();
		for (int i = 2; i < primes.length; i++) {
			if (!primes[i]) { continue; }

			int[] digits = Util.digits(i);
			int[] digitsOccurences = new int[10];
			for (int digit : digits) { digitsOccurences[digit]++; }
			
			for (int occuredDigit = 0; occuredDigit < digitsOccurences.length; occuredDigit++) {
				int digitOccurence = digitsOccurences[occuredDigit];
				if (digitOccurence < 2) { continue; }
				
				List<String> keys = getKey(digits, digitOccurence, occuredDigit);
				for (String key : keys) {
					List<Integer> primeClassMembers = cache.getOrDefault(key, new LinkedList<Integer>());
					primeClassMembers.add(i);
					cache.put(key, primeClassMembers);
					if (primeClassMembers.size() > actMax) {
						actMax = primeClassMembers.size();
//						System.out.println(actMax + " " + key + " " + primeClassMembers);
						if (actMax == 8) {
							return primeClassMembers.get(0);
						}
					}
				}
			}
		}
		throw new RuntimeException("Solution not found below upper limit");
	}
	
	private static List<String> getKey(int[] digits, int digitOccurence, int occuredDigit) {
		List<String> keys = new LinkedList<>();
		
		int allCombi = (int) Math.pow(2, digitOccurence);
		for (int combi = 1; combi < allCombi; combi++) {
			boolean[] bits = inBinaryRepr(combi, digitOccurence);
			int bitIdx = 0;
			
			StringBuilder sb = new StringBuilder();
			int countOfX = 0;
			for (int digit : digits) {
				if (digit != occuredDigit) {
					sb.append(digit);
				} else {
					if (bits[bitIdx++]) {
						sb.append('x');
						countOfX++;
					} else {
						sb.append(digit);
					}
				}
			}
			if (countOfX > 1) {
				String key = sb.toString();
				keys.add(key);
			}
		}
		return keys;
	}
}
