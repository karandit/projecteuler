package net.projecteuler;

import static java.util.stream.Stream.iterate;

import java.math.BigInteger;

import net.projecteuler.util.Triple;
import net.projecteuler.util.Util;

public class ProjectEuler065 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(solve_065());
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	public static long solve_065() {
//		BigInteger n1 = new BigInteger("2");
//		BigInteger n2 = new BigInteger("3");
//
//		for (int i = 3; i <= 100; i++) {
//			int k = (i % 3 != 0) ? 1 : ( i / 3 * 2);
//			
//			BigInteger kBig = new BigInteger(Integer.toString(k));
//			BigInteger n3 = n1.add(n2.multiply(kBig));
//			n1 = n2;
//			n2 = n3;
//		}
//		System.out.println(n2);
//		return Util.sumOfDigits(n2.toString());
		
		
		BigInteger res = iterate(new Triple<>(new BigInteger("2"), new BigInteger("3"), 3), 
				triple -> {
					BigInteger n1 = triple.getA();
					BigInteger n2 = triple.getB();
					int step = triple.getC();
					
					int k = (step % 3 != 0) ? 1 : ( step / 3 * 2);
					BigInteger kBig = new BigInteger(Integer.toString(k));

					return new Triple<>(n2, n1.add(n2.multiply(kBig)), step + 1);
				})
		.limit(99)
//		.peek(System.out::println)
		.reduce((acc, x) -> x)
		.get().getB();
		
		return Util.sumOfDigits(res.toString());
	}

}
