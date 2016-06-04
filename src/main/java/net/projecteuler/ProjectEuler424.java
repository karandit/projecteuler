package net.projecteuler;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static net.projecteuler.util.Combinatorics.permutations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import net.projecteuler.util.Tuple;

public class ProjectEuler424 {
	
	private static final int A = 65;
	private static int lastLetter = A;

	private static final String KAKURO_001 = 
 "6,X,X,(vCC),(vI),X,X,X,(hH),B,O,(vCA),(vJE),X,(hFE,vD),O,O,O,O,(hA),O,I,(hJC,vB),O,O,(hJC),H,O,O,O,X,X,X,(hJE),O,O,X";

	//-------------------------------- Problem Space -------------------------------------------------------------------
	public static class Digit {
		public final String letter;
		
		public Digit(final String letter) { this.letter = letter; }
		
		@Override public String toString() { return letter; }
		public String toString(Map<String, Integer> sol) { return sol.containsKey(letter) ? sol.get(letter).toString() : letter; }
	}
	
	public interface Sum {
		String toString(Map<String, Integer> sol);
		List<Rule> buildRules(List<Digit> digits);
		int value(Map<String, Integer> sol);
	}
	
	public static class SimpleSum implements Sum {

		private final Digit digit;
		
		public SimpleSum(Digit digit) { this.digit = digit; }
		
		@Override public String toString() { return digit.toString()+ "."; }
		@Override public String toString(Map<String, Integer> sol) { return digit.toString(sol); }
		@Override
		public List<Rule> buildRules(List<Digit> digits) {
			List<Rule> rules = new LinkedList<>();
			if (digits.size() > 1) {
				rules.add(new BetweenRule(digit, 1, 9)); //it can't be zero
			}
			
			Set<Digit> fixedDigits = digits.stream()
					.filter(digit -> digit.letter.charAt(0) >= 'A' && digit.letter.charAt(0) <= 'J')
					.collect(Collectors.toSet());
			if (fixedDigits.size() == 1) {//TODO: actually the digit must be greater or equal thatn all single digits
				rules.add(new LessThanRule(digit, fixedDigits.iterator().next()));
			}
			
			return rules;
		}
		@Override public int value(Map<String, Integer> sol) { return sol.get(digit.letter); }
	}

	public static class DoubleSum implements Sum {
		private final Digit digit1;
		private final Digit digit2;

		public DoubleSum(Digit digit1, Digit digit2) { this.digit1 = digit1; this.digit2 = digit2; }
		
		@Override public String toString() { return digit1.toString() + digit2.toString(); }
		@Override public String toString(Map<String, Integer> sol) { return digit1.toString(sol) + digit2.toString(sol); }

		@Override
		public List<Rule> buildRules(List<Digit> digits) {
			return asList(new BetweenRule(digit1, 1, digits.size() - 1));
		}

		@Override public int value(Map<String, Integer> sol) { return sol.get(digit1.letter) * 10 + sol.get(digit2.letter); }
	}
	
	public interface Cell {
		boolean isWhite();
		List<Rule> buildRule(boolean isHor, int colIdx, Cell[] cells);
	}

	public static class WhiteCell implements Cell {
		public final Digit digit;
		public WhiteCell(Digit value) { this.digit = value; }
		@Override public String toString() { return ".." + digit.toString() + ".."; }
		@Override public boolean isWhite() { return true; }
		@Override
		public List<Rule> buildRule(boolean isHor, int colIdx, Cell[] cells) {
			return null;
		}
	}
	
	public static class GrayCell implements Cell {
		private Optional<? extends Sum> horSum;
		private Optional<? extends Sum> verSum;
		
		public GrayCell(Optional<? extends Sum> hor, Optional<? extends Sum> ver) { this.horSum = hor; this.verSum = ver; }
		
		@Override public boolean isWhite() { return false; }
		@Override
		public String toString() {
			return !horSum.isPresent() && !verSum.isPresent()
					? "....."
					: ((verSum.isPresent() ? verSum.get() : "..")  + "\\" + (horSum.isPresent() ? horSum.get() : ".."));
		}

