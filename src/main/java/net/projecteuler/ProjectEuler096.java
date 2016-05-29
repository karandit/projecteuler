package net.projecteuler;

import static java.util.Optional.empty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import net.projecteuler.util.Tuple;

public class ProjectEuler096 {
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_096());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}
		
	public static int solve_096() {
		int[][] inp = null;
		List<String> lines = readWordsFromFile("ProjectEuler_096.txt");
		int lineIdx = 0;
		int sum = 0;
		for (String line : lines) {
			int i = lineIdx % 10;
			if (i == 0) {
				inp = new int[9][];
			} else {
				inp[i - 1] = line.chars().map(x -> x - 48).toArray();
			}
			if (i == 9) {
				sum += sudoku(inp).get();
			}
			lineIdx++;
		}
		return sum;
	}

	private static List<String> readWordsFromFile(String fileName) {
		try (InputStream is = ProjectEuler098.class.getResourceAsStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
				
			List<String> lines = new LinkedList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
					lines.add(line);
			}
			return lines;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static Optional<Integer> sudoku(int[][] inp) {
		boolean[][][] used = new boolean[9][][];
		for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
			used[rowIdx] = new boolean[9][];
			for (int colIdx = 0; colIdx < 9; colIdx++) {
				used[rowIdx][colIdx] = new boolean[9];
			}
		}
		int found = 0;
		for (int rowIdx = 0; rowIdx < inp.length; rowIdx++) {
			int[] row = inp[rowIdx];
			for (int colIdx = 0; colIdx < row.length; colIdx++) {
				int value = row[colIdx];
				if (value != 0) {
					markAsUsed(used, rowIdx, colIdx, value - 1);
					found++;
				}
			}
		}
		while (found < 81) {
			List<Tuple<Tuple<Integer, Integer>, Set<Integer>>> coordCandidates = new ArrayList<>();
			for (int rowIdx = 0; rowIdx < inp.length; rowIdx++) {
				for (int colIdx = 0; colIdx < inp[rowIdx].length; colIdx++) {
					if (inp[rowIdx][colIdx] == 0) {
						Set<Integer> candidates = candidates(used[rowIdx][colIdx]);
						Tuple<Integer, Integer> coord = new Tuple<Integer, Integer>(rowIdx, colIdx);
						if (candidates.isEmpty()) {
							return empty();
						}
						coordCandidates.add(new Tuple<>(coord, candidates));
					}
				}
			}
			if (coordCandidates.isEmpty()) {
				return empty();
			}
			coordCandidates.sort((a, b) -> a.getB().size() - b.getB().size());
			boolean foundUnique = false;
			for (Tuple<Tuple<Integer, Integer>, Set<Integer>> tuple : coordCandidates) { 
				int rowIdx = tuple.getA().getA();
				int colIdx = tuple.getA().getB();
				Set<Integer> candidates = tuple.getB();
				if (candidates.size() == 1) {
					int candidate = candidates.iterator().next();
					if (!setValue(inp, new Tuple<>(rowIdx, colIdx), candidate)) {
						return empty();
					}
					markAsUsed(used, rowIdx, colIdx, candidate - 1);
					foundUnique = true;
					found++;
				}
			}
			if (!foundUnique) { //backtracking
				Tuple<Tuple<Integer, Integer>, Set<Integer>> tuple = coordCandidates.get(0);
				int rowIdx = tuple.getA().getA();
				int colIdx = tuple.getA().getB();
				Set<Integer> candidates = tuple.getB();
				for (Integer candidate : candidates) {
					int[][] clone = copyMatrix(inp);
					if (!setValue(clone, new Tuple<>(rowIdx, colIdx), candidate)) {
						return empty();
					}
					Optional<Integer> res = sudoku(clone);
					if (res.isPresent()) {
						return res;
					}
				}
				return empty();
			}
		}
		return Optional.of(inp[0][0] * 100 + inp[0][1] * 10 + inp[0][2]);
	}

	private static void markAsUsed(boolean[][][] used, int rowIdx, int colIdx, int value) {
		for (int i = 0; i < 9; i++) {
			used[rowIdx][i][value] = true;
			used[i][colIdx][value] = true;
		}
		int topLeftRow = (rowIdx / 3) * 3;
		int topLeftCol = (colIdx / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int ii = 0; ii < 3; ii++) {
				used[topLeftRow + i][topLeftCol + ii][value] = true;
			}
		}
	}

	private static Set<Integer> candidates(boolean[] candidates) {
		Set<Integer> cand = new HashSet<>();
		for (int i = 0; i < candidates.length; i++) {
			if (!candidates[i]) {
				cand.add(i + 1);
			}
		}
		return cand;
	}
	
	private static int[][] copyMatrix(int[][] arr) {
		int[][] out = new int[arr.length][];
		for (int rowIdx = 0; rowIdx < arr.length; rowIdx++) {
			int[] row = arr[rowIdx];
			out[rowIdx] = new int[row.length];
			System.arraycopy(row, 0, out[rowIdx], 0, row.length);
		}
		return out;
	}

	private static boolean setValue(int[][] arr, Tuple<Integer, Integer> coord, int value) {
		int rowIdx = coord.getA();
		int colIdx = coord.getB();
		for (int i = 0; i < arr.length; i++) {
			if (arr[rowIdx][i] == value) {
				return false;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][colIdx] == value) {
				return false;
			}
		}
		int topLeftRow = (rowIdx / 3) * 3;
		int topLeftCol = (colIdx / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int ii = 0; ii < 3; ii++) {
				if (arr[topLeftRow + i][topLeftCol + ii] == value) {
					return false;
				}
			}
		}
		arr[rowIdx][colIdx] = value;
		return true;
	}
}
