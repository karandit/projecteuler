package net.projecteuler;

import org.junit.Test;

import static net.projecteuler.ProjectEuler001.solve_001;
import static net.projecteuler.ProjectEuler019.solve_019;
import static net.projecteuler.ProjectEuler023.solve_023;
import static net.projecteuler.ProjectEuler026.solve_026;
import static net.projecteuler.ProjectEuler027.solve_027;
import static net.projecteuler.ProjectEuler040.solve_040;
import static net.projecteuler.ProjectEuler046.solve_046;
import static net.projecteuler.ProjectEuler047.solve_047;
import static net.projecteuler.ProjectEuler050.solve_050;
import static net.projecteuler.ProjectEuler051.solve_051;
import static net.projecteuler.ProjectEuler053.solve_053;
import static net.projecteuler.ProjectEuler059.solve_059;
import static net.projecteuler.ProjectEuler060.solve_060;
import static net.projecteuler.ProjectEuler062.solve_062;
import static net.projecteuler.ProjectEuler069.solve_069;
import static net.projecteuler.ProjectEuler070.solve_070;
import static net.projecteuler.ProjectEuler071.solve_071;
import static net.projecteuler.ProjectEuler072.solve_072;
import static net.projecteuler.ProjectEuler074.solve_074;
import static net.projecteuler.ProjectEuler092.solve_092;
import static net.projecteuler.ProjectEuler097.solve_097;
import static net.projecteuler.ProjectEuler099.solve_099;
import static net.projecteuler.ProjectEuler119.solve_119;
import static net.projecteuler.ProjectEuler179.solve_179;
import static net.projecteuler.ProjectEuler206.solve_206;
import static org.junit.Assert.assertEquals;

public class SolutionsTest {

	@Test public void shouldSolve_001() { assertEquals(233168, solve_001()); }
	@Test public void shouldSolve_019() { assertEquals(171, solve_019()); }
	@Test public void shouldSolve_023() { assertEquals(4179871, solve_023()); }
	@Test public void shouldSolve_026() { assertEquals(983, solve_026()); }
	@Test public void shouldSolve_027() { assertEquals(-59231, solve_027()); }
	@Test public void shouldSolve_040() { assertEquals(210, solve_040()); }
	@Test public void shouldSolve_046() { assertEquals(5777, solve_046()); }
	@Test public void shouldSolve_047() { assertEquals(134043, solve_047()); }
	@Test public void shouldSolve_050() { assertEquals(997651, solve_050()); }
	@Test public void shouldSolve_051() { assertEquals(121313, solve_051()); }
	@Test public void shouldSolve_053() { assertEquals(4075, solve_053()); }
	//TODO 54 is not solved yet
	@Test public void shouldSolve_059() { assertEquals(107359, solve_059()); }
	@Test public void shouldSolve_060() { assertEquals(26033, solve_060()); }
	@Test public void shouldSolve_062() { assertEquals(127035954683L, solve_062()); }
	//TODO 63 is missing
	@Test public void shouldSolve_069() { assertEquals(510510, solve_069()); }
	@Test public void shouldSolve_070() { assertEquals(8319823, solve_070()); }
	@Test public void shouldSolve_071() { assertEquals(428570, solve_071()); }
	@Test public void shouldSolve_072() { assertEquals(303963552391L, solve_072()); }
	@Test public void shouldSolve_074() { assertEquals(402, solve_074()); }
	//TODO 79 is missing, I solved it with paper and pencil
	@Test public void shouldSolve_092() { assertEquals(8581146, solve_092()); }
	@Test public void shouldSolve_097() { assertEquals(8739992577L, solve_097()); }
	@Test public void shouldSolve_099() { assertEquals(709, solve_099()); }
	@Test public void shouldSolve_119() { assertEquals(248155780267521L, solve_119()); }
	//TODO 156 is missing
	@Test public void shouldSolve_179() { assertEquals(986262, solve_179()); }
	@Test public void shouldSolve_206() { assertEquals(1389019170, solve_206()); }
	//TODO 419 is not solved yet

}
