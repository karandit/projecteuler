package net.projecteuler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.projecteuler.util.Util;

public class ProjectEuler062 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_062());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_062() {
		long i = 2;
		Map<String, Set<Long>> cache = new HashMap<>();
		while (true) {
			long n = i * i * i;
			int[] digits = Util.digits(n);
			Arrays.sort(digits);
			String key = Arrays.toString(digits);
			if (!cache.containsKey(key)) {
				cache.put(key, new HashSet<>());
			}
			Set<Long> cubeFamily = cache.get(key);
			cubeFamily.add(i);
			if (cubeFamily.size() == 5) {
				long sol = cubeFamily.stream().min(Long::compareTo).get();
				return sol * sol * sol;
			}
			i++;
		}
	}
}