package cs1410;

public class Simulator
{
	
	private static int i = 0;
	public static void main(String[] args)
	{
		//pump number, till number, p, q, trucks?
		Station station = new Station(1, 0, 0, 0, false);
		station.setPetrolPrice(1.20);
		
			for(i = 0; i< 200; i++){
				System.out.print("tick: " + i + ": ");
				station.tick(i);
				System.out.println();
				//station.generateVehicle();
			}
			System.out.println("-------------------------------------");
			System.out.println("this has caused loss of " + station.getLoss());
			System.out.println("there has been profit of: " + station.getIncome());
			System.out.println("Truck happiness: " + Truck.getProbabilityOfT());
			System.out.println("The pump queues look like ");			
			for(Pump i : station.getPumpList()){
				System.out.println(i.getQueue().toString());
			}
			System.out.println("-------------------------------------");
	}
			
	//Return the total number of ticks that have gone past so far (time)
	public static int getTicks()
	{
	  return  i; 
	}
	
	
	
}
