package cs1410;
import java.util.Random;

public class Truck extends Vehicle{
	private double probabilityOfT;
	private double shoppingTime;
	private double shoppingMoney;
	private Random random;
	private int refillTime;
	private boolean isHappy;
	
public Truck() {
	int timeHigh = 6;
	int timeLow = 4;
	shoppingTime = random.nextDouble(timeHigh - timeLow) + timeLow;
	
	int moneyHigh = 20;
	int moneyLow = 15;
	shoppingMoney = random.nextDouble(moneyHigh - moneyLow) + moneyLow;
}
	
	private void setProbabilityOfT(double probability) {
		probabilityOfT = probability;	
	}
	
	private double getProbabilityOfT() {
		return probabilityOfT;
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
}
