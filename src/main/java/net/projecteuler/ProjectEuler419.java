package net.projecteuler;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.nathanieljohnston.com/2010/10/a-derivation-of-conways-degree-71-look-and-say-polynomial/
 */
public class ProjectEuler419 {
	private final static int MOD = 2^30;
	
	private final static Map<Integer, List<Integer>> nextMap = new HashMap<>();
	private final static Map<Integer, String> strings = new HashMap<>();
	private final static int[][] abc = new int[3][];
	
	static {
		nextMap.put(1, asList(63));
		nextMap.put(2, asList(64, 62));
		nextMap.put(3, asList(65));
		nextMap.put(4, asList(66));
		nextMap.put(5, asList(68));
		nextMap.put(6, asList(69));
		nextMap.put(7, asList(84, 55));
		nextMap.put(8, asList(70));
		nextMap.put(9, asList(71));
		nextMap.put(10, asList(76));
		nextMap.put(11, asList(77));
		nextMap.put(12, asList(82));
		nextMap.put(13, asList(78));
		nextMap.put(14, asList(79));
		nextMap.put(15, asList(80));
		nextMap.put(16, asList(81, 29, 91));
		nextMap.put(17, asList(81, 29, 90));
		nextMap.put(18, asList(81, 30));
		nextMap.put(19, asList(75, 29, 92));
		nextMap.put(20, asList(75, 32));
		nextMap.put(21, asList(72));
		nextMap.put(22, asList(73));
		nextMap.put(23, asList(74));
		nextMap.put(24, asList(83));
		nextMap.put(25, asList(86));
		nextMap.put(26, asList(87));
		nextMap.put(27, asList(88));
		nextMap.put(28, asList(89, 92));
		nextMap.put(29, asList(1));
		nextMap.put(30, asList(3));
		nextMap.put(31, asList(4));
		nextMap.put(32, asList(2, 61, 29, 85));
		nextMap.put(33, asList(5));
		nextMap.put(34, asList(28));
		nextMap.put(35, asList(24, 33, 61, 29, 91));
		nextMap.put(36, asList(24, 33, 61, 29, 90));
		nextMap.put(37, asList(7));
		nextMap.put(38, asList(8));
		nextMap.put(39, asList(9));
		nextMap.put(40, asList(10));
		nextMap.put(41, asList(21));
		nextMap.put(42, asList(22));
		nextMap.put(43, asList(23));
		nextMap.put(44, asList(11));
		nextMap.put(45, asList(19));
		nextMap.put(46, asList(12));
		nextMap.put(47, asList(13));
		nextMap.put(48, asList(14));
		nextMap.put(49, asList(15));
		nextMap.put(50, asList(18));
		nextMap.put(51, asList(16));
		nextMap.put(52, asList(17));
		nextMap.put(53, asList(20));
		nextMap.put(54, asList(6, 61, 29, 92));
		nextMap.put(55, asList(26));
		nextMap.put(56, asList(27));
		nextMap.put(57, asList(25, 29, 92));
		nextMap.put(58, asList(25, 29, 67));
		nextMap.put(59, asList(25, 29, 85));
		nextMap.put(60, asList(25, 29, 68, 61, 29, 89));
		nextMap.put(61, asList(61));
		nextMap.put(62, asList(33));
		nextMap.put(63, asList(40));
		nextMap.put(64, asList(41));
		nextMap.put(65, asList(42));
		nextMap.put(66, asList(43));
		nextMap.put(67, asList(38, 39));
		nextMap.put(68, asList(44));
		nextMap.put(69, asList(48));
		nextMap.put(70, asList(54));
		nextMap.put(71, asList(49));
		nextMap.put(72, asList(50));
		nextMap.put(73, asList(51));
		nextMap.put(74, asList(52));
		nextMap.put(75, asList(47, 38));
		nextMap.put(76, asList(47, 55));
		nextMap.put(77, asList(47, 56));
		nextMap.put(78, asList(47, 57));
		nextMap.put(79, asList(47, 58));
		nextMap.put(80, asList(47, 59));
		nextMap.put(81, asList(47, 60));
		nextMap.put(82, asList(47, 33, 61, 29, 92));
		nextMap.put(83, asList(45));
		nextMap.put(84, asList(46));
		nextMap.put(85, asList(53));
		nextMap.put(86, asList(38, 29, 89));
		nextMap.put(87, asList(38, 30));
		nextMap.put(88, asList(38, 31));
		nextMap.put(89, asList(34));
		nextMap.put(90, asList(36));
		nextMap.put(91, asList(35));
		nextMap.put(92, asList(37));
	
		strings.put(1, "1112");
		strings.put(2, "1112133");
		strings.put(3, "111213322112");
		strings.put(4, "111213322113");
		strings.put(5, "1113");
		strings.put(6, "11131");
		strings.put(7, "111311222112");
		strings.put(8, "111312");
		strings.put(9, "11131221");
		strings.put(10, "1113122112");
		strings.put(11, "1113122113");
		strings.put(12, "11131221131112");
		strings.put(13, "111312211312");
		strings.put(14, "11131221131211");
		strings.put(15, "111312211312113211");
		strings.put(16, "111312211312113221133211322112211213322112");
		strings.put(17, "111312211312113221133211322112211213322113");
		strings.put(18, "11131221131211322113322112");
		strings.put(19, "11131221133112");
		strings.put(20, "1113122113322113111221131221");
		strings.put(21, "11131221222112");
		strings.put(22, "111312212221121123222112");
		strings.put(23, "111312212221121123222113");
		strings.put(24, "11132");
		strings.put(25, "1113222");
		strings.put(26, "1113222112");
		strings.put(27, "1113222113");
		strings.put(28, "11133112");
		strings.put(29, "12");
		strings.put(30, "123222112");
		strings.put(31, "123222113");
		strings.put(32, "12322211331222113112211");
		strings.put(33, "13");
		strings.put(34, "131112");
		strings.put(35, "13112221133211322112211213322112");
		strings.put(36, "13112221133211322112211213322113");
		strings.put(37, "13122112");
		strings.put(38, "132");
		strings.put(39, "13211");
		strings.put(40, "132112");
		strings.put(41, "1321122112");
		strings.put(42, "132112211213322112");
		strings.put(43, "132112211213322113");
		strings.put(44, "132113");
		strings.put(45, "1321131112");
		strings.put(46, "13211312");
		strings.put(47, "1321132");
		strings.put(48, "13211321");
		strings.put(49, "132113212221");
		strings.put(50, "13211321222113222112");
		strings.put(51, "1321132122211322212221121123222112");
		strings.put(52, "1321132122211322212221121123222113");
		strings.put(53, "13211322211312113211");
		strings.put(54, "1321133112");
		strings.put(55, "1322112");
		strings.put(56, "1322113");
		strings.put(57, "13221133112");
		strings.put(58, "1322113312211");
		strings.put(59, "132211331222113112211");
		strings.put(60, "13221133122211332");
		strings.put(61, "22");
		strings.put(62, "3");
		strings.put(63, "3112");
		strings.put(64, "3112112");
		strings.put(65, "31121123222112");
		strings.put(66, "31121123222113");
		strings.put(67, "3112221");
		strings.put(68, "3113");
		strings.put(69, "311311");
		strings.put(70, "31131112");
		strings.put(71, "3113112211");
		strings.put(72, "3113112211322112");
		strings.put(73, "3113112211322112211213322112");
		strings.put(74, "3113112211322112211213322113");
		strings.put(75, "311311222");
		strings.put(76, "311311222112");
		strings.put(77, "311311222113");
		strings.put(78, "3113112221131112");
		strings.put(79, "311311222113111221");
		strings.put(80, "311311222113111221131221");
		strings.put(81, "31131122211311122113222");
		strings.put(82, "3113112221133112");
		strings.put(83, "311312");
		strings.put(84, "31132");
		strings.put(85, "311322113212221");
		strings.put(86, "311332");
		strings.put(87, "3113322112");
		strings.put(88, "3113322113");
		strings.put(89, "312");
		strings.put(90, "312211322212221121123222113");
		strings.put(91, "312211322212221121123222112");
		strings.put(92, "32112");
	
		abc[0] = new int[93];
		abc[1] = new int[93];
		abc[2] = new int[93];
		for (int i = 1; i < 93; i++) {
			int c1 = 0; int c2 = 0; int c3 = 0;
			String s = strings.get(i);
			char[] charArray = s.toCharArray();
			for (int j = 0; j < charArray.length; j++) {
				switch (charArray[j]) {
					case '1': c1++; break;
					case '2': c2++; break;
					case '3': c3++; break;
				}
			}
			abc[0][i] = c1;
			abc[1][i] = c2;
			abc[2][i] = c3;
		}
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
				
		long[] seq = new long[93];
		seq[24] = 1;
		seq[39] = 1;
		
		long x = 8;
		while (x < 1000) {
			System.out.println(x + "\t" + displayOcc(seq));
			seq = stepSeq(seq);
			x++;
		}
		System.out.println(x + " = " + displaySeq(seq));
		
		//--------------------------------------------------------------------------------------------------------------
//		long n = 1;
//		char[] charArray = new char[] {'1'};
//		while (n < 1_000) {
//			charArray = step(charArray);
//			n++;
//		}
//		int c1 = 0;
//		int c2 = 0;
//		int c3 = 0;
//		for (int i = 0; i < charArray.length; i++) {
//			switch (charArray[i]) {
//				case '1': c1++; break;
//				case '2': c2++; break;
//				case '3': c3++; break;
//			}
//		}
//		
//		System.out.println(n + " = " + c1 + "," + c2 + "," + c3);
		System.out.println("Elapsed time: " + ((System.nanoTime() - start) / 1_000_000) + " ms");
	}

