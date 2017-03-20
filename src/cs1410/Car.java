package cs1410;
import java.util.Random;

public class Car extends Vehicle{
	private Random random;
	public Car(){
		qSpace = 1;
		random = new Random();
		tankSize = random.nextInt(3)+7;
		refillTime = tankSize / 6;
		
		if(refillTime < 5) {
			shoppingProb = 0.3;
			shoppingTime = random.nextInt(3)+2;
			shoppingMoney = random.nextDouble(9)+8;
	}

}
