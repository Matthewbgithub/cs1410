package cs1410;

/**
 * Represents a pump in which vehicles queue up to and fill their tank with
 * @author
 * @version
 */
public class Pump extends Queueable
{
	
	public boolean add(Vehicle vehicle){
		
		return this.addTo(vehicle, "pump");
	}
	public void removeFirstItem(){
		this.removeF("pump");
	}
}

		
