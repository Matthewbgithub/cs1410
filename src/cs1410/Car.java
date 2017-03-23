/**
*Represents a subclass of vehicle
* @author
* @version
*/

package cs1410;
import java.util.Random;

public class Car extends Vehicle{
	private double probToAppearP;
	
	/**
	* Creates a <code> Car </code> and automatically sets the queue space to 1
	*/
	public Car(Station s){
		currentStation = s;
		generate();
	}
	public Car(){
		generate();
	}
	private void generate(){
		name = "Car";
		rnd = new Random();
		qSpace = 1;
		tankSize = rnd.nextInt(3) + 7;
		timeToRefillIn = 10;
		refillTime = tankSize / 6;
		
		shoppingProb = 0.3;
		shoppingTime = rnd.nextInt(3)+2;
		shoppingMoney = rnd.nextInt(6)+5;
	}
}