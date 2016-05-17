package net.projecteuler.graph;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.projecteuler.graph.Clique;

public class CliqueTest {

	private static final String A = "A";
	private static final String B = "B";
	private static final String C = "C";
	private static final String D = "D";

	private Clique<String> sut;
	
	@Before
	public void setup() {
		sut = new Clique<String>();
	}
	
	@Test
	public void shouldRecognizeHand() {
		assertConnect(A, B, asList());
		assertConnect(B, A, asList(as2(A, B)));
		assertConnect(A, C, asList());
		assertConnect(C, A, asList(as2(A, C)));
		assertConnect(B, C, asList());
		assertConnect(C, B, asList(as2(B, C), as3(A, B, C)));
		assertConnect(A, D, asList());
		assertConnect(D, A, asList(as2(A, D)));
		assertConnect(B, D, asList());
		assertConnect(D, B, asList(as2(B, D), as3(A, B, D)));
		assertConnect(C, D, asList());
		assertConnect(D, C, asList(as2(C, D), as3(A, C, D), as4(A, B, C, D), as3(B, C, D), as4(A, B, C, D)));
	}

	public void assertConnect(String a, String b, List<List<String>> exp) {
		assertEquals(exp, sut.connect(a, b));
	}

	public List<String> as2(String a, String b) { return asList(a, b); }
	public List<String> as3(String a, String b, String c) { return asList(a, b, c); }
	public List<String> as4(String a, String b, String c, String d) { return asList(a, b, c, d); }
}
