package cs1410;
/**
 * Represents a pump in which vehicles queue up to and fill their tank with
 * @author
 * @version
 */
public class Pump
{
	Queue pumpQueue;
	private int number;
	
	public Pump(){
		pumpQueue = new Queue();
	}
	public boolean add(Vehicle vehicle){
		
		return pumpQueue.add(vehicle, "pump");
	}
	public Queue getQueue(){
		return pumpQueue;
	}
	public void setNo(int i){
		number = i;
	}
	public int getNo(){
		return number;
	}
}

		
