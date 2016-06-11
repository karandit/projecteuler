package net.projecteuler;

import static java.lang.Double.parseDouble;
import static java.lang.Math.log10;
import static net.projecteuler.util.FileUtils.readLinesFromFile;
import static net.projecteuler.util.StreamUtils.zip;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import net.projecteuler.util.Tuple;

public class ProjectEuler099 {
	
	/**
	 * Sorts in descending order to be easy to get the biggest as being the first.
	 */
	private static enum BigNComparator implements Comparator<Tuple<Double, Double>> {

		INSTANCE;
	
		@Override
		public int compare(Tuple<Double, Double> o1, Tuple<Double, Double> o2) {
			double e = (o1.getB() / o2.getB()) - (log10(o2.getA()) / log10(o1.getA()));
			if (e > 0.0) {
				return -1;
			} else if (e < 0.0) {
				return 1;
			}
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_099());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static int solve_099() {
		Stream<Tuple<Double, Double>> bigNs = readLinesFromFile("ProjectEuler_099.txt")
			.stream()
			.map(line -> {
				String[] split = line.split(",");
				return new Tuple<>(parseDouble(split[0]), parseDouble(split[1]));
			});
		Stream<Integer> ints = IntStream.iterate(1, i -> i + 1).boxed();
		
		return zip(bigNs, ints, (bigN, index) -> new Tuple<Tuple<Double, Double>, Integer>(bigN, index))
			.sorted((tuple1, tuple2) ->  BigNComparator.INSTANCE.compare(tuple1.getA(), tuple2.getA()))
			.findFirst().get()
			.getB();
	}
	
}
