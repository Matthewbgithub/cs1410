package cs1410;

public class Till extends Queueable 
{
	
	public boolean add(Vehicle vehicle){
		return q.add(vehicle, "till");
	}

}
