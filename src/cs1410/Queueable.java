package cs1410;

import java.util.ArrayList;

public abstract class Queueable {
	Queue q;
	private int number;
	public Queueable(){
		q = new Queue();
	}
	public Queue getQueue(){
		return q;
	}
	public ArrayList<Vehicle> getQueueArray(){
		return this.getQueue().getArray();
	}
	public void setNo(int i){
		number = i;
	}
	public int getNo(){
		return number;
	}
}
