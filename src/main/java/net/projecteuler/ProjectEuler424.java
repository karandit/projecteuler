package net.projecteuler;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectEuler424 {
	
	private static final int A = 65;
	private static int lastLetter = A;

	private static final String KAKURO_001 = 
 "6,X,X,(vCC),(vI),X,X,X,(hH),B,O,(vCA),(vJE),X,(hFE,vD),O,O,O,O,(hA),O,I,(hJC,vB),O,O,(hJC),H,O,O,O,X,X,X,(hJE),O,O,X";

	//-------------------------------- helper classes ------------------------------------------------------------------
	public static class Digit {
		public final String letter;
		public Digit(final String letter) { this.letter = letter; }
		@Override public String toString() { return letter; }
	}
	
	public interface Sum { 
		Rule buildRule(List<Digit> digits);
	}
	
	public static class SimpleSum implements Sum {
		private final Digit digit;
		public SimpleSum(Digit digit) { this.digit = digit; }
		@Override public String toString() { return digit.toString()+ "."; }
		@Override
		public Rule buildRule(List<Digit> digits) {
			Set<Digit> fixedDigits = digits.stream()
					.filter(digit -> digit.letter.charAt(0) >= 'A' && digit.letter.charAt(0) <= 'J')
					.collect(Collectors.toSet());
			if (fixedDigits.size() == 1) {
				return new LessThanRule(digit, fixedDigits.iterator().next());
			}
			
			return null;
		}
	}

	public static class DoubleSum implements Sum {
		private final Digit digit1;
		private final Digit digit2;
		public DoubleSum(Digit digit1, Digit digit2) { this.digit1 = digit1; this.digit2 = digit2; }
		@Override public String toString() { return digit1.toString() + digit2.toString(); }
		@Override
		public Rule buildRule(List<Digit> digits) {
			return new BetweenRule(digit1, digits.size() - 1);
		}
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
		public GrayCell(Optional<? extends Sum> hor, Optional<? extends Sum> ver) {
			this.horSum = hor;
			this.verSum = ver;
		}
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
				Rule digitRule = sum.get().buildRule(digits);
				if (digitRule != null) {
					rules.add(digitRule);
				}
				return rules;
			}
			return null;
		}
	}
	
	public static interface Rule { 
		int getRank();
	}
	
	public static class SumRule implements Rule { 
		private final Sum sum;
		private List<Digit> digits;
		public SumRule(Sum sum, List<Digit> digits) { this.sum = sum; this.digits = digits; }
		@Override public int getRank() { return 3; }
		@Override public String toString() { return "Rule Sum: " + sum + " = " + digits.stream().map(Digit::toString).collect(joining(" + ")); }
	}
	
	public static class LessThanRule implements Rule {
		private final Digit big;
		private final Digit small;
		public LessThanRule(Digit big, Digit small) {
			this.big = big;
			this.small = small;
		}
		@Override public int getRank() { return 2; }
		@Override public String toString() { return "Rule Less Than: " + small + " < " + big; }
	}

	public static class BetweenRule implements Rule {
		private final Digit digit;
		private final int upper;
		public BetweenRule(Digit digit, int upper) {
			this.digit = digit;
			this.upper = upper;
		}
		@Override public int getRank() { return 1; }
		@Override public String toString() { return "Rule Between: 1 <= " + digit + " <= " + upper; }
	}

	//------------------------ main ------------------------------------------------------------------------------------
	public static void main(String[] args) {
		long start = System.nanoTime();
//		System.out.println(Combinatorics.permutations(10).stream().count());
		System.out.println(solve_424());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	private static int solve_424() {
		Cell[][] matrix = buildKakuro(KAKURO_001);
//		printMatrix(matrix);
		List<Rule> rules = buildRules(matrix);
		rules.stream().sorted((a, b) -> a.getRank() - b.getRank()).forEach(System.out::println);
		return 0;
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
