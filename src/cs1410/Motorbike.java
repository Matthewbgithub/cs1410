package cs1410;

public class Motorbike extends Vehicle{
	private double probabilityOfP;
	private double shoppingProbability;
	
	public Motorbike(){
		shoppingProbability = 0;
	}
	
	private void setProbabilityOfP(double probability) {
		probabilityOfP = probability;
	}
	
	private double getProbabilityOfP() {
		return probabilityOfP;	
	}
}
