package cs1410;
import java.util.*;
/**
*  This class handles adding and removing vehicle objects from the queues at the tills and pumps
* @Version 1.3
*
*/

public class Queue {
	private ArrayList<Vehicle> vehicleArray;
	private final int qLength=3;
	private double currentLength=0.0;
	
	public Queue(){
		//intialize the arraylist
		vehicleArray = new ArrayList<Vehicle>();
	}
	/**
	* Gets the length of the queue at a certain time
	* @
	*/
	public double getCurrentLength(){
		//return the length of all the items in the queue
		return currentLength;
	}
	
	public boolean checkspace(double size){
		//checks whether the space passed as a parameter will fit into the queue
		if ((currentLength + size) <= qLength){
			return true;
		}else{
			return false;
		}
	}
	public void removeFirstItem(String caller){
		//changes space left in queue
		if(!vehicleArray.isEmpty()){
			if(caller == "pump"){
				currentLength -= vehicleArray.get(0).getLength();
			}else{
				currentLength -= 1;
			}
		//removes first item from array
		vehicleArray.remove(0);
		}
	}
	
	public boolean add(Vehicle vehicle, String caller){ //add a parameter to decide whether its being called from pump or till
		if(caller == "pump"){
			if(checkspace(vehicle.getLength())){
				vehicleArray.add(vehicle);
				currentLength += vehicle.getLength();
				return true;
			}else{
				return false;
			}
		}else{
			if(checkspace(1)){
				vehicleArray.add(vehicle);
				currentLength += 1;
				return true;
			}else{
				return false;
			}
		}
	}
	
	public String toString(){
		return vehicleArray.toString();
	}
}
