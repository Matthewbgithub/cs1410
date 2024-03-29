package Simulation;
/**
 * Represents a pump in which vehicles queue up to and fill their tank with
 * @author
 * @version
 */
public class Pump extends Queueable
{
	public Pump(){
		qLength=3;
	}
	
	public boolean add(Vehicle vehicle){
		
		return this.addTo(vehicle, "pump");
	}
	public void removeFirstItem(){
		this.removeF("pump");
	}
}

		
