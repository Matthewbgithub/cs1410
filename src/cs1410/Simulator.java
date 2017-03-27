package cs1410;

public class Simulator
{
	
	private static Ticker ticker = new Ticker();
	public static void main(String[] args)
	{
		//pump number, till number, p, q, trucks?
		Station station = new Station(1, 0, 0, 0, false);
		station.setPetrolPrice(1.20);
		

		for(ticker.getTick(); ticker.getTick() <= ticker.getMaxTicks(); ticker.increment()) {
			delay(10);
				System.out.print("Tick: " + ticker.getTick() + ": ");
				station.tick(ticker.getTick());
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
				System.out.println("The pump queues look like ");
			for(Pump tick : station.getPumpList()){
				System.out.println(tick.getQueue().toString());
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
