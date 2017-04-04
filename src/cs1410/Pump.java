package cs1410;

import java.util.ArrayList;

/**
 * Represents a pump in which vehicles queue up to and fill their tank with
 * @author
 * @version
 */
public class Pump extends Queueable
{
	
	public boolean add(Vehicle vehicle){
		
		return q.add(vehicle, "pump");
	}
	
}

		
