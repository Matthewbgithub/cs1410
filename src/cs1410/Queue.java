package cs1410;
import java.util.*;

public class Queue {
	private ArrayList<Vehicle> vehicleArray;
	private int qLength=3;
	private double currentLength=0.0;
	
	public Queue(){
		//intialize the arraylist
		vehicleArray = new ArrayList<Vehicle>();
	}
	
	public void setLength(int length){
		qLength = length;
	}
	
	public int getLength(){
		return qLength;
	}
	public double getCurrentLength(){
		//return the length of all the items in the queue
		return currentLength;
	}
	
	public boolean checkspace(Vehicle toAdd){
		//checks whether the space passed as a parameter will fit into the queue
		double size = toAdd.getLength();
		if ((currentLength + size) <= qLength){
			return true;
		}else{
			return false;
		}
	}
	public void removeFirstItem(){
		//changes space left in queue
		if(!vehicleArray.isEmpty()){
		currentLength -= vehicleArray.get(0).getLength();
		//removes first item from array
		vehicleArray.remove(0);
		}
	}
	
	public void add(Vehicle vehicle){
		vehicleArray.add(vehicle);
		currentLength += vehicle.getLength();
	}
	public String toString(){
		return vehicleArray.toString();
	}
}
