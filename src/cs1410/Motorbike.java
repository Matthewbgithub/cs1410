/**
* Represents the Motobike class which is a subclass of Vehicle
* @author
* @version`
*/

package cs1410;

public class Motorbike extends Vehicle{
	private double probToAppearP;
	/**
	* Creates a <code> Motorbike </code> 
	* Sets the tank size, shopping probability, shopping money, space in queue and shopping time
	* 
	*/	
	public Motorbike(){
		name = "Motorbike";
		tankSize = 5;
		shoppingProb = -1;
		shoppingMoney = 0;
		qSpace = 0.75;
		shoppingTime = 0;
		refillTime = tankSize / 6;
	}
}
