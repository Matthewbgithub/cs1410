package cs1410;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

public class Station {
	private static double income;
	private double loss;
	private double petrolPrice;
	private double probabilityP;
	private double probabilityQ;
	private ArrayList<Pump> pumpList;
	private ArrayList<Till> tillList;
	private Random rnd;
	private boolean isTruck;
	
	public Station(int pumpNo, int tillNo, double p, double q, boolean isTruck){
		probabilityP = p;
		probabilityQ = q;
		pumpList = new ArrayList<Pump>();
		tillList = new ArrayList<Till>();
		rnd = new Random();
		this.isTruck = isTruck;
		
		for(int i = 0; i < pumpNo; i++){
			Pump pump = new Pump();
			pumpList.add(pump);
		}
		for(int i = 0; i < tillNo; i++){
			Till till = new Till();
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
	
	//goes through each vehicle in the pumps asking it whether it wants to do anything
	public void scanPumpsForChanges(int tick){
		for(Pump pumps : pumpList){
				/*for(Vehicle vehicles : pumps.getQueue().getArray()){
					//System.out.println(vehicles.getName()+" is being checked for actions from a pump");
					vehicles.nextTickAction(tick);
				}*/
				
				for(Iterator<Vehicle> v = pumps.getQueue().getArray().iterator(); v.hasNext();){
				  Vehicle vehicle = v.next();
				  vehicle.nextTickAction(tick);
				  if(vehicle.removeFromPump) {
					  //updates pump queue length
					  vehicle.getPump().getQueue().setCurrentLength(vehicle.getPump().getQueue().getCurrentLength() - vehicle.getLength());
				    v.remove(); // Removes the 'current' item
				  }
				}
		}
	}
	//goes through each vehicle in the tills asking whether it wants to do anything
	public void scanTillsForChanges(int tick){
		for(Till tills : tillList){
			/*for(Vehicle vehicles : tills.getQueue().getArray()){
				//System.out.println(vehicles.getName()+" is being checked for actions from a till");
				vehicles.nextTickAction(tick);
			}*/
			for (Iterator<Vehicle> v = tills.getQueue().getArray().iterator(); v.hasNext(); ) {
			    Vehicle vehicle = v.next();
			    vehicle.nextTickAction(tick);	
			    if(vehicle.removeFromTill && vehicle.removeFromPump){
			    	vehicle.getPump().getQueue().removeFirstItem("pump");
			    	vehicle.getTill().getQueue().setCurrentLength(vehicle.getTill().getQueue().getCurrentLength() - 1);
			    	v.remove();	
				}
			}
		}
	}
	public Pump choosePump(){
		double small = pumpList.get(0).getQueue().getCurrentLength();
		int pumpNo = 0;
		int i;
		for(i = 1; i < (pumpList.size()); i++){
			if(pumpList.get(i).getQueue().getCurrentLength() < small){
				small = pumpList.get(i).getQueue().getCurrentLength();
				pumpNo = i;
			}
		}
		return pumpList.get(pumpNo);
	}
	public Till chooseTill(){
		double small = tillList.get(0).getQueue().getCurrentLength();
		int tillNo = 0;
		int i;
		for(i = 1; i < (tillList.size()); i++){
			if(tillList.get(i).getQueue().getCurrentLength() < small){
				small = tillList.get(i).getQueue().getCurrentLength();
				tillNo = i;
			}
		}
		return tillList.get(tillNo);
	}
	/**
	* Called on each tick, will generate vehicles if the probability matches
	*/
	public void generateVehicle(){
		if((rnd.nextInt(100)+1)/10 <= probabilityP){
			Car car = new Car(this);
			System.out.println("created car.");
			addVehicleToPump(car);
		}
		if((rnd.nextInt(100)+1)/10 <= probabilityP){
			Motorbike motorbike = new Motorbike(this);
			System.out.println("created motorbike");
			addVehicleToPump(motorbike);
		}
		if((rnd.nextInt(100)+1)/10 <= probabilityQ){
			Sedan sedan = new Sedan(this);
			System.out.println("created sedan");
			addVehicleToPump(sedan);
		}
		if(isTruck){
			if((rnd.nextInt(100)+1)/10 <= Truck.getProbabilityOfT()){
				Truck truck = new Truck(this);
				System.out.println("created truck");
				addVehicleToPump(truck);
			}
		}
	}
	/**
	* decides if the vehicle can be added to a pump, if there are no available pumps the loss calculation method is called
	*/
	private boolean addVehicleToPump(Vehicle vehicle){
		
		if(choosePump().getQueue().checkspace(vehicle.getLength())){
			
			//set arrival in queue time
			vehicle.setPumpQueueArrival(Simulator.getTicks());
			//tells the vehicle what pump it is in
			vehicle.setPump(choosePump());
			//add to pump
			vehicle.getPump().add(vehicle);
			System.out.println(vehicle.getName() + " has been added to " + vehicle.getPump().getQueue().toString() + " (pump) which has a current length of " + vehicle.getPump().getQueue().getCurrentLength());
			
			return true;
		}else{
			System.out.print(vehicle.getName() + " has not been added to a queue ");
			vehicleLeaveBecauseQueueFull(vehicle);
			return false;
		}
	}
	public boolean addToTill(int tick,Vehicle vehicle){
		if(chooseTill().getQueue().checkspace(vehicle.getLength())){
			vehicle.enterShopQueue(tick);
			vehicle.setTill(chooseTill());
			vehicle.getTill().add(vehicle);
			System.out.println(vehicle.getName() + " added to " + vehicle.getTill().getQueue().toString() + " (till) which has a current length of " + vehicle.getTill().getQueue().getCurrentLength());
			return true;
		}else{
			System.out.println("could not join a till queue as they were all full");
			vehicle.getPump().getQueue().removeFirstItem("pump");
			return false;
		}
	}
	/**
	* calculates the loss using the tanksize loss and also the shopping amount
	*/
	public void vehicleLeaveBecauseQueueFull(Vehicle vehicle){
		double newLoss = petrolPrice * vehicle.tankSize + vehicle.getShoppingMoney();
		loss += newLoss;
		System.out.println("at a loss of " + newLoss);;
	}
	public void removeFromShop(Till till){
		till.getQueue().removeFirstItem("till");
	}
	public void removeBeforeShop(Pump pump){
		pump.getQueue().removeFirstItem("pump");
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
	public static void setIncome(double i){
		income = i;
	}
	/**
	*Returns the current price of petrol
	*/
	public double getPetrolPrice()
	{
	   return  petrolPrice; 
	}
	public ArrayList<Pump> getPumpList(){
		return pumpList;
	}
	public ArrayList<Till> getTillList(){
		return tillList;
	}
	public double getLoss(){
		return loss;
	}
}
