package cs1410;

public class Motorbike extends Vehicle{
	private double probabilityOfP;
	private double shoppingProbability;
	public static final int tankSize = 5;
	
	public Motorbike(){
		shoppingProbability = 0;
		qSpace = 0.75;
	}
	
	private void setProbabilityOfP(double probability) {
		probabilityOfP = probability;
	}
	
	private double getProbabilityOfP() {
		return probabilityOfP;	
	}
	
	
	
}
