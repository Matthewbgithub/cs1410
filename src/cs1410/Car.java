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
	public Car(){
		qSpace = 1;
		tankSize = rnd.nextInt(3)+7;
		refillTime = tankSize / 6;
		
		//if the refill time is less than 5 minutes, the probability of shopping is 0.3
		if(refillTime < 5) {
			shoppingProb = 0.3;
			shoppingTime = rnd.nextInt(3)+2;
			shoppingMoney = rnd.nextInt(6)+5;
	}
		//set arrival probability
		/**
		* @param set a double which is the probability of q
		*/
	private void setProbabilityOfP(double probability) {
		probToAppearP = probability;
	}
	
		//get arrival probability
		/**
		* @return probability set in the parameter
		*/
	private double getProbabilityOfP() {
		return probToAppearP;	
	}
}
