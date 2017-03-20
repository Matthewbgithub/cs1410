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
	
}
