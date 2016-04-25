package net.projecteuler;

import org.junit.Test;

import static net.projecteuler.ProjectEuler019.solve_019;
import static org.junit.Assert.assertEquals;

public class SolutionsTest {

	@Test public void shouldSolve_019() { assertEquals(171, solve_019()); }
}
