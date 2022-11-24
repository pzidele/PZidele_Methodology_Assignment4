package assignment4;

public class MockRandomGen implements IRandomValueGenerator{

	private int num;
	private double prob;
	
	public MockRandomGen(int num) {
		this.num = num;
	}
	
	public MockRandomGen(double prob) {
		this.prob = prob;
	}
	
	@Override
	public int getRandomRange(int min, int max) {
		return num;
	}
	
	public void setRandom (int num) {
		this.num = num;
	}

	@Override
	public double getRandomProb() {
		return prob;
	}
	
	public void setRandomProb(double prob) {
		this.prob = prob;
	}

}
