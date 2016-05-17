package net.projecteuler.graph;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Clique<T extends Comparable<T>> {
	
	private final Map<T, Set<T>> level1 = new HashMap<>();
	private final Map<T, Set<T>> level2 = new HashMap<>();

	public List<List<T>> connect(T a, T b) {
		Set<T> targetsA = getOrDefault(level1, a, new HashSet<>());;
		targetsA.add(b);
		
		if (level1.containsKey(b) && level1.get(b).contains(a)) {
			List<List<T>> res = new LinkedList<>();
			res.add(sortedList(asList(a, b)));
			
			List<List<T>> connectLevel2 = connectLevel2(a, b);
			if (!connectLevel2.isEmpty()) {
				res.addAll(connectLevel2);
			}
			return res;
		}
		return asList();
	}

	private List<List<T>> connectLevel2(T a, T b) {
		Set<T> targetsA = getOrDefault(level2, a, new HashSet<>());;
		Set<T> targetsB = getOrDefault(level2, b, new HashSet<>());;
		targetsA.add(b);
		targetsB.add(a);
		
		Set<T> intersectAB = new HashSet<>(targetsA);
		intersectAB.retainAll(targetsB);
		
		if (intersectAB.isEmpty()) {
			return asList();
		}
		ArrayList<T> intersection = new ArrayList<>(intersectAB);
		Collections.sort(intersection);
		
		List<List<T>> res = new LinkedList<>();
		for (T c : intersection) {
			List<T> s3 = sortedList(asList(a, b, c));
			res.add(s3);
			List<List<T>> connectLevel3 = connectLevel3(s3.get(0), s3.get(1), s3.get(2));
			if (!connectLevel3.isEmpty()) {
				res.addAll(connectLevel3);
			}
		}
		return res;
	}

	private List<List<T>> connectLevel3(T a, T b, T c) {
		Set<T> targets2A = getOrDefault(level2, a, new HashSet<>());;
		Set<T> targets2B = getOrDefault(level2, b, new HashSet<>());;
		Set<T> targets2C = getOrDefault(level2, c, new HashSet<>());;

		Set<T> intersectABC = new HashSet<>(targets2A);
		intersectABC.retainAll(targets2B);
		intersectABC.retainAll(targets2C);

		if (intersectABC.isEmpty()) {
			return asList();
		}
		List<List<T>> res = new LinkedList<>();
		for (T d : intersectABC) {
			List<T> s4 = sortedList(asList(a, b, c, d));
			res.add(s4);
			List<List<T>> connectLevel4 = connectLevel4(s4.get(0), s4.get(1), s4.get(2), s4.get(3));
			if (!connectLevel4.isEmpty()) {
				res.addAll(connectLevel4);
			}
		}
		return res;
	}

	private List<List<T>> connectLevel4(T a, T b, T c, T d) {
		Set<T> targets2A = getOrDefault(level2, a, new HashSet<>());;
		Set<T> targets2B = getOrDefault(level2, b, new HashSet<>());;
		Set<T> targets2C = getOrDefault(level2, c, new HashSet<>());;
		Set<T> targets2D = getOrDefault(level2, d, new HashSet<>());;

		Set<T> intersectABCD = new HashSet<>(targets2A);
		intersectABCD.retainAll(targets2B);
		intersectABCD.retainAll(targets2C);
		intersectABCD.retainAll(targets2D);

		if (intersectABCD.isEmpty()) {
			return asList();
		}
		List<List<T>> res = new LinkedList<>();
		for (T e : intersectABCD) {
			List<T> s4 = sortedList(asList(a, b, c, d, e));
			res.add(s4);
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

	private List<T> sortedList(List<T> res) {
		Collections.sort(res);
		return res;
	}
	
}
