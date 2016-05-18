package net.projecteuler;

import static java.lang.Double.parseDouble;
import static java.lang.Math.log10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProjectEuler099 {
	
	private static class BigN {
		private final double base;
		private final double exp;
		private final int lineNr;
		
		public BigN(double base, double exp, int lineNr) {
			this.base = base;
			this.exp = exp;
			this.lineNr = lineNr;
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

		@Override
		public String toString() {
			return base + " ^ " + exp + " nr: " + lineNr;
		}
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
		try (InputStream is = ProjectEuler099.class.getResourceAsStream("ProjectEuler_099.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			
			int lineNr = 1;
			String line = null;
			List<BigN> values = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				String[] split = line.split(",");
				values.add(new BigN(parseDouble(split[0]), parseDouble(split[1]), lineNr++));
			}
			Collections.sort(values, BigNComparator.INSTANCE);
			return values.get(0).lineNr;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
