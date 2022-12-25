package assignment4;


public class Betting {
	private double currBalance = 0;
	private int minBalance;
	private IRandomValueGenerator randomGenerator;
	
	
	public Betting(int minBalance, IRandomValueGenerator randomGenerator) {
		if (minBalance > 0) {
			throw new IllegalArgumentException("Minimum balance must be equal to or less than zero");
		}
		
		this.minBalance = minBalance;
		this.randomGenerator = randomGenerator;
	}

	public double getCurrentBalance() {
		return currBalance;
	}

	public boolean canBet(double amnt) {
		return currBalance - minBalance >= amnt;
	}

	public void addMoney(double amnt) {
		if (amnt < 0) {
			throw new IllegalArgumentException("Cannot be a negative number");
		}
		currBalance += amnt;
		
	}

	public double betOnANumber(double amnt, int min, int max, int selectedNumber) {
		// pick random number from specified range
		
		
		int random = randomGenerator.generateRandom(min, max);
		double amount = amnt;
		
		// check if equal to selected number
		// if bet loses, reduce currBalance by amnt
		if (random != selectedNumber) {
			currBalance -= amnt;
		}
		// if bet wins, increase currBalance by (range - 1) * amnt
		else {
			int range = max - min + 1;
			amount = (range - 1) * amnt;
			currBalance += amount;
			
		}
		// reject bets that cause balance to go below minBalance, return 0
		if (currBalance < minBalance) {
			amount = 0;
			currBalance = 0;
		}
			
		// return double of amount that balance was changed as a result of the bet
		return amount;
	}

	public double betOnProbability(double amnt, double p) {
				
		if (p > 1 || p < 0) {
			throw new ProbabilityException();
		}
		
		
		double amount = amnt;
		
		double rand = randomGenerator.generateRandom(0,1);
		if (rand > p) {
			// loss
			currBalance -= amnt;
		}
		else {
			// win
			double num = Math.pow(p, -1);
			amount = (num-1) * amnt;
			amount = Math.round(amount);
			currBalance += amount;
		}
		
		if (currBalance < minBalance) {
			amount = 0;
			currBalance = 0;
		}		
		// take off decimals from amount
		
		
		
		return amount;
		
	}
	
}
