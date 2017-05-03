package Simulation;


import java.util.Random;

/**
 * A subclass of vehicle 
 * @author 
 * @version
 */
public class Truck extends Vehicle{
	private static double probabilityOfT = 0.02;
	private boolean isHappy;
	
	
public Truck(Station s) {
	currentStation = s;
	generate();
}
public Truck(){
	generate();
}
private void generate(){
	name = "Truck";
	rnd = new Random();
	qSpace = 2;
	tankSize = rnd.nextInt(11)+30;
	timeToRefillIn = 8;
	refillTime = tankSize / 6;
	
	shoppingProb = 1;
	browseTime = rnd.nextInt(3)+4;
	shoppingMoney = rnd.nextInt(6)+15;
	/**
	 * if refill time is less than or equal to 8 minutes, the truck driver will definitely shop
	 * if refill time is greater the 8 minutes then the driver is unhappy
	 */
	if((refillTime )<= 8) {
		
		isHappy = true;
	}else{
		isHappy = false;
	}
}
	protected static void happy(){
		probabilityOfT *= 1.05;
	}
	protected static void unHappy(){
		probabilityOfT *= 0.8;
	}
	
	//get arrival probability
	public static double getProbabilityOfT() {
		return probabilityOfT;
	}
	
	}
