package net.projecteuler;

import static java.util.stream.IntStream.rangeClosed;

import net.projecteuler.util.Tuple;

public class ProjectEuler085 {

	public static void main(String args[]) {
		long start = System.nanoTime();
		System.out.println(solve_085());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_085_stream() {
		return rangeClosed(1, 200)
		.mapToObj(x -> x)
		.flatMap(rows -> rangeClosed(1, 200).mapToObj(cols -> new Tuple<>(sumOfRects(rows, cols), rows * cols)))
		.filter(tuple -> tuple.getA() < 2_000_000)
		.max((tuple1, tuple2) -> tuple1.getA() - tuple2.getA())
		.get().getB();
	}
	
	public static int solve_085() {
		int delta = 2_000_000;
		int minRows = 0;
		int minCols = 0;
		for (int rows = 1; rows <= 200; rows++) {
			for (int cols = 1; cols <= 200; cols++) {
				int sumOfRects = sumOfRects(rows, cols);
				if (sumOfRects < 2_000_000 && 2_000_000 - sumOfRects < delta) {
						delta = 2_000_000 - sumOfRects;
						minRows = rows;
						minCols = cols;
				}
			}
		}
		return minRows * minCols;
	}

	public static int sumOfRects(int rows, int cols) {
		int sum = 0;
		for (int x = 1; x <= rows; x++) {
			for (int y = 1; y <= cols; y++) {
				sum += (rows - x + 1) * (cols - y + 1);
			}
		}
		return sum;
	}

}
