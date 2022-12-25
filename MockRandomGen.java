package assignment4;


public class MockRandomGen implements IRandomValueGenerator{

	private double rand;
	
	
	@Override 
	public int generateRandom(int min, int max) {


		double mul = ((max + 1) - min) * rand;
		return (int)( min + mul);

	}
	
	
	public void setRandom (double num) {
		this.rand = num;
	}

	

}
