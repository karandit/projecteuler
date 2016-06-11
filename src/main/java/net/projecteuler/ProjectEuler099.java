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
	
	private static class BigN {
		private final double base;
		private final double exp;
		
		public BigN(double base, double exp) {
			this.base = base;
			this.exp = exp;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(base);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(exp);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BigN other = (BigN) obj;
			if (Double.doubleToLongBits(base) != Double.doubleToLongBits(other.base))
				return false;
			if (Double.doubleToLongBits(exp) != Double.doubleToLongBits(other.exp))
				return false;
			return true;
		}

		@Override public String toString() { return base + " ^ " + exp; }
	
	}
	
	/**
	 * Sorts in descending order to be easy to get the biggest as being the first.
	 */
	private static enum BigNComparator implements Comparator<BigN> {

		INSTANCE;
	
		@Override
		public int compare(BigN o1, BigN o2) {
			double e = (o1.exp / o2.exp) - (log10(o2.base) / log10(o1.base));
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
		Stream<BigN> bigNs = readLinesFromFile("ProjectEuler_099.txt")
			.stream()
			.map(line -> {
				String[] split = line.split(",");
				return new BigN(parseDouble(split[0]), parseDouble(split[1]));
			});
		Stream<Integer> ints = IntStream.iterate(1, i -> i + 1).boxed();
		
		return zip(bigNs, ints, (bigN, index) -> new Tuple<>(bigN, index))
			.sorted((tuple1, tuple2) ->  BigNComparator.INSTANCE.compare(tuple1.getA(), tuple2.getA()))
			.findFirst().get()
			.getB();
	}
	
}
