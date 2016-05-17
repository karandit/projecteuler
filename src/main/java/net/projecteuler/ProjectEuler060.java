package net.projecteuler;

import static net.projecteuler.Primes.getPrimes;
import static net.projecteuler.Util.digits;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProjectEuler060 {

	private static final int THRESHOLD = 100_000_000;

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_060());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_060() {
		boolean[] primes = getPrimes(THRESHOLD);
		final Map<Integer, Set<Integer>> level1 = new HashMap<>();
		final Map<Integer, Set<Integer>> level2 = new HashMap<>();
		
		for (int prime = 10; prime < primes.length; prime++) {
			if (!primes[prime]) { continue; }
			
			List<Tuple<Integer, Integer>> separatedDigits = separatedDigits(prime);
			for (Tuple<Integer, Integer> tuple : separatedDigits) {
				if (!primes[tuple.getA()] || !primes[tuple.getB()]) {
					continue;
				}
				Integer a = tuple.getA();
				Integer b = tuple.getB();
					
				Set<Integer> pairsA = getOrDefault(level1, a, new HashSet<>());;
				pairsA.add(b);
				if (!level1.containsKey(b) || !level1.get(b).contains(a)) {
					continue;
				}
				Set<Integer> targetsA = getOrDefault(level2, a, new HashSet<>());
				Set<Integer> targetsB = getOrDefault(level2, b, new HashSet<>());
				targetsA.add(b);
				targetsB.add(a);
						
				Set<Integer> intersectAB = new HashSet<>(targetsA);
				intersectAB.retainAll(targetsB);
				for (Integer c : intersectAB) {
					if (!level2.containsKey(c)) { continue; }
					Set<Integer> targetsC = level2.get(c);

					Set<Integer> intersectABC = new HashSet<>(intersectAB);
					intersectABC.retainAll(targetsC);
					for (Integer d : intersectABC) {
						if (!level2.containsKey(d)) { continue; }
						Set<Integer> targetsD = level2.get(d);
						
						Set<Integer> intersectABCD = new HashSet<>(intersectABC);
						intersectABCD.retainAll(targetsD);
						for (Integer e : intersectABCD) {
							return a + b + c + d + e;
						}
					}
				}
			}
		}
		throw new RuntimeException("Solution not found below " + THRESHOLD);
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

	public static<K, V> V getOrDefault(Map<K, V> map, K key, V value) {
		if (!map.containsKey(key)) {
			map.put(key, value);
			return value;
		}
		return map.get(key);
	}

}
