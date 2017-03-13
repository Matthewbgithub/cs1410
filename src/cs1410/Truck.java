package cs1410;
import java.util.Random;

public class Truck extends Vehicle{
	private double probabilityOfT;
	private double shoppingTime;
	private double shoppingMoney;
	private Random random;
	
public Truck() {
	int high = 6;
	int low = 4;
	shoppingTime = random.nextDouble(high - low) + low;
}
	
}
