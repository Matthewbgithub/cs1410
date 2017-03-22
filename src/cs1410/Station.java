package cs1410;
import java.util.Random;
import java.util.ArrayList;

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
		/*if((rnd.nextInt(100)+1)/10 <= probabilityP){
			Car car = new Car();
			System.out.println("created car.");
			addVehicleToPump(car);
		}
		if((rnd.nextInt(100)+1)/10 <= probabilityP){
			Motorbike motorbike = new Motorbike();
			System.out.println("created motorbike");
			addVehicleToPump(motorbike);
		}*/
		if((rnd.nextInt(100)+1)/10 <= probabilityQ){
			Sedan sedan = new Sedan();
			System.out.println("created sedan");
			addVehicleToPump(sedan);
		}
		/*if(isTruck){
			if((rnd.nextInt(100)+1)/10 <= Truck.getProbabilityOfT()){
				Truck truck = new Truck();
				System.out.println("created truck");
				addVehicleToPump(truck);
			}
		}*/
	}
	/**
	* decides if the vehicle can be added to a pump, if there are no available pumps the loss calculation method is called
	*/
	private boolean addVehicleToPump(Vehicle vehicle){
		
		if(choosePump().getQueue().checkspace(vehicle.getLength())){
			System.out.println(vehicle.getName() + " has been added to " + choosePump().getQueue().toString() + " which has a current length of " + choosePump().getQueue().getCurrentLength());
			vehicle.setPumpEnterTickNo(Simulator.getTicks());
			vehicle.setPump(choosePump());
			vehicle.getPump().add(vehicle);
			System.out.println(vehicle.getPump().getQueue().toString());
			if(vehicle.fillComplete()){
				//enter shop
				income =+ vehicle.getTankSize() * petrolPrice;
				vehicle.setTill(chooseTill());
				vehicle.getTill().add(vehicle);
				vehicle.setTillEnterTickNo(Simulator.getTicks());
				if(vehicle.shopComplete()){
					System.out.println(vehicle.getName() + " has left after visiting the shop");
					removeFromShop(vehicle.getTill());
				}
			}else{
				//leave
				System.out.println(vehicle.getName() + " has left before entering the shop.");
				removeBeforeShop(vehicle.getPump());
			}
			
			/*if(vehicle.getName() == "Truck"){
				vehicle.changeProbability();
			}*/
			return true;
		}else{
			System.out.print(vehicle.getName() + " has not been added to a queue ");
			vehicleLeaveBecauseQueueFull(vehicle);
			return false;
		}
	}
	/**
	* calculates the loss using the tanksize loss and also the shopping amount
	*/
	private void vehicleLeaveBecauseQueueFull(Vehicle vehicle){
		double newLoss = petrolPrice * vehicle.tankSize + vehicle.getShoppingMoney();
		loss += newLoss;
		System.out.println("at a loss of " + newLoss);;
	}
	private void removeFromShop(Till till){
		till.getQueue().removeFirstItem("till");
	}
	private void removeBeforeShop(Pump pump){
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
