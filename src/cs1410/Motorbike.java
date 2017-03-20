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
		tankSize = 5;
		shoppingProb = 0;
		shoppingMoney = 0;
		qSpace = 0.75;
		shoppingTime = 0;
		refillTime = tankSize / 6;
	}
	
	//set arrival probability
	/**
	* @param sets the probability of the appearance of the motorbike using a double
	*/
		
	private void setProbabilityOfP(double probability) {
		probToAppearP = probability;
	}
	
	//get arrival probability
	/**
	* @return probability set by user
	
	*/
	private double getProbabilityOfP() {
		return probToAppearP;	
	}
	
	
	
}
