package net.projecteuler;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.projecteuler.ProjectEuler054.FourOfAKind;
import net.projecteuler.ProjectEuler054.Hand;
import net.projecteuler.ProjectEuler054.Flush;

public class ProjectEuler054Test {

	@Test
	public void shouldRecognizeHand() {
		assertTrue(new Hand("6S 6C 6D 6H 2H").rank().get(0) instanceof FourOfAKind);
		assertTrue(new Hand("6S 7S 2S 8S 5S").rank().get(0) instanceof Flush);
	}

}