		@Override
		public List<Rule> buildRule(boolean isHor, int idx, Cell[] cells) {
			Optional<? extends Sum> sum = isHor ? horSum : verSum;
			if (sum.isPresent()) {
				List<Digit> digits = new LinkedList<>();
				int i = idx + 1;
				while (i < cells.length) {
					if (cells[i] instanceof WhiteCell) {
						digits.add(((WhiteCell) cells[i]).digit);
					} else {
						break;
					}
					i++;
				}
				List<Rule> rules = new LinkedList<>();
				rules.add(new SumRule(sum.get(), digits));
				List<Rule> digitRules = sum.get().buildRules(digits);
				if (digitRules != null) {
					rules.addAll(digitRules);
				}
				return rules;
			}
			return null;
		}
	}

	//-------------------------------- Solution Space ------------------------------------------------------------------
	public static interface Rule { 
		int getRank();
		String toString(Map<String, Integer> solution);
		
		boolean check(Map<String, Integer> solution);
		List<Tuple<String, Integer>> solve(Map<String, Integer> solution);
		boolean isStillNeeded(Map<String, Integer> solution);
	}
	
	public static class SumRule implements Rule { 
		private final Sum sum;
		private List<Digit> digits;
		
		public SumRule(Sum sum, List<Digit> digits) { this.sum = sum; this.digits = digits; }
		
		@Override public int getRank() { return 3; }
		@Override public String toString() { return "Rule Sum: " + sum + " = " + digits.stream().map(Digit::toString).collect(joining(" + ")); }
		@Override public String toString(Map<String, Integer> sol) { return "Rule Sum: " + sum.toString(sol) + " = " + digits.stream().map(d -> d.toString(sol)).collect(joining(" + ")); }
		
		@Override
		public List<Tuple<String, Integer>> solve(Map<String, Integer> sol) {
			Map<Boolean, List<Digit>> solved = digits.stream().collect(partitioningBy(d -> sol.containsKey(d.letter)));
			if (solved.get(Boolean.FALSE).size() == 1) {
				Digit lastUnsolved = solved.get(Boolean.FALSE).iterator().next();
				int othersSum = solved.get(Boolean.TRUE).stream().map(digit -> sol.get(digit.letter)).reduce(0, (a, b) -> a + b);
				return asList(new Tuple<>(lastUnsolved.letter, sum.value(sol) - othersSum));
			}
			return emptyList();
		}

		@Override
		public boolean isStillNeeded(Map<String, Integer> sol) {
			return digits.stream().anyMatch(d -> !sol.containsKey(d.letter));
		}

		@Override
		public boolean check(Map<String, Integer> sol) {
			boolean allReplaced = digits.stream().allMatch(d -> sol.containsKey(d.letter));
			int sumValue = sum.value(sol);
			if (!allReplaced) {
				Integer actDigitsValue = digits.stream().filter(d -> sol.containsKey(d.letter)).map(digit -> sol.get(digit.letter)).reduce(0, (a, b) -> a+ b);
				return sumValue >= actDigitsValue;
			}
			Integer actDigitsValue = digits.stream().map(digit -> sol.get(digit.letter)).reduce(0, (a, b) -> a+ b);
			return sumValue == actDigitsValue;
		}
	}
	
	public static class LessThanRule implements Rule {
		private final Digit big;
		private final Digit small;

		public LessThanRule(Digit big, Digit small) { this.big = big; this.small = small; }
		
		@Override public int getRank() { return 2; }
		@Override public String toString() { return "Rule Less Than: " + small + " <= " + big; }
		@Override public String toString(Map<String, Integer> sol) { return "Rule Less Than: " + small.toString(sol) + " <= " + big.toString(sol); }

		@Override public List<Tuple<String, Integer>> solve(Map<String, Integer> sol) { return emptyList(); }
		@Override public boolean isStillNeeded(Map<String, Integer> sol) { return !sol.containsKey(small.letter) || !sol.containsKey(big.letter); }
		@Override public boolean check(Map<String, Integer> sol) { return sol.get(small.letter) <= sol.get(big.letter); }
	}

	public static class BetweenRule implements Rule {
		private final Digit digit;
		private final int lower;
		private final int upper;
		
		public BetweenRule(Digit digit, int lower, int upper) { this.digit = digit; this.lower = lower; this.upper = upper; }
		
