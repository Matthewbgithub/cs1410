/**
*Represents a subclass of vehicle
* @author
* @version
*/

import java.util.Random;

public class Car extends Vehicle{	
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
	/**
	 * Creates a new Car, sets inherited fields and randomises the tank size and shopping time & money spent
	 */
	private void generate(){
		name = "Car";
		rnd = new Random();
		qSpace = 1;
		tankSize = rnd.nextInt(3) + 7;
		timeToRefillIn = 10;
		refillTime = tankSize / 6;
		
		shoppingProb = 0.3;
		browseTime = rnd.nextInt(3)+2;
		shoppingMoney = rnd.nextInt(6)+5;
	}
}
