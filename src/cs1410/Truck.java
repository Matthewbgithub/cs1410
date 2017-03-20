package cs1410;

public class Truck extends Vehicle{
	private double probabilityOfT;
	private boolean isHappy;
	
public Truck() {
	qSpace = 2;
	probabilityOfT = 0.02;
	tankSize = rnd.nextInt(11)+30;
	
	//if refill time is less than or equal to 8 minutes, the truck driver will definitely shop
	if(refillTime <= 8) {
		shoppingProb = 1;
		shoppingTime = rnd.nextInt(3)+4;
		shoppingMoney = rnd.nextInt(6)+15;
		isHappy = true;
	}
}
	
	//set arrival probability
	private void setProbabilityOfT(double probability) {
		probabilityOfT = probability;	
	}
	
	//get arrival probability
	private double getProbabilityOfT() {
		return probabilityOfT;
	}
	
	//get time spent shopping
	private double getShoppingTime() {
		return shoppingTime;
	}
	
	//set refill time
	private void setRefillTime(int time) {
		refillTime = time;
	}
	
	//get refill time
	public double getRefillTime() {
		return refillTime;
	}
	
	//changes the probability of other trucks arriving depending on if the truck driver is happy or not
	private void changeProbability() {
		if(isHappy) {
			probabilityOfT = probabilityOfT * 1.05;
		}
		else {
			probabilityOfT = probabilityOfT * 0.8;
		}
	}
}
