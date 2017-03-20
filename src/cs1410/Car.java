package cs1410;
import java.util.Random;

public class Car extends Vehicle{
	private double probToAppearP;
	public Car(){
		qSpace = 1;
		random = new Random();
		tankSize = rnd.nextInt(3)+7;
		refillTime = tankSize / 6;
		
		//if the refill time is less than 5 minutes, the probability of shopping is 0.3
		if(refillTime < 5) {
			shoppingProb = 0.3;
			shoppingTime = rnd.nextInt(3)+2;
			shoppingMoney = rnd.nextDouble(6)+5;
	}
		//set arrival probability
	private void setProbabilityOfP(double probability) {
		probToAppearP = probability;
	}
	
		//get arrival probability
	private double getProbabilityOfP() {
		return probToAppearP;	
	}
}
