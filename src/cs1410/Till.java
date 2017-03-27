package cs1410;

public class Till {
	Queue tillQueue;
	private int number;
	
	public Till(){
		tillQueue = new Queue();
	}
	public boolean add(Vehicle vehicle){
		return tillQueue.add(vehicle, "till");
	}
	public Queue getQueue(){
		return tillQueue;
	}
	public void setNo(int i){
		number = i;
	}
	public int getNo(){
		return number;
	}
}
