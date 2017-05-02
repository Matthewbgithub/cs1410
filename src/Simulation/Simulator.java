package Simulation;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import View.SimulatorView;

/**
 * Simulates a petrol station that generates vehicles and runs in ticks
 * @author
 * @version 
 */
public class Simulator
{	
	private static int ticksToRun = 1440;
	private static Ticker ticker;
	private static int pumpNo = 3;
	private static int tillNo = 3;
	private static double p = 0.03;
	private static double q = 0.03;
	private static boolean trucks = true;
	private static double petrolPrice = 1.20;

	/**
	 * Runs the simulation with the set number of ticks (1440 by default).
	 */

//	public static void main(String[] args)
	public void runSim()
	{   
		ticker = new Ticker(ticksToRun);
		Station station = new Station(pumpNo, tillNo, p, q, trucks);
		SimulatorView simView = new SimulatorView(pumpNo, tillNo, ticksToRun); 
		station.setPetrolPrice(petrolPrice);
	
		ArrayList <ArrayList <ArrayList<Vehicle>>> pumpInfoToPassToSim = new ArrayList <ArrayList <ArrayList<Vehicle>>>();
		ArrayList <ArrayList <ArrayList<Vehicle>>> tillInfoToPassToSim = new ArrayList <ArrayList <ArrayList<Vehicle>>>();
		
		for(ticker.getTick(); ticker.getTick() <= ticker.getMaxTicks(); ticker.increment()) {
//			delay(10);
				System.out.print("Tick: " + ticker.getTick() + ": ");
				station.tick(ticker.getTick());
				System.out.println();

				ArrayList <ArrayList<Vehicle>> pumpListOfVehicleList = new ArrayList <ArrayList<Vehicle>>();
				
				for(int i = 0; i<pumpNo; i++)
				{
					ArrayList <Vehicle> vehiclesToAdd = new ArrayList <Vehicle>();
					for(int i2=0; i2<station.getPumpList().get(i).getArray().size(); i2++)
					{
						Vehicle vehicleToAdd = new Vehicle();
						vehicleToAdd = station.getPumpList().get(i).getArray().get(i2);
						vehiclesToAdd.add(vehicleToAdd);						
					}
					pumpListOfVehicleList.add(vehiclesToAdd);		
				}
				pumpInfoToPassToSim.add(pumpListOfVehicleList);
				
				ArrayList <ArrayList<Vehicle>> tillListOfVehicleList = new ArrayList <ArrayList<Vehicle>>();
				
				for(int i = 0; i<tillNo; i++)
				{
					ArrayList <Vehicle> vehiclesToAdd = new ArrayList <Vehicle>();
					for(int i2=0; i2<station.getTillList().get(i).getArray().size(); i2++)
					{
						Vehicle vehicleToAdd = new Vehicle();
						vehicleToAdd = station.getTillList().get(i).getArray().get(i2);
						vehiclesToAdd.add(vehicleToAdd);						
					}
					tillListOfVehicleList.add(vehiclesToAdd);		
				}
				tillInfoToPassToSim.add(tillListOfVehicleList);				
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
		
		simView.setTillInfo(tillInfoToPassToSim);
		simView.setPumpInfo(pumpInfoToPassToSim);
		
		simView.setOverallLoss(station.getFormattedLoss());
		simView.setOverallProfit(station.getFormattedIncome());
		simView.setOverallHappyTrucks(station.happyTrucks());
		simView.setOverallSadTrucks(station.sadTrucks());
		simView.setOverallVehiclesGenerated(station.vehiclesGenerated());
		simView.setOverallTruckHappiness(Truck.getProbabilityOfT());
		
		simView.runSimulation();
		ticker.reset();	
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
	/**
	 * Sets the probability of p
	 * @param sP The probability to set p to
	 */
	public void setP(double sP){
		p = sP;
	}
	/**
	 * Sets the probability of q
	 * @param sQ The probability to set q to
	 */
	public void setQ(double sQ){
		q = sQ;
	}
	/**
	 * Sets the number of pumps
	 * @param sPumps The number of pumps to run the simulation with
	 */
	public void setPumps(int sPumps){
		pumpNo = sPumps;
	}
	/**
	 * Sets the number of tills
	 * @param sTills The number of tills to run the simulation with
	 */
	public void setTills(int sTills){
		tillNo = sTills;
	}
	/**
	 * Sets whether the simulation uses trucks
	 * @param sIsTruck True/False value, whether to include trucks in this simulation
	 */
	public void setIsTruck(boolean sIsTruck){
		trucks = sIsTruck;
	}
	/**
	 * Sets the price of petrol per gallon
	 * @param setPetrolPrice The price of petrol to run the simulation with
	 */
	public void setPetrolPrice(double setPetrolPrice){
		petrolPrice = setPetrolPrice;
	}
	/**
	 * Sets the number of ticks to run the simulation for 
	 * @param setTicks The number of ticks that the simulation should run for
	 */
	public void setTicksToRun(int setTicks){
		ticksToRun = setTicks;
	}
}
