package cs1410;


public class Pump
{
	Queue pumpQueue;
	
	public Pump(){
		pumpQueue = new Queue();
	}
	public boolean add(Vehicle vehicle){
		return pumpQueue.add(vehicle, "pump");
	}
	public Queue getQueue(){
		return pumpQueue;
	}
}

		
