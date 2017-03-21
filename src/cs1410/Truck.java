package cs1410;

import java.util.Random;

public class Truck extends Vehicle{
	private static double probabilityOfT = 0.02;
	private boolean isHappy;
	
public Truck() {
	name = "Truck";
	rnd = new Random();
	qSpace = 2;
	tankSize = rnd.nextInt(11)+30;
	
	//if refill time is less than or equal to 8 minutes, the truck driver will definitely shop
	if(refillTime <= 8) {
		shoppingProb = 1;
		shoppingTime = rnd.nextInt(3)+4;
		shoppingMoney = rnd.nextInt(6)+15;
		isHappy = true;
	}else{
		isHappy = false;
	}
}
	//set arrival probability
	private void setProbabilityOfT(double probability) {
		probabilityOfT = probability;	
	}
	
	//get arrival probability
	public static double getProbabilityOfT() {
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
	public void changeProbability() {
		if(isHappy) {
			probabilityOfT *= 1.05;
			System.out.println("Happy trucker ("+ probabilityOfT +")");
		}
		else {
			probabilityOfT *= 0.8;
			System.out.println("Unhappy trucker ("+ probabilityOfT +")");
		}
	}
}
