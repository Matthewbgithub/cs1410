package cs1410;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Simulates a petrol station that generates vehicles and runs in ticks
 * @author
 * @version 
 */
public class Simulator
{	

	private static Ticker ticker = new Ticker(1440);


	/**
	 * Runs the simulation with 1440 ticks
	 */

	public static void main(String[] args)
	{
		//pump number, till number, p, q, trucks?
		   
		  Station station = new Station(3, 3, 0.03, 0.03, true);
		station.setPetrolPrice(1.20);
		for(ticker.getTick(); ticker.getTick() <= ticker.getMaxTicks(); ticker.increment()) {
			delay(0);
				System.out.print("Tick: " + ticker.getTick() + ": ");
				station.tick(ticker.getTick());
				System.out.println();
				//station.generateVehicle();
			}
		 PrintWriter writer;
			try {
				writer = new PrintWriter("simulationOutput.txt");
			System.out.println("-------------------------------------");
			writer.println("-------------------------------------");
			
			System.out.println("This has caused loss of: " + station.getFormattedLoss());
			writer.println("This has caused loss of: " + station.getFormattedLoss());
			
			System.out.println("There has been profit of: " + Station.getFormattedIncome());
			writer.println("There has been profit of: " + Station.getFormattedIncome());
			
			if(station.isTruck()){
				System.out.println("There was " + station.happyTrucks() + " happy Trucks and " + station.sadTrucks() + " sad Trucks. ");
				writer.println("There was " + station.happyTrucks() + " happy Trucks and " + station.sadTrucks() + " sad Trucks. ");
				
				System.out.println("Truck happiness: " + Truck.getProbabilityOfT());
				writer.println("Truck happiness: " + Truck.getProbabilityOfT());
			}else{
				System.out.println("Trucks are disabled.");
				writer.println("Trucks are disabled.");
			}
			System.out.println("There was " + station.vehiclesGenerated() + " vehicles generated. ");
			writer.println("There was " + station.vehiclesGenerated() + " vehicles generated. ");
			
			System.out.println("The number of Cars generated were: " + station.Car);
			writer.println("The number of Cars generated were: " + station.Car);
			
			System.out.println("The number of Motorbikes generated were: " + station.Motorbike);
			writer.println("The number of Motorbikes generated were: " + station.Motorbike);
			
			System.out.println("The number of Sedans generated were: " + station.Sedan);
			writer.println("The number of Sedans generated were: " + station.Sedan);
			
			System.out.println("The number of Trucks generated were: " + station.Trucks);
			writer.println("The number of Trucks generated were: " + station.Trucks);
			
			System.out.println("The pump queues look like: ");
			writer.println("The pump queues look like: ");
			
			for(Pump i : station.getPumpList()){
				System.out.println("\t" + i.toString());
				writer.println("\t" + i.toString());
			}
				System.out.println("The till queues look like: ");
				writer.println("The till queues look like: ");
			for(Till tick : station.getTillList()){
				System.out.println("\t" + tick.toString());
				writer.println("\t" + tick.toString());
			}
			System.out.println("-------------------------------------");
			writer.println("-------------------------------------");
			
			writer.close();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}	
	/**
	 * @return number of ticks that have passed so far
	 */
	public static int getTicks()
	{
	  return  ticker.getTick(); 
	}
	/**
	 * Delays the simulation
	 * @param millisecs an int that delays the simulation by in milliseconds
	 */
	private static void delay(int millisecs)
    {
        try {
            Thread.sleep(millisecs);
        }
        catch (InterruptedException ie) {
        }
    }
}
