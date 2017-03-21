package cs1410;
import java.util.*;
/**
 * This class handles adding and removing vehicle objects from the queues at the tills and pumps
 * @author Everyone bitch
 * @version 1.03
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
	 * Gets the length of queue at a certain time		
	 * @return the length of the queue at that time
	 */
	public double getCurrentLength(){
		//return the length of all the items in the queue
		return currentLength;
	}
	
	/**
	 * Checks whether a certain type of vehicle given its size will fit within the length of the queue
	 * @param size a number space units the vehicle has as a non-integer value
	 * @return boolean value if true the size and current queue length is less than the final queue length
	 */
	public boolean checkspace(double size){
		//checks whether the space passed as a parameter will fit into the queue
		if ((currentLength + size) <= qLength){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @param caller
	 */
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
	
	/**
	 * 
	 * @param vehicle
	 * @param caller
	 * @return
	 */
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
