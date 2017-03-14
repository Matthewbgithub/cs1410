	package cs1410;
	
public class Sedan extends Vehicle{
	private int probToAppearQ;
	public Sedan(){
		qSpace = 1.5;
		shoppingTime = 10;
		tankSize = rnd.nextInt(3)+12;
	}
	
	public void setProbabilityOfQ(){
		
	
	}
	public double getProbabilityOfQ(){
	return probToAppearQ;
	}
	
	public void setShoppingTime(int shoppingTime){
	this.shoppingTime = shoppingTime;	
	}
	
	public int getShoppingTime(){
	return shoppingTime;
	}
	
}
