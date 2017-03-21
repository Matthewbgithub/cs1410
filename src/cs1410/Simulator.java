package cs1410;
import java.util.Random;

public class Simulator
{
	
	private Random ranNumGenerator;
	
	public static void main(String[] args)
	{
		//pump number, till number, p, q, trucks?
		Station station = new Station(20, 3, 0.02, 0.05, true);
		station.setPetrolPrice(1.20);
		
			for(int i = 0; i< 200; i++){
				System.out.println("tick: " + i);
				station.generateVehicle();
			}
			System.out.println("-------------------------------------");
			System.out.println("this has caused loss of " + station.getLoss());
			System.out.println("The pump queues look like ");
			for(Pump i : station.getPumpList()){
				System.out.println(i.getQueue().toString());
			}
			System.out.println("-------------------------------------");
			System.out.println(Truck.getProbabilityOfT());
	}
			
	//Return the total number of ticks that have gone past so far (time)
	public int getTicks()
	{
	  return  0; 
	}
	
	
	
	
}
