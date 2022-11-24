package assignment4;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGen implements IRandomValueGenerator {
	
	private IRandomValueGenerator number;
	
	public RandomGen(IRandomValueGenerator number) {
		this.number = number;
	}

	@Override
	public int getRandomRange(int min, int max) {
		
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);

		return random;
	}

	@Override
	public double getRandomProb() {
		return Math.random();
	}



	
	

}
