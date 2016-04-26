package net.projecteuler;

import org.junit.Test;

import static net.projecteuler.ProjectEuler019.solve_019;
import static net.projecteuler.ProjectEuler023.solve_023;
import static net.projecteuler.ProjectEuler026.solve_026;
import static net.projecteuler.ProjectEuler027.solve_027;
import static net.projecteuler.ProjectEuler040.solve_040;
import static net.projecteuler.ProjectEuler046.solve_046;
import static net.projecteuler.ProjectEuler047.solve_047;
import static net.projecteuler.ProjectEuler050.solve_050;
import static net.projecteuler.ProjectEuler069.solve_069;
import static net.projecteuler.ProjectEuler070.solve_070;
import static net.projecteuler.ProjectEuler071.solve_071;
import static net.projecteuler.ProjectEuler072.solve_072;
import static net.projecteuler.ProjectEuler074.solve_074;
import static net.projecteuler.ProjectEuler092.solve_092;
import static net.projecteuler.ProjectEuler119.solve_119;
import static net.projecteuler.ProjectEuler179.solve_179;
import static org.junit.Assert.assertEquals;

public class SolutionsTest {

	@Test public void shouldSolve_019() { assertEquals(171, solve_019()); }
	@Test public void shouldSolve_023() { assertEquals(4179871, solve_023()); }
	@Test public void shouldSolve_026() { assertEquals(983, solve_026()); }
	@Test public void shouldSolve_027() { assertEquals(-59231, solve_027()); }
	@Test public void shouldSolve_040() { assertEquals(210, solve_040()); }
	@Test public void shouldSolve_046() { assertEquals(5777, solve_046()); }
	@Test public void shouldSolve_047() { assertEquals(134043, solve_047()); }
	@Test public void shouldSolve_050() { assertEquals(997651, solve_050()); }
	//TODO 63 is missing
	@Test public void shouldSolve_069() { assertEquals(510510, solve_069()); }
	@Test public void shouldSolve_070() { assertEquals(8319823, solve_070()); }
	@Test public void shouldSolve_071() { assertEquals(428570, solve_071()); }
	@Test public void shouldSolve_072() { assertEquals(303963552391L, solve_072()); }
	@Test public void shouldSolve_074() { assertEquals(402, solve_074()); }
	@Test public void shouldSolve_092() { assertEquals(8581146, solve_092()); }
	@Test public void shouldSolve_119() { assertEquals(248155780267521L, solve_119()); }
	@Test public void shouldSolve_179() { assertEquals(986262, solve_179()); }

}