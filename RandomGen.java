package assignment4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGen implements IRandomValueGenerator {

	
	
	@Override 
	public int generateRandom(int min, int max) {
	//	int random = ThreadLocalRandom.current().nextInt(min, max + 1);

		Random rand = new Random();
		double num = rand.nextDouble();

		double mul = ((max+1) - min) * num;
		return (int)( min + mul);
		//return random;	
	}



	
	

}
