package Simulation;

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Represents the petrol station
 * @author 
 * @version
 */
public class Station {
	private static double income;
	private double loss;
	private static double petrolPrice;
	private double probabilityP;
	private double probabilityQ;
	private ArrayList<Pump> pumpList;
	private ArrayList<Till> tillList;
	private Random rnd;
	private boolean isTruck;
	public static int Car = 0;
	public static int Motorbike = 0;
	public static int Sedan = 0;
	public static int Trucks = 0;
	
	
	private int vehiclesGenerated = 0;
	private int happyTrucks = 0;
	private int sadTrucks = 0;
	
	/**
	 * @param pumpNo the number of pumps in the station
	 * @param tillNo the number of tills in the station
	 * @param p double representing the probability of p
	 * @param q double representing the probability of q
	 * @param isTruck boolean determining whether the simulation contains trucks or not
	 */
	public Station(int pumpNo, int tillNo, double p, double q, boolean isTruck){
		probabilityP = p;
		probabilityQ = q;
		pumpList = new ArrayList<Pump>();
		tillList = new ArrayList<Till>();
		rnd = new Random();
		this.isTruck = isTruck;
		
		for(int i = 0; i < pumpNo; i++){
			Pump pump = new Pump();
			pump.setNo(i+1);
			pumpList.add(pump);
		}
		for(int i = 0; i < tillNo; i++){
			Till till = new Till();
			till.setNo(i+1);
			tillList.add(till);
		}
	}
	
	public void tick(int tick){
		//generate vehicles and add to correct queue
		//vehicle stores time of arrival
		generateVehicle();
		//goes through each vehicle in the pumps asking it whether it wants to do anything
		scanPumpsForChanges(tick);
		//goes through each vehicle in the tills asking whether it wants to do anything
		scanTillsForChanges(tick);
	}
	
	/**
	 * Goes through each vehicle in the pumps asking whether it wants to do anything
	 * @param tick the current tick
	 */
	public void scanPumpsForChanges(int tick){
		for(Pump pumps : pumpList){
				for(Iterator<Vehicle> v = pumps.getQueueArray().iterator(); v.hasNext();){
				  Vehicle vehicle = v.next();
				  vehicle.nextTickAction(tick);
				  /*if(vehicle.removeFromPump) {
					  //updates pump queue length
					  vehicle.getPump().setCurrentLength(vehicle.getPump().getCurrentLength() - vehicle.getLength());
				    v.remove(); // Removes the 'current' item
				  }*/
				}
		}
	}
	/**
	 * Goes through each vehicle in the tills asking whether it wants to do anything
	 * @param tick the current tick
	 */
	public void scanTillsForChanges(int tick){
		for(Till tills : tillList){
			for (Iterator<Vehicle> v = tills.getQueueArray().iterator(); v.hasNext(); ) {
			    Vehicle vehicle = v.next();
			    vehicle.nextTickAction(tick);	
			    if(vehicle.removeFromStation){
			    	vehicle.getPump().removeFirstItem();
			    	//vehicle.getTill().setCurrentLength(vehicle.getTill().getCurrentLength() - 1);
			    	v.remove();	
				}
			}
		}
	}
	/**
	 * Chooses the pump with the shortest queue for the vehicle
	 * @return the pump number
	 */
	public Pump choosePump(){
		double small = pumpList.get(0).getCurrentLength();
		int pumpNo = 0;
		for(int i = 1; i < (pumpList.size()); i++){
			if(pumpList.get(i).getCurrentLength() < small){
				small = pumpList.get(i).getCurrentLength();
				pumpNo = i;
			}
		}
		return pumpList.get(pumpNo);
	}
	/**
	 * Chooses the till with the shortest queue for the vehicle
	 * @return the till number
	 */
	public Till chooseTill(){
		double small = tillList.get(0).getCurrentLength();
		int tillNo = 0;
		int i;
		for(i = 1; i < (tillList.size()); i++){
			if(tillList.get(i).getCurrentLength() < small){
				small = tillList.get(i).getCurrentLength();
				tillNo = i;
			}
		}
		return tillList.get(tillNo);
	}
	/**
	* Called on each tick, will generate vehicles if the probability matches
	*/
	public void generateVehicle(){
		double chance = (rnd.nextInt(100)+1)/100.0;
		if(chance <= probabilityP)
		{
			Car vehicle = new Car(this);
			System.out.print("Created " + vehicle.getName() + ", ");
			this.incrementVehiclesGenerated();
			this.incrementCar();
			addVehicleToPump(vehicle);
		}
		if( chance > probabilityP && chance <= (probabilityP * 2))
		{
			Motorbike vehicle = new Motorbike(this);
			System.out.print("Created " + vehicle.getName() + ", ");
			this.incrementVehiclesGenerated();
			this.incrementMotorbike();
			addVehicleToPump(vehicle);
		}
		if(chance > (probabilityP * 2) && chance <= ((probabilityP * 2) + probabilityQ))
		{
			Sedan vehicle = new Sedan(this);
			System.out.print("Created " + vehicle.getName() + ", ");
			this.incrementVehiclesGenerated();
			this.incrementSedan();
			addVehicleToPump(vehicle);
		}
		if(isTruck)
		{
			if((chance > ((probabilityP * 2) + probabilityQ) && chance <= ((probabilityP * 2) + probabilityQ) + Truck.getProbabilityOfT())){
				Truck vehicle = new Truck(this);
				System.out.print("Created " + vehicle.getName() + ", ");
				this.incrementVehiclesGenerated();
				this.incrementTruck();
				addVehicleToPump(vehicle);
			}
		}
	}
	
