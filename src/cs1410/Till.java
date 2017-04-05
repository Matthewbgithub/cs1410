package cs1410;

public class Till extends Queueable 
{
	
//	/protected int qLength=0;

	public boolean add(Vehicle vehicle){
		return this.addTo(vehicle, "till");
	}
	public void removeFirstItem(){
		this.removeF("till");
	}
}
