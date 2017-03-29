/**
 * Represents the Motorbike class which is a subclass of Vehicle
* @author
* @version`
*/

package cs1410;
import java.util.Random;
public class Motorbike extends Vehicle{
	/**
	* Creates a <code> Motorbike </code> 
	*/	
	public Motorbike(Station s){
		currentStation = s;
		generate();
	}
	public Motorbike(){
		generate();
	}	
	
	/**
	 * Sets the tank size, shopping probability, shopping money, space in queue and shopping time
	 */
	private void generate(){
		name = "Motorbike";
		rnd = new Random();
		qSpace = 0.75;
		tankSize = 5;
		timeToRefillIn = -1;
		refillTime = tankSize / 6;
		
		shoppingProb = 1;
		shoppingTime = rnd.nextInt(2)+2;
		shoppingMoney = 0;
	}
}
