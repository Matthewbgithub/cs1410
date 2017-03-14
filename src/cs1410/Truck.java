package cs1410;

public class Truck extends Vehicle{
	private double probabilityOfT;
	private int refillTime;
	private boolean isHappy;
	
public Truck() {
	qSpace = 2;
	probabilityOfT = 0.02;
	
	int tankHigh = 40;
	int tankLow = 30;
	//tankSize = rnd.nextInt(tankHigh - tankLow) + tankLow;
	
	int timeHigh = 6;
	int timeLow = 4;
	//shoppingTime = rnd.nextInt(timeHigh - timeLow) + timeLow;
	
	int moneyHigh = 20;
	int moneyLow = 15;
	//shoppingMoney = rnd.nextInt(moneyHigh - moneyLow) + moneyLow;
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
	
	private boolean isHappy() {
		if(refillTime <= 8) {
			return true;
		}
		else {
			return false;
		}
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
