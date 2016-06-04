package net.projecteuler.util;

import static java.util.Collections.emptyList;
import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Combinatorics {
	
	public static List<List<Integer>> permutations(int n) {
		List<Integer> numbers = range(0, n).boxed().collect(Collectors.toList());
		return permutations(numbers);
	}

	public static List<List<Integer>> permutations(List<Integer> set) {
		List<List<Integer>> allSolutions = new LinkedList<>();
		genVariations(allSolutions, set, emptyList(), set.size());
		return allSolutions;
	}
	
	public static List<List<Integer>> variations(int n, int k) {
		if (k > n) {
			throw new IllegalArgumentException("In variations k = " + k + " must be smaller or equal than n = " + n);
		}

		List<Integer> set = range(0, n).boxed().collect(Collectors.toList());
		List<List<Integer>> allSolutions = new LinkedList<>();
		genVariations(allSolutions, set, emptyList(), k);
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

}
