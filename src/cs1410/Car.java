package cs1410;
import java.util.Random;

public class Car extends Vehicle{
	private Random random;
	public Car(){
		qSpace = 1;
		random = new Random();
		tankSize = random.nextInt(3)+7;
		refillTime = tankSize / 6;
	}
	
	public void setShoppingProb(){
		if(refillTime < 5) {
			shoppingProb = 0.3;
	}

}
