package cs1410;

public class Motorbike extends Vehicle{
	private double probToAppearP;
	
	public Motorbike(){
		tankSize = 5;
		shoppingProb = 0;
		shoppingMoney = 0;
		qSpace = 0.75;
		shoppingTime = 0;
		refillTime = tankSize / 6;
	}
	
	private void setProbabilityOfP(double probability) {
		probToAppearP = probability;
	}
	
	private double getProbabilityOfP() {
		return probToAppearP;	
	}
	
	
	
}
