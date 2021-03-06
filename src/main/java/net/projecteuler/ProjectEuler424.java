package net.projecteuler;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.rangeClosed;
import static net.projecteuler.util.Combinatorics.permutations;
import static net.projecteuler.util.FileUtils.readLinesFromFile;
import static net.projecteuler.util.Matrix.newMatrix;
import static net.projecteuler.util.Matrix.rotateMatrix;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import net.projecteuler.util.Tuple;

public class ProjectEuler424 {
	
	private static final String[] A_TO_J = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	
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
			if (fixedDigits.size() == 1) {//TODO: actually the sum digit must be greater or equal than any single digit
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

		@Override public List<Rule> buildRules(List<Digit> digits) { return asList(new BetweenRule(digit1, 1, digits.size() - 1)); }
		@Override public int value(Map<String, Integer> sol) { return sol.get(digit1.letter) * 10 + sol.get(digit2.letter); }
	}
	
	public interface Cell {
		boolean isWhite();
		List<Rule> buildRules(boolean isHor, int colIdx, Cell[] cells);
	}

	public static class WhiteCell implements Cell {
		public final Digit digit;
		public WhiteCell(Digit value) { this.digit = value; }
		@Override public String toString() { return ".." + digit.toString() + ".."; }
		@Override public boolean isWhite() { return true; }
		@Override public List<Rule> buildRules(boolean isHor, int colIdx, Cell[] cells) { return emptyList(); }
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
		public List<Rule> buildRules(boolean isHor, int idx, Cell[] cells) {
			Optional<? extends Sum> sum = isHor ? horSum : verSum;
			List<Rule> rules = new LinkedList<>();
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
				rules.add(new SumRule(sum.get(), digits));
				rules.addAll(sum.get().buildRules(digits));
			}
			return rules;
		}
	}

	//-------------------------------- Solution Space ------------------------------------------------------------------
	public static interface Rule {
		int getRank();
		String toString(Map<String, Integer> solution);
		
		boolean check(Map<String, Integer> solution);
		List<Tuple<String, Integer>> solve(Map<String, Integer> solution);
		boolean isStillNeeded(Map<String, Integer> solution);
		Optional<Tuple<String, List<Integer>>> getCandidates(Map<String, Integer> solution);
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
				int othersSum = solved.get(Boolean.TRUE).stream().map(digit -> sol.get(digit.letter)).reduce(0, Integer::sum);
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
			List<Integer> replDigits = digits.stream().filter(d -> sol.containsKey(d.letter)).map(digit -> sol.get(digit.letter)).collect(toList());
			
			boolean allUnique = replDigits.stream().count() == replDigits.stream().distinct().count();
			if (!allUnique) {
				return false;
			}
			boolean allAreUnits = replDigits.stream().allMatch(d -> d > 0 && d <= 9);
			if (!allAreUnits) {
				return false;
			}
			
			boolean allReplaced = digits.stream().allMatch(d -> sol.containsKey(d.letter));
			int sumValue = sum.value(sol);
			if (!allReplaced) {
				Integer actDigitsValue = replDigits.stream().reduce(0, Integer::sum);
				return sumValue >= actDigitsValue;
			}
			
			Integer actDigitsValue = digits.stream().map(digit -> sol.get(digit.letter)).reduce(0, Integer::sum);
			return sumValue == actDigitsValue;
		}

		@Override
		public Optional<Tuple<String, List<Integer>>> getCandidates(Map<String, Integer> sol) {
			Map<Boolean, List<Digit>> solved = digits.stream().collect(partitioningBy(d -> sol.containsKey(d.letter)));
			int othersSum = solved.get(Boolean.TRUE).stream().map(digit -> sol.get(digit.letter)).reduce(0, Integer::sum);
			int sumValue = sum.value(sol) - othersSum;
			
			if (!solved.get(Boolean.FALSE).isEmpty()) {
				Digit lastUnsolved = solved.get(Boolean.FALSE).iterator().next();
				return of(new Tuple<>(lastUnsolved.letter, rangeClosed(0, Math.min(9, sumValue)).mapToObj(i -> i).collect(toList())));
			}
			return empty();
		}
	}
	
	public static class LessThanRule implements Rule {
		private final Digit big;
		private final Digit small;

		public LessThanRule(Digit big, Digit small) { this.big = big; this.small = small; }
		
		@Override public int getRank() { return 2; }
		@Override public String toString() { return "Rule Less Than: " + small + " <= " + big; }
		@Override public String toString(Map<String, Integer> sol) { return "Rule Less Than: " + small.toString(sol) + " <= " + big.toString(sol); }
		@Override public Optional<Tuple<String, List<Integer>>> getCandidates(Map<String, Integer> solution) { return empty(); }

		@Override public List<Tuple<String, Integer>> solve(Map<String, Integer> sol) { return emptyList(); }
		@Override public boolean isStillNeeded(Map<String, Integer> sol) { return !sol.containsKey(small.letter) || !sol.containsKey(big.letter); }

		@Override
		public boolean check(Map<String, Integer> sol) {
			if (sol.containsKey(small.letter) && sol.containsKey(big.letter)) {
				return sol.get(small.letter) <= sol.get(big.letter);
			}
			return true;
		}
	}

	public static class BetweenRule implements Rule {
		private final Digit digit;
		private final int lower;
		private final int upper;
		
		public BetweenRule(Digit digit, int lower, int upper) { this.digit = digit; this.lower = lower; this.upper = upper; }
		
		@Override public int getRank() { return 1; }
		@Override public String toString() { return "Rule Between: " + lower + " <= " + digit + " <= " + upper; }
		@Override public String toString(Map<String, Integer> sol) { return "Rule Between: " + lower + " <= " + digit.toString(sol) + " <= " + upper; }
		@Override public Optional<Tuple<String, List<Integer>>> getCandidates(Map<String, Integer> solution) { return empty(); }

		@Override
		public List<Tuple<String, Integer>> solve(Map<String, Integer> sol) {
			if (!sol.containsKey(digit.letter)) {
				return upper == lower ? asList(new Tuple<>(digit.letter, upper)) : emptyList();
			}
			return emptyList();
		}
		@Override public boolean isStillNeeded(Map<String, Integer> sol) { return !sol.containsKey(digit.letter); }

		@Override
		public boolean check(Map<String, Integer> sol) {
			if (sol.containsKey(digit.letter)) {
				Integer value = sol.get(digit.letter);
				return lower <= value && value <= upper;
			}
			return true;
		}
	}

	//------------------------ Main ------------------------------------------------------------------------------------
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_424());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_424() {
		return readLinesFromFile("ProjectEuler_424.txt")
				.stream().map(kakuro -> solveKakuro(kakuro)).mapToLong(value -> value).sum();
	}
	
	public static long solveKakuro(String kakuro) {
		Tuple<Integer, Cell[][]> parseKakuro = parseKakuro(kakuro);
		final Cell[][] matrix = parseKakuro.getB();
		Integer digitsCnt = parseKakuro.getA();
		List<Rule> allRules = buildRules(matrix);
		
		Map<String, Integer> emptySolution = new HashMap<>();
		Map<String, Integer> seedSolution = allRules.stream()
			.map(rule -> rule.solve(emptySolution))
			.filter(list -> !list.isEmpty())
			.flatMap(list -> list.stream())
			.distinct()
			.collect(toMap(tuple -> tuple.getA(), tuple -> tuple.getB()));

		List<Rule> rules = allRules
				.stream()
			.filter(rule -> rule.isStillNeeded(seedSolution))
			.collect(Collectors.toList());

		List<Integer> freeNumbers = rangeClosed(0, 9)
			.mapToObj(i -> i)
			.filter(i -> !seedSolution.values().contains(i))
			.collect(toList());
		
		List<String> letters = stream(A_TO_J)
			.filter(letter -> !seedSolution.containsKey(letter))
			.collect(toList());

		Map<String, Integer> firstSolution = permutations(freeNumbers.size()).stream()
			.map(perm -> perm.stream().map(i -> freeNumbers.get(i)).collect(toList()))
			.map(numbers -> newSolution(seedSolution, letters, numbers))
			.map(sol -> checkSolution(digitsCnt, 0, sol,  rules))
			.filter(Optional::isPresent)
			.map(opt -> opt.get())
			.findFirst().get();
		return stream(A_TO_J)
			.map(i -> new Long(firstSolution.get(i)))
			.reduce(0L, (acc, v) -> acc * 10 + v);
	}

	private static Optional<Map<String, Integer>> checkSolution(int digitsCnt, final int depth, final Map<String, Integer> aSol, final List<Rule> aRules) {
		 Map<String, Integer> sol = aSol;
		 List<Rule> rules = aRules;

		while (true) {
			 final Map<String, Integer> solCopy = sol;
			boolean allMatch = rules.stream().allMatch(rule -> rule.check(solCopy));
			 if (!allMatch) {
				 return Optional.empty();
			 }
			 if (sol.size() == digitsCnt) {
				 return of(sol); 
			 }
			 rules = rules.stream().filter(rule -> rule.isStillNeeded(solCopy)).collect(toList());
			 
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
			 } else { //backtracking
//				 printSolution(depth, solCopy, rules);
				 Optional<Tuple<String, List<Integer>>> min = rules.stream()
				 .map(rule -> rule.getCandidates(solCopy))
				 .filter(cand -> cand.isPresent())
				 .map(cand -> cand.get())
				 .min((t1, t2) -> t1.getB().size() - t2.getB().size());
				 
				 if (min.isPresent()) {
					 String candLetter = min.get().getA();
					 List<Integer> candidates = min.get().getB();
					 for (Integer cand : candidates) {
						 Map<String, Integer> solR = new HashMap<>(sol);
						 solR.put(candLetter, cand);
						 Optional<Map<String, Integer>> solRes = checkSolution(digitsCnt, depth + 1, solR, rules);
						 if (solRes.isPresent()) {
							 return solRes;
						 }
					 }
				 }
				 return empty();
			 }
		}
	}

	public static void printSolution(int depth, Map<String, Integer> sol, List<Rule> rules) {
		System.out.println(depth + " " + sol);
		rules.forEach(rule -> {
			System.out.println("\t==" + rule);
			System.out.println("\t->" + rule.toString(sol)  + "\t" + rule.check(sol)
			);
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

	private static Tuple<Integer, Cell[][]> parseKakuro(String input) {
		String[] tokens = input.split(",");
		int tokenIdx = 0;
		int size = Integer.parseInt(tokens[tokenIdx++]);
		Cell[][] matrix = newMatrix(size, size, rows -> new Cell[rows][], cols -> new Cell[cols]);
		
		Map<String, Digit> digits = stream(A_TO_J).collect(toMap(x -> x, x -> new Digit(x)));
		char lastChar = 'K';
		String lastLetter = Character.toString(lastChar);
		int digitsCnt = 10;
		for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			Cell[] row = matrix[rowIdx];
			for (int colIdx = 0; colIdx < matrix.length; colIdx++) {
				String token = tokens[tokenIdx++];
				if (token.startsWith("(") && (!token.endsWith(")"))) {
					token += "," + tokens[tokenIdx++];
				}
				
				Tuple<Cell, Boolean> tuple = newCell(token, digits, lastLetter);
				row[colIdx] = tuple.getA();
				if (tuple.getB()) {
					lastChar++;
					digitsCnt++;
					if (lastChar == 'Z' + 1) {
						lastChar = 'a';
					}
					lastLetter = Character.toString(lastChar);
				}
			}
		}
		return new Tuple<Integer, Cell[][]>(digitsCnt, matrix);
	}

	private static Tuple<Cell, Boolean> newCell(String token, Map<String, Digit> digits, String lastLetter) {
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
			case "J": return new Tuple<>(new WhiteCell(digits.get(token)), false);
			case "O": return new Tuple<>(new WhiteCell(new Digit(lastLetter)), true);
			case "X": return new Tuple<>(new GrayCell(empty(), empty()), false);
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
				return new Tuple<>(new GrayCell(hor, ver), false); 
			}
		}
	}

	private static List<Rule> buildRules(Cell[][] matrix) {
		List<Rule> rules = collectRules(matrix, true);
		rules.addAll(collectRules(rotateMatrix(matrix, rows -> new Cell[rows][], cols -> new Cell[cols]), false));
		rules = rules.stream().sorted((a, b) -> a.getRank() - b.getRank()).collect(toList()); 
		return rules;
	}

	private static List<Rule> collectRules(Cell[][] matrix, boolean isHor) {
		List<Rule> res = new LinkedList<>();
		
		for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			Cell[] row = matrix[rowIdx];
			for (int colIdx = 0; colIdx < matrix[rowIdx].length; colIdx++) {
				List<Rule> rules = row[colIdx].buildRules(isHor, colIdx, row);
				res.addAll(rules);
			}
		}
		return res;
	}

}
