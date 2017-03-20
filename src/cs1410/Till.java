package cs1410;

public class Till {
	Queue tillQueue;
	
	public Till(){
		tillQueue = new Queue();
	}
	public boolean add(Vehicle vehicle){
		return tillQueue.add(vehicle, "till");
	}
	public Queue getQueue(){
		return tillQueue;
	}
}
