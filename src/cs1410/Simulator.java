package cs1410;

public class Simulator
{
	

	private static Ticker ticker = new Ticker(1440);

	public static void main(String[] args)
	{
		//pump number, till number, p, q, trucks?

		Station station = new Station(1, 1, 0.05, 0.05, true);

		station.setPetrolPrice(1.20);
		

		for(ticker.getTick(); ticker.getTick() <= ticker.getMaxTicks(); ticker.increment()) {
			delay(0);
				System.out.print("Tick: " + ticker.getTick() + ": ");
				station.tick(ticker.getTick());
				System.out.println();
				//station.generateVehicle();
			}
			System.out.println("-------------------------------------");
			System.out.println("This has caused loss of: " + station.getLoss());
			System.out.println("There has been profit of: " + station.getFormattedIncome());
			System.out.println("There was " + station.happyTrucks() + " happy Trucks and " + station.sadTrucks() + " sad Trucks. ");
			System.out.println("There was " + station.vehiclesGenerated() + " vehicles generated. ");
			System.out.println("Truck happiness: " + Truck.getProbabilityOfT());
			System.out.println("The pump queues look like: ");			
			for(Pump i : station.getPumpList()){
				System.out.println("\t" + i.getQueue().toString());
			}
				System.out.println("The till queues look like: ");
			for(Till tick : station.getTillList()){
				System.out.println("\t" + tick.getQueue().toString());
			}
			System.out.println("-------------------------------------");
	}
		
		
			
	//Return the total number of ticks that have gone past so far (time)
	public static int getTicks()
	{
	  return  ticker.getTick(); 
	}
	private static void delay(int millisecs)
    {
        try {
            Thread.sleep(millisecs);
        }
        catch (InterruptedException ie) {
        }
    }
}
