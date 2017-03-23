	package cs1410;
	import java.util.Random;
	
public class Sedan extends Vehicle{
	public Sedan(Station s){
		currentStation = s;
		generate();
	}
	public Sedan(){
		generate();
	}
	private void generate(){
		name = "Sedan";
		rnd = new Random();
		qSpace = 1.5;
		tankSize = rnd.nextInt(3)+12;
		timeToRefillIn = 10;
		refillTime = tankSize / 6;
		
		shoppingProb = 0.4;
		shoppingTime = rnd.nextInt(4)+2;
		shoppingMoney = rnd.nextInt(9)+8;
	}
}