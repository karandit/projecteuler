package net.projecteuler;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.LongStream;

import net.projecteuler.util.Tuple;
import net.projecteuler.util.Util;

public class ProjectEuler098 {

	private static final int UPPER_LIMIT = (int) Math.sqrt(1_000_000_000);
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_098());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_098() {
		List<Tuple<String, String>> wordPairs = new LinkedList<>();
		
		readWordsFromFile("ProjectEuler_098.txt").stream()
		.collect(groupingBy((String word) -> {
			char[] keyAsArray = word.toCharArray();
			Arrays.sort(keyAsArray);
			return new String(keyAsArray);
		}))
		.entrySet().stream()
		.filter(e -> e.getValue().size() > 1)
		.forEach(e -> {
			List<String> words = e.getValue();
			for (int i = 0; i < words.size() - 1; i++) {
				for (int j = i + 1; j < words.size(); j++) {
					wordPairs.add(new Tuple<>(words.get(i), words.get(j)));
				}
			}
		});

		Map<String, Long> fingerPrints = generateSquareFingerPrints();
		
		return wordPairs.stream()
			.map(wordPair -> generateFingerPrint(wordPair.getA(), wordPair.getB(), ProjectEuler098::genMask))
			.filter(fingerPrint -> fingerPrints.containsKey(fingerPrint))
			.map(fingerPrint -> fingerPrints.get(fingerPrint))
			.mapToLong(l -> (Long) l).max().getAsLong();
	}

	public static Map<String, Long> generateSquareFingerPrints() {
		Map<String, Long> fingerPrints = new HashMap<>();
		
		LongStream.rangeClosed(1, UPPER_LIMIT)
		.map(i -> i * i)
		.mapToObj(n -> (Long) n)
		.collect(groupingBy(n -> {
				int[] digits = Util.digits(n);
				Arrays.sort(digits);
				StringBuilder sb = new StringBuilder();
				Arrays.stream(digits).forEach(x -> sb.append(x));
				return sb.toString();
		}))
		.values().stream()
		.filter(list -> list.size() > 1)
		.forEach(v -> {
				for (int i = 0; i < v.size() - 1; i++) {
					for (int j = i + 1; j < v.size(); j++) {
						Long long1 = v.get(i); 
						Long long2 = v.get(j);
						String fingerPrint = generateFingerPrint(long1, long2, ProjectEuler098::genMaskLong);
						long max = Math.max(long1, long2);
						if (fingerPrints.containsKey(fingerPrint)) {
							Long act = fingerPrints.get(fingerPrint);
							fingerPrints.put(fingerPrint, Math.max(max, act));
						} else {
							fingerPrints.put(fingerPrint, max);
						}
					}
				}
		});
		return fingerPrints;
	}

	private static<T> String generateFingerPrint(T s1, T s2, BiFunction<T, T, String> f) {
		return asList(f.apply(s1, s2), f.apply(s2, s1)).stream().sorted().collect(joining());
	}

	public static String genMask(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		for (char c : s2.toCharArray()) {
			sb.append(s1.indexOf(c));
		}
		return sb.toString();
	}

	public static String genMaskLong(Long l1, Long l2) {
		List<Integer> digits = new ArrayList<Integer>();
		for (int i : Util.digits(l1)) {
			digits.add(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i : Util.digits(l2)) {
			sb.append(digits.indexOf(i));
		}
		return sb.toString();
	}

	private static List<String> readWordsFromFile(String fileName) {
		try (InputStream is = ProjectEuler098.class.getResourceAsStream(fileName);
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
