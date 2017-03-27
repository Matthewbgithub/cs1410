/**
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
	public Motorbike(Station s){
		currentStation = s;
		generate();
	}
	public Motorbike(){
		generate();
	}
	private void generate(){
		name = "Motorbike";
		qSpace = 0.75;
		tankSize = 5;
		timeToRefillIn = 0;
		refillTime = tankSize / 6;
		
		shoppingProb = -1;
		shoppingTime = 0;
		shoppingMoney = 0;
	}
}
