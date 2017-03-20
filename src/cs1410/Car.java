package cs1410;
import java.util.Random;

public class Car extends Vehicle{
	private double probToAppearP;
	public Car(){
		qSpace = 1;
		random = new Random();
		tankSize = rnd.nextInt(3)+7;
		refillTime = tankSize / 6;
		
		if(refillTime < 5) {
			shoppingProb = 0.3;
			shoppingTime = rnd.nextInt(3)+2;
			shoppingMoney = rnd.nextDouble(6)+5;
	}
	private void setProbabilityOfP(double probability) {
		probToAppearP = probability;
	}
	
	private double getProbabilityOfP() {
		return probToAppearP;	
	}
}
