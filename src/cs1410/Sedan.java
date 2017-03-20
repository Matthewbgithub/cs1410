	package cs1410;
	import java.util.Random;
	
public class Sedan extends Vehicle{
	private int probToAppearQ;
	public Sedan(){
		qSpace = 1.5;
		tankSize = rnd.nextInt(3)+12;
		refillTime = tankSize / 6;
		
		if(refillTime < 10) {
			shoppingProb = 0.4;
			shoppingTime = rnd.nextInt(4)+2;
			shoppingMoney = rnd.nextDouble(9)+8;
		}
	}
	
	//set arrival probability
	public void setProbabilityOfQ(double probability){
		probToAppearQ = probability;
	}
	
	//get arrival probability
	public double getProbabilityOfQ(){
	return probToAppearQ;
	}
	
	//set time spent shopping
	public void setShoppingTime(int shoppingTime){
	this.shoppingTime = shoppingTime;	
	}
	
	//get time spent shopping
	public int getShoppingTime(){
	return shoppingTime;
	}
	
}
