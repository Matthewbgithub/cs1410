	package cs1410;
	import java.util.Random;
	/**
	 * A subclass of Vehicle
	 * @author 
	 * @version
	 */
public class Sedan extends Vehicle{
	public Sedan(Station s){
		currentStation = s;
		generate();
	}
	public Sedan(){
		generate();
	}
	
	/**
	 * Creates a new Sedan vehicle, setting inherited fields and randomises its tank size and time & money spent on shopping
	 */
	private void generate(){
		name = "Sedan";
		rnd = new Random();
		qSpace = 1.5;
		tankSize = rnd.nextInt(3)+12;
		timeToRefillIn = 10;
		refillTime = tankSize / 6;
		
		shoppingProb = 0.4;
		browseTime = rnd.nextInt(4)+2;
		shoppingMoney = rnd.nextInt(9)+8;
	}
}