	public static int incrementCar(){
		return Car++;
	}
	
	public static int incrementMotorbike(){
		return Motorbike++;
	}
	
	public static int incrementSedan(){
		return Sedan++;
	}
	
	public static void incrementTruck(){
		Trucks++;
	}
	
	/**

	 * Decides if the vehicle can be added to a pump, if there are no available pumps the loss calculation method is called
	 * @param vehicle a Vehicle to be added to a pump
	 * @return a boolean, which is true if the vehicle is sucessfully added to a queue and false otherwise
	 */

		public boolean addVehicleToPump(Vehicle vehicle){
		if(!pumpList.isEmpty()){
			if(choosePump().checkspace(vehicle.getLength())){			
				//set arrival in queue time
				vehicle.setPumpQueueArrival(Simulator.getTicks());
				//tells the vehicle what pump it is in
				vehicle.setPump(choosePump());
				//add to pump
				vehicle.getPump().add(vehicle);
				System.out.print(vehicle.getName() + " added to pump number: " + vehicle.getPump().getNo() + ". Length: " + vehicle.getPump().getCurrentLength() + ". ");				
				return true;
			}else{
				System.out.print(vehicle.getName() + " has not been added to a queue. ");
				vehicleLeaveBecauseQueueFull(vehicle);
				return false;
			}
		} return false;	
	}

	/**
	 * Adds a vehicle to a till
	 * @param tick the current tick
	 * @param vehicle the Vehicle to be added to the till
	 * @return a boolean, which is true if sucessfully added to till queue and false otherwise
	 */
	public boolean addToTill(int tick,Vehicle vehicle){
		if(!tillList.isEmpty()){
			//if(chooseTill().checkspace(vehicle.getLength())){
				vehicle.enterShopQueue(tick);
				vehicle.setTill(chooseTill());
				vehicle.getTill().add(vehicle);
				System.out.print(vehicle.getName() + " added to till number: " + vehicle.getTill().getNo() + ". Length: " + vehicle.getTill().getCurrentLength() + ". ");
				return true;
			//}else{
				//System.out.print(vehicle.getName() + " is waiting to join a till. ");
				//vehicle.getPump().removeFirstItem();
			//	return false;
			//}
		}return false;
	}
	/**
	* Calculates the loss using the tanksize loss and also the shopping amount
	* @param vehicle the Vehicle that will leave because the queue is full
	*/
	public void vehicleLeaveBecauseQueueFull(Vehicle vehicle){
		double newLoss = petrolPrice * vehicle.tankSize + vehicle.getShoppingMoney();
		loss += newLoss;
		System.out.print("at a loss of �" + newLoss);;
	}
	/**
	 * Removes the first item from the till arraylist
	 * @param till
	 */
	public void removeFromShop(Till till){
		till.removeFirstItem();
	}
	public void removeBeforeShop(Pump pump){
		pump.removeFirstItem();
	}
	/**
	*Gives the option to set the current price of petrol
	*/
	public void setPetrolPrice(double newPetrolPrice)
	{
	  	//Sets the price of the petrol to whatever the user enter into the simulator
		petrolPrice = newPetrolPrice;
	}
	/**
	*Calculate the total income generated
	*/
	public static double getIncome()
	{
	  return income; 
	}
	public static String getFormattedIncome(){

		return String.format("�" + "%,.2f", income);

	}
	public static void setIncome(double i){
		income = i;
	}
	/**
	*Returns the current price of petrol
	* @return petrolPrice
	*/
	public static double getPetrolPrice()
	{
	   return  petrolPrice; 
	}
	/**
	 * Returns the list of pumps
	 * @return pumpList
	 */
	public ArrayList<Pump> getPumpList(){
		return pumpList;
	}
	/**
	 * Returns the list of tills
	 * @return tillList
	 */
	public ArrayList<Till> getTillList(){
		return tillList;
	}
	/**
	 * Returns the formatted loss; � followed by loss formatted so it's in double format
	 * @return String The formatted loss
	 */
	public String getFormattedLoss(){

		return String.format("�" + "%,.2f", loss);

	}
	/**
	 * Returns the overall loss from the simulation
	 * @return loss
	 */
	public double getLoss(){
		return loss;
	}
	/**
	 * Returns whether trucks are used
	 * @return isTruck
	 */
	public boolean isTruck(){
		return isTruck;
	}
	/**
	 * Returns the number of happy trucks 
	 * @return happyTrucks
	 */
	public int happyTrucks(){
		return happyTrucks;
	}
	/**
	 * Returns the number of sad trucks
	 * @return sadTrucks
	 */
	public int sadTrucks(){
		return sadTrucks;
	}
	/**
	 * Returns the number of vehicles generated
	 * @return vehiclesGenerated
	 */
	public int vehiclesGenerated(){
		return vehiclesGenerated;
	}
	/**
	 * Increments the number of happy trucks by one
	 */
	public void incrementHappyTrucks(){
		happyTrucks++;
	}
	/**
	 * Increments the number of vehicles generated by one
	 */
	public void incrementVehiclesGenerated(){
		vehiclesGenerated++;
	}
	/**
	 * Increments the number of sad trucks by one 
	 */
	public void incrementSadTrucks(){
		sadTrucks++;
	}
}
