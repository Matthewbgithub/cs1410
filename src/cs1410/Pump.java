package cs1410;
import java.util.Random;


public class Pump
{
	Queue pumpQueue;
	// This is to decide which vehicle comes into the queue (between 0 and 1)
	private Random rndVehicleDecider;
	
	public Pump(){
		pumpQueue = new Queue();
	}
	
	public Queue getQueue(){
		return pumpQueue;
	}
}

		
