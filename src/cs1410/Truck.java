package cs1410;

public class Truck extends Vehicle{
	private double probabilityOfT;
	private boolean isHappy;
	
public Truck() {
	qSpace = 2;
	probabilityOfT = 0.02;
	tankSize = rnd.nextInt(11)+30;
	
	if(refillTime <= 8) {
		shoppingProb = 1;
		shoppingTime = rnd.nextInt(3)+4;
		shoppingMoney = rnd.nextInt(6)+15;
		isHappy = true;
	}
}
	
	private void setProbabilityOfT(double probability) {
		probabilityOfT = probability;	
	}
	
	private double getProbabilityOfT() {
		return probabilityOfT;
	}
	
	private double getShoppingTime() {
		return shoppingTime;
	}
	
	private void setRefillTime(int time) {
		refillTime = time;
	}
	
	private int getRefillTime() {
		return refillTime;
	}
	
	private void changeProbability() {
		if(isHappy) {
			probabilityOfT = probabilityOfT * 1.05;
		}
		else {
			probabilityOfT = probabilityOfT * 0.8;
		}
	}
}
