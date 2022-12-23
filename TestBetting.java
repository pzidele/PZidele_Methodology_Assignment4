package assignment4;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBetting {
	private static MockRandomGen gen;
	private static Betting bet;
	
	@BeforeEach
	void setUp() {
		gen = new MockRandomGen(.2);
		bet = new Betting(0, gen);
	}
	

	@Test
	void testBetOnANumber() {
		bet.betOnANumber(.2, 1, 5, 4);
		int random = gen.getRandomRange(1, 5);
		
		assertEquals(random,.2);
		
		//int currBalance = 
	}
	
	@Test
	void testThrowsException() {
		
		Exception exception = assertThrows(ProbabilityException.class, () -> {
			bet.betOnProbability(0,2);
		    });
	}
	
	@Test
	void testBetOnProbability() {
		double t = bet.betOnProbability(2, .5);
		
		//assertEquals(t,)
		
	}

}