	private static String displaySeq(long[] seq) {
		long c1 = 0;
		long c2 = 0;
		long c3 = 0;
		for (int i = 1; i < seq.length; i++) {
			c1 += seq[i] * abc[0][i];
			c2 += seq[i] * abc[1][i];
			c3 += seq[i] * abc[2][i];
		}
		
		return c1 + "," + c2 + "," + c3;
	}

	private static String displayOcc(long[] seq) {
		StringBuilder sb = new StringBuilder();
		int full = 0;
		for (int i = 1; i < seq.length; i++) {
			if (seq[i] != 0) {
				full++;
				sb = sb.append(i).append("=").append(seq[i]).append(", ");
			}
		}
		if (full == 92) {
			sb.insert(0, "FULL");
		}
		return sb.toString();
	}

	private static long[] stepSeq(long[] seq) {
		long[] nextSeq = new long[93];
		for (int i = 1; i < seq.length; i++) {
			long value = seq[i];
			List<Integer> nexts = nextMap.get(i);
			for (Integer next : nexts) {
				nextSeq[next] = (nextSeq[next] + value) % MOD; 
			}
		}
		return nextSeq;
	}

	private static char[] step(char[] charArray) {
		StringBuilder sb = new StringBuilder();
		char c = charArray[0];
		int length = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == c) { 
				length++;
			} else {
				sb = sb.append(length).append(c);
				c = charArray[i];
				length = 1;
			}
		}
		sb = sb.append(length).append(c);
		return sb.toString().toCharArray();
	}

}
