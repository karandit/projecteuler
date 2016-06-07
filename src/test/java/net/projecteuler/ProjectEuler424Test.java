package net.projecteuler;

import static net.projecteuler.ProjectEuler424.solveKakuro;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProjectEuler424Test {

	@Test
	public void shouldSolve_Kakuro001() {
		assertKakuro(8426039571L, "6,X,X,(vCC),(vI),X,X,X,(hH),B,O,(vCA),(vJE),X,(hFE,vD),O,O,O,O,(hA),O,I,(hJC,vB),O,O,(hJC),H,O,O,O,X,X,X,(hJE),O,O,X"); 
	}

	@Test
	public void shouldSolve_Kakuro002() {
		assertKakuro(8519647302L, "7,X,X,X,X,(vJJ),(vCD),X,X,X,X,(hCG),O,O,(vCE),X,X,X,(hCI,vJB),C,O,O,X,(vB),(hJF,vJF),O,F,O,O,(hJA),F,G,O,O,X,X,(hCA),O,A,O,X,X,X,X,(hCF),O,O,X,X,X"); 
	}
	
	@Test
	public void shouldSolve_Kakuro003() {
		assertKakuro(3019652784L, "7,X,X,X,(vE),(vCB),X,X,X,X,(hJ),O,O,(vCA),X,X,(vCH),(hCG,vCJ),O,O,O,(vJ),(hCE),O,O,O,(hJ,vGG),O,O,(hD),I,O,(hCD,vCB),H,O,O,X,(hCE),O,O,E,X,X,X,X,(hCE),O,O,X,X"); 
	}
	
	@Test
	public void shouldSolve_Kakuro004() {
		assertKakuro(6457280931L, "6,X,X,X,(vEA),(vJF),X,X,X,(hI),O,O,(vJA),X,(vA),(hEI,vEB),O,O,O,(hIG),C,O,J,O,D,(hJD),O,O,O,X,X,X,(hJD),O,O,X,X"); 
	}
	
	@Test
	public void shouldSolve_Kakuro005() {
		assertKakuro(9251083647L, "7,X,(vH),(vG),X,X,(vI),(vDH),(hG),B,O,(vDI),(hDB,vDE),O,O,(hBC),I,O,F,O,O,J,X,X,(hG),O,O,X,X,X,(vDG),(hH,vDD),O,O,(vDJ),(vC),(hBI),O,O,O,O,O,O,(hDJ),O,O,X,(hA),O,O"); 
	}
	
	@Test
	public void shouldSolve_Kakuro006() {
		assertKakuro(5236479810L, "6,X,(vID),(vIJ),X,X,X,(hH),F,I,(vF),(vIA),X,(hIA),G,B,O,C,X,X,(hID),O,O,O,(vIF),X,(hIA),E,O,I,O,X,X,X,(hII),O,G"); 
	}
	
	@Test
	public void shouldSolve_Kakuro007() {
		assertKakuro(1348672905L, "6,X,X,(vAF),(vAI),X,X,X,(hJ,vAC),O,B,(vGJ),X,(hGH),J,O,O,O,(vAF),(hAG),O,O,(hH,vF),A,D,X,(hGF),O,E,O,O,X,X,(hD),O,O,X"); 
	}
	
	@Test
	public void shouldSolve_Kakuro008() {
		assertKakuro(5417093862L, "7,X,X,X,X,(vCE),(vGB),X,X,(vJG),(vCI),(hCD,vCJ),O,O,X,(hCI),O,O,O,O,B,(vJB),(hCF),O,O,O,(hCA,vH),O,O,(hCJ),O,O,(hJB,vCJ),O,O,O,X,(hJD),O,O,O,O,O,X,(hF),I,O,X,X,X"); 
	}
	
	@Test
	public void shouldSolve_Kakuro009() {
		assertKakuro(8190245736L, "7,X,(vBB),(vBD),X,X,X,X,(hBB),C,E,(vEE),(vEC),X,X,(hBC),O,O,O,O,X,X,X,(hEF),H,O,A,(vJ),X,X,X,(hBD),O,O,O,(vI),X,X,(hBE),F,O,O,O,X,X,X,X,(hG),O,O"); 
	}
	
	@Test
	public void shouldSolve_Kakuro010() {
		assertKakuro(8547961032L, "7,X,X,(vGG),(vGD),X,(vI),(vGI),X,(hGB),O,O,(hGH,vIC),O,O,X,(hGA),O,O,O,J,O,X,X,(hGI),O,O,X,X,X,(vGD),(hE,vE),O,O,(vGF),X,(hIH),O,O,O,O,O,X,(hE),A,O,(hGF),O,O,X"); 
	}

	private static void assertKakuro(long exp, String kakuro) {
		assertEquals(exp, solveKakuro(kakuro));
	}

}
