package assignment4;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBetting {
	private MockRandomGen gen;
	private Betting bet;
	
	@BeforeEach
	void setUp() {
		gen = new MockRandomGen();
		bet = new Betting(0, gen);
	}
	
	
	@Test
	void testAddMoney() {
		
		bet.addMoney(20);
		assertEquals(20,bet.getCurrentBalance());
	
		
		assertThrows(IllegalArgumentException.class, () -> {
			bet.addMoney(-5);
		    });
		
		bet.addMoney(100);
		assertEquals(120, bet.getCurrentBalance());
	
	}
	
	@Test
	void testCanBet() {
		assertFalse(bet.canBet(10));
		
		bet.addMoney(100);
		
		assertTrue(bet.canBet(20));
		assertFalse(bet.canBet(120));

		}
	

	@Test
	void testBetOnANumber() {
		
		gen.setRandom(.5);
		int rand = gen.generateRandom(0, 10);
		assertEquals(5, rand);
		
		double better = bet.betOnANumber(10, 0, 10, 20);
	
		
		assertEquals(0, better);
		
		better = bet.betOnANumber(10, 0, 10, 5);
		assertEquals(100,better);
		
		assertEquals(100, bet.getCurrentBalance());

	}
	
	@Test
	void testProbabilityThrowsExceptionWhenGreaterThanZero() {
		assertThrows(ProbabilityException.class, () -> {
			bet.betOnProbability(0,2);
		    });
	}
	
	@Test
	void testBetOnProbability() {
		
		gen.setRandom(.5);
		gen.generateRandom(0, 1);
		assertEquals(0, bet.betOnProbability(100, .3));
		
		bet.addMoney(500);
		assertEquals(500, bet.getCurrentBalance());
		
		gen.setRandom(.2);
		
		assertEquals(233, bet.betOnProbability(100, .3));
		
		assertEquals(733,bet.getCurrentBalance());
		
		gen.setRandom(.6);
		
		assertEquals(100, bet.betOnProbability(100, 0.1));
		assertEquals(633, bet.getCurrentBalance());
	}

}
