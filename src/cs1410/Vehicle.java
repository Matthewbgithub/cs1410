package cs1410;

import java.util.Random;

public class Vehicle {
	protected int tankSize;
	protected double shoppingProb;
	protected double shoppingMoney;
	protected double qSpace;
	protected int shoppingTime;
	protected double refillTime;
	static final int shopQSpace = 1;
	protected Random rnd;
	protected String name;
	
	public Vehicle(){
		rnd = new Random();
	}
	
//Set methods------
	public void setProbability(double prob){
		this.shoppingProb = prob;
	}
	
//Get methods------
	public String getName(){
		return name;
	}
	public double getLength(){
		return qSpace;
	}
	public int getTankSize(){
		return this.tankSize;
	}
	public double getProbability(){
		return shoppingProb;
	}
	public double getShoppingMoney(){
		return shoppingMoney;
	}
	public int getArrivalTime(){
		return 1;
	}
	
	public double getRefillTime(){
		return refillTime;	
	}
	
	public double getShopQSpace(){
		return shopQSpace;
	}
//other
	public boolean staysToShop(){
		if(rnd.nextDouble()<= shoppingProb){
			return true;
		}else{
			return false;
		}
	}
	public void changeProbability(){
	}
}
