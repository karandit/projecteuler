package net.projecteuler;

import static net.projecteuler.util.Util.fromDigits;
import static net.projecteuler.util.Util.isSqrt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import net.projecteuler.util.Combinatorics;
import net.projecteuler.util.Tuple;

public class ProjectEuler098 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_098());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_098() {
		List<String> words = readWordsFromFile();
		Map<String, List<String>> groups = groupWords(words);
		Map<String, List<String>> rawAnagrams = filterAngarams(groups);
		Map<List<Character>, Tuple< Tuple<List<String>, Set<Character>>, Tuple<List<int[]>, boolean[]>>> anagrams = normalizeKeys(rawAnagrams);
		
		Map<Integer, List<List<Integer>>> variationsCache = new HashMap<>();
		long res = 0;
		
		for (Map.Entry<List<Character>, Tuple< Tuple<List<String>, Set<Character>>, Tuple<List<int[]>, boolean[]>>> entry : anagrams.entrySet()) {
			List<Character> k = entry.getKey();
			Tuple< Tuple<List<String>, Set<Character>>, Tuple<List<int[]>, boolean[]>> v = entry.getValue();
		
			List<int[]> allWordIdxs = v.getB().getA();
			boolean[] zeros = v.getB().getB();
			List<List<Integer>> variations = getVariations(variationsCache, k.size());
			for (List<Integer> variation : variations) {
				boolean skipVariation = false;
				for (int zeroIdx = 0; zeroIdx < zeros.length; zeroIdx++) {
					if (zeros[zeroIdx] && variation.get(zeroIdx) == 0) {
						skipVariation = true;
						break;
					}
				}
				if (skipVariation) {
					continue;
				}
				boolean allSqrt = true;
				
				long sqrtMax = 0;
				for (int[] wordIdxs : allWordIdxs) {
					int[] digits = applyVariation(variation, wordIdxs);
					long sqrtCan = fromDigits(digits);
					sqrtMax = Math.max(sqrtMax, sqrtCan);
					if (!isSqrt(sqrtCan)) {
						allSqrt = false;
						break;
					}
				}
				if (allSqrt) {
					res = Math.max(res,  sqrtMax);
				}
			}
		}
		return res;
	}

	public static int[] applyVariation(List<Integer> variation, int[] wordIdxs) {
		int[] digits = new int[wordIdxs.length];
		int i = 0;
		for (int wordIdx : wordIdxs) {
			digits[i++] = variation.get(wordIdx);
		}
		return digits;
	}
	
	private static List<List<Integer>> getVariations(Map<Integer, List<List<Integer>>> cache, Integer key) {
		if (cache.containsKey(key)) {
			return cache.get(key);
		} else {
			List<List<Integer>> variations = Combinatorics.variations(10, key);
			cache.put(key, variations);
			return variations;
		}
	}

	private static Map<List<Character>, 
	Tuple<
	Tuple<List<String>, Set<Character>>,
	Tuple<List<int[]>, boolean[]>
	>> normalizeKeys(Map<String, List<String>> input) {
		Map<List<Character>, 	Tuple<
		Tuple<List<String>, Set<Character>>,
		Tuple<List<int[]>, boolean[]>
		>> res = new HashMap<>();
		for (Map.Entry<String, List<String>> entry : input.entrySet()) {
			List<Integer> distincCharsInt = entry.getKey().chars()
					.distinct()
					.boxed()
					.collect(Collectors.toList());

			
			List<Character> distincChars = entry.getKey().chars()
					.distinct()
					.boxed()
					.map(i -> new Character((char) i.intValue()))
					.collect(Collectors.toList());
			
			Set<Character> firstChars = entry.getValue().stream()
					.map(v -> v.charAt(0))
					.collect(Collectors.toSet());
			
			//-----------
			List<int[]> allIndices = new LinkedList<>();
			for(String anagram : entry.getValue()) {
				int[] indices = anagram.chars().map(c -> distincCharsInt.indexOf(c)).toArray();
				allIndices.add(indices);
			}
			boolean[] firstCharsIdx = new boolean[entry.getValue().get(0).length()];
			for(String anagram : entry.getValue()) {
				firstCharsIdx[distincCharsInt.indexOf(new Integer(anagram.charAt(0)))] =  true;
			}
			
			
			Tuple<List<String>, Set<Character>> t1 = new Tuple<>(entry.getValue(), firstChars);
			Tuple<List<int[]>, boolean[]> t2 = new Tuple<>(allIndices, firstCharsIdx);
			res.put(distincChars, new Tuple<>(t1, t2));
		}
		return res;
	}

	private static Map<String, List<String>> filterAngarams(Map<String, List<String>> groups) {
		Map<String, List<String>> anagrams = new HashMap<>();
		for (Map.Entry<String, List<String>> groupEntry : groups.entrySet()) {
			if (groupEntry.getValue().size() > 1) {
				anagrams.put(groupEntry.getKey(), groupEntry.getValue());
			}
		}
		return anagrams;
	}

	private static Map<String, List<String>> groupWords(List<String> words) {
		Map<String, List<String>> groups = new HashMap<>();

		for (String word : words) {	
			char[] keyAsArray = word.toCharArray();
			Arrays.sort(keyAsArray);
			String key = new String(keyAsArray);
			if (!groups.containsKey(key)) {
				groups.put(key, new LinkedList<>());
			}
			List<String> group = groups.get(key);
			group.add(word);
		}
		return groups;
	}

	private static List<String> readWordsFromFile() {
		try (InputStream is = ProjectEuler098.class.getResourceAsStream("ProjectEuler_098.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
				
			List<String> words = new LinkedList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				for (String s : line.split(",")) {
					words.add(s.replace("\"", ""));
				}
			}
			return words;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
