	package cs1410;

public class Sedan extends Vehicle{

	private  double probabiltyOfQ;
	private int shoppingTime;
	private int shoppingMoney;
	
	public Sedan(double probabilityOfQ, int shoppingTime, int shoppingMoney){
	this.probabilityOfQ = probabiltyOfQ;
	this.shoppingTime = shoppingTime;
	this.shoppingMoney = shoppingMoney;
	}
	
	public void setProbabilityOfQ(double probabilityOfQ){
	this.probabilityOfQ = probabiltyOfQ;
	
	}
	public double getProbabilityOfQ(){
	return probabilityOfQ;
	}
	
	public void setShoppingTime(int shoppingTime){
	this.shoppingTime = shoppingTime;	
	}
	
	public int getShoppingTime(){
	return shoppingTime;
	}
	
}