		@Override public int getRank() { return 1; }
		@Override public String toString() { return "Rule Between: " + lower + " <= " + digit + " <= " + upper; }
		@Override public String toString(Map<String, Integer> sol) { return "Rule Between: " + lower + " <= " + digit.toString(sol) + " <= " + upper; }

		@Override public List<Tuple<String, Integer>> solve(Map<String, Integer> sol) { return upper == lower ? asList(new Tuple<>(digit.letter, upper)) : emptyList(); }
		@Override public boolean isStillNeeded(Map<String, Integer> sol) { return !sol.containsKey(digit.letter); }
		@Override public boolean check(Map<String, Integer> sol) { Integer value = sol.get(digit.letter); return lower <= value && value <= upper; }
	}

	//------------------------ Main ------------------------------------------------------------------------------------
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_424());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	private static int solve_424() {
		Cell[][] matrix = buildKakuro(KAKURO_001);
//		printMatrix(matrix);
		List<Rule> allRules = buildRules(matrix);
		allRules = allRules.stream().sorted((a, b) -> a.getRank() - b.getRank()).collect(toList()); 
		
//		System.out.println("----------------Orig rules");
//		allRules.forEach(System.out::println);
		
		Map<String, Integer> origSolution = new HashMap<>();
		Map<String, Integer> newSolution = allRules.stream()
			.map(rule -> rule.solve(origSolution))
			.filter(list -> !list.isEmpty())
			.flatMap(list -> list.stream())
			.distinct()
			.collect(toMap(tuple -> tuple.getA(), tuple -> tuple.getB()));

//		System.out.println("----------------New solution");
//		newSolution.entrySet().forEach(System.out::println);
		
//		System.out.println("----------------New rules");
		List<Rule> rules = allRules.stream()
			.filter(rule -> rule.isStillNeeded(newSolution))
			.collect(Collectors.toList());
		
		//---------- backtracking
		List<Integer> freeNumbers = IntStream.rangeClosed(0, 9)
			.mapToObj(i -> i)
			.filter(i -> !newSolution.values().contains(i))
			.collect(toList());
		
		List<String> letters = IntStream.rangeClosed(65, 74)
			.mapToObj(i -> Character.toString((char) i))
			.filter(letter -> !newSolution.containsKey(letter))
			.collect(toList());
		
		Stream<Tuple<Map<String, Integer>, Optional<List<Rule>>>> res = permutations(freeNumbers).stream()
			.map(numbers -> newSolution(newSolution, letters, numbers))
			.map(sol -> new Tuple<Map<String, Integer>, Optional<List<Rule>>>(sol, checkSolution(0, sol,  rules)))
			.filter(tuple -> tuple.getB().isPresent())
//			.limit(1)
			;
			
		int[] cnt = new int[] {0};
		res.forEach(tuple -> {
			printSolution(tuple.getA(), tuple.getB().get());
			cnt[0]++;
		});
			
		System.out.println("Cnt " + cnt[0]);
		return 0;
	}

	private static Optional<List<Rule>> checkSolution(final int depth, final Map<String, Integer> aSol, final List<Rule> aRules) {
		 Map<String, Integer> sol = aSol;
		 List<Rule> rules = aRules;

		while (true) {
			 final Map<String, Integer> solCopy = sol;

			boolean allMatch = rules.stream().allMatch(rule -> rule.check(solCopy));
			 if (!allMatch) { 
				 return Optional.empty();
			 }
			 
			 Map<String, List<Tuple<String, Integer>>> newSolGroupedByLetters = rules.stream()
					.map(rule -> rule.solve(solCopy))
					.filter(list -> !list.isEmpty())
					.flatMap(list -> list.stream())
					.distinct()
					.collect(groupingBy(tuple -> tuple.getA()));
			 boolean allAreNonConflicting = newSolGroupedByLetters.values().stream().allMatch(list -> list.size() == 1);
			 if (!allAreNonConflicting) {
				 return Optional.empty();
			 }
			 
			 if (!newSolGroupedByLetters.isEmpty()) {
				 sol = new HashMap<>(sol);
				 sol.putAll(newSolGroupedByLetters.values()
						 .stream()
						 .map(listTuples -> listTuples.get(0))
						 .collect(toMap(t -> t.getA(), t -> t.getB())));
				 final Map<String, Integer> solCopy2 = sol; 
				 rules = rules.stream().filter(rule -> rule.isStillNeeded(solCopy2)).collect(toList());
			 } else {
				 return Optional.of(rules); //TODO: bakctracking
			 }
		}
	}

	private static void printSolution(Map<String, Integer> sol, List<Rule> rules) {
		System.out.println(sol);
		rules.forEach(rule -> {
			System.out.println("\t==" + rule);
			System.out.println("\t->" + rule.toString(sol) + "\t" + rule.check(sol));
		});
	}

	private static Map<String, Integer> newSolution(Map<String, Integer> origSolution , List<String> letters, List<Integer> numbers) {
		Map<String, Integer> solution = new HashMap<>(origSolution);
		Iterator<String> letterIt = letters.iterator();
		Iterator<Integer> numberIt = numbers.iterator();
		while (letterIt.hasNext()) {
			solution.put(letterIt.next(), numberIt.next());
		}
		return solution;
	}

	private static Cell[][] buildKakuro(String input) {
		String[] tokens = input.split(",");
		int tokenIdx = 0;
		int size = Integer.parseInt(tokens[tokenIdx++]);
		Cell[][] matrix = buildMatrix(size);
		
		Map<String, Digit> digits = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			String letter = Character.toString((char)(lastLetter++));
			digits.put(letter, new Digit(letter));
		}
		
		for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			Cell[] row = matrix[rowIdx];
			for (int colIdx = 0; colIdx < matrix.length; colIdx++) {
				String token = tokens[tokenIdx++];
				if (token.startsWith("(") && (!token.endsWith(")"))) {
					token += "," + tokens[tokenIdx++];
				}
				row[colIdx] = newCell(token, digits);
			}
		}
		return matrix;
	}

	private static Cell newCell(String token, Map<String, Digit> digits) {
		switch (token) {
			case "A": 
			case "B": 
			case "C": 
			case "D": 
			case "E": 
			case "F": 
			case "G": 
			case "H": 
			case "I": 
			case "J": return new WhiteCell(digits.get(token));
			case "O": return new WhiteCell(new Digit(Character.toString((char)(lastLetter++))));
			case "X": return new GrayCell(empty(), empty());
			default: {
				String[] splits = token.substring(1, token.length() - 1).split(",");
				Optional<Sum> hor = empty();
				Optional<Sum> ver = empty();
				for (String split : splits) {
					String dir = split.substring(0, 1);
					String noVH = split.substring(1);
					Sum sum = noVH.length() == 1 
							? new SimpleSum(digits.get(noVH.substring(0)))
							: new DoubleSum(digits.get(noVH.substring(0, 1)), digits.get(noVH.substring(1, 2)));
					if (dir.equals("h")) {
						hor = of(sum);
					} else if (dir.equals("v")) {
						ver = of(sum);
					}
				}
				return new GrayCell(hor, ver); 
			}
		}
	}

	private static List<Rule> buildRules(Cell[][] matrix) {
		List<Rule> rules = collectRules(matrix, true);
		rules.addAll(collectRules(rotateMatrix(matrix), false));
		return rules;
	}

	public static List<Rule> collectRules(Cell[][] matrix, boolean isHor) {
		List<Rule> res = new LinkedList<>();
		
		for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			Cell[] row = matrix[rowIdx];
			for (int colIdx = 0; colIdx < matrix[rowIdx].length; colIdx++) {
				List<Rule> rules = row[colIdx].buildRule(isHor, colIdx, row);
				if (rules != null) {
					res.addAll(rules);
				}
			}
		}
		return res;
	}

	private static Cell[][] rotateMatrix(Cell[][] matrix) {
		Cell[][] res = new Cell[matrix.length][];
		for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			res[rowIdx] = new Cell[matrix.length];
			for (int colIdx = 0; colIdx < matrix.length; colIdx++) {
				res[rowIdx][colIdx] = matrix[colIdx][rowIdx];
			}
		}
		return res;
	}

	private static Cell[][] buildMatrix(int size) {
		Cell[][] matrix = new Cell[size][];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new Cell[size];
		}
		return matrix;
	}

	public static void printMatrix(Cell[][] matrix) {
		for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			for (int colIdx = 0; colIdx < matrix.length; colIdx++) {
				System.out.print(matrix[rowIdx][colIdx] + " ");
			}
			System.out.println();
		}
	}

}
