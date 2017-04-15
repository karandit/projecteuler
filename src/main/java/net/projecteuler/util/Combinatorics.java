package net.projecteuler.util;

import static java.util.Collections.emptyList;
import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Combinatorics {

	private static final Map<Integer, List<List<Integer>>> cachePermutations = new HashMap<>();
	
	public static List<List<Integer>> permutations(int n) {
		List<List<Integer>> permutations = null;
		if (cachePermutations.containsKey(n)) {
			permutations = cachePermutations.get(n); 
		} else {
			List<Integer> numbers = range(0, n).boxed().collect(Collectors.toList());
			permutations = permutations(numbers);
			cachePermutations.put(n, permutations); 
		}
		return permutations;
	}

	public static List<List<Integer>> permutations(List<Integer> set) {
		List<List<Integer>> allSolutions = new LinkedList<>();
		genVariations(allSolutions, set, emptyList(), set.size());
		return allSolutions;
	}
	
	/**
	 * Take variations by k from n.
	 *
	 * @param n
	 * @param k
	 * @return the list of all solutions
	 */
	public static List<List<Integer>> variations(int n, int k) {
		if (k > n) {
			throw new IllegalArgumentException("In variations k = " + k + " must be smaller or equal than n = " + n);
		}

		List<Integer> set = range(0, n).boxed().collect(Collectors.toList());
		List<List<Integer>> allSolutions = new LinkedList<>();
		genVariations(allSolutions, set, emptyList(), k);
		return allSolutions;
	}

	public static List<List<Integer>> combinations(int n, int k) {
		if (k > n) {
			throw new IllegalArgumentException("In combinations k = " + k + " must be smaller or equal than n = " + n);
		}

		List<List<Integer>> allSolutions = new LinkedList<>();
		genCombinations(allSolutions, emptyList(), 0, n, k);
		return allSolutions;
	}

	private static void genVariations(List<List<Integer>> allSolutions, List<Integer> set, List<Integer> solution, int k) {
		if (k == 0) {
			allSolutions.add(solution);
			return;
		}
		for (Integer integer : set) {
			List<Integer> newSet = new ArrayList<>(set);
			newSet.remove(integer);
			
			List<Integer> newSolution = new ArrayList<>(solution);
			newSolution.add(integer);

			genVariations(allSolutions, newSet, newSolution, k - 1);
		}
	}

	private static void genCombinations(List<List<Integer>> allSolutions, List<Integer> solution, 
			final int start, final int n, final int k) {

		if (solution.size() == k) {
			allSolutions.add(solution);
			return;
		}
		int end = n - k + solution.size();
		for (int i = start; i <= end; i++) {
			List<Integer> newSolution = new ArrayList<>(solution);
			newSolution.add(i);

			genCombinations(allSolutions, newSolution, i + 1, n, k);
		}
	}

}
