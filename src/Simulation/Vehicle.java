package Simulation;


import java.util.Random;
/**
 * A superclass which holds all the relevant fields and methods that will be used by the subclasses(specific vehicle types)
 * @author 
 * @version 1.00
 */

public class Vehicle {
	protected int tankSize;
	protected double shoppingProb;
	protected double shoppingMoney;
	protected double qSpace;
	protected int browseTime;
	protected double refillTime;
	protected Random rnd;
	protected String name;
	
	protected int pumpQueueArrival;
	protected int tillQueueArrival;
	protected int fillingStartTime;
	protected int browseStartTime;
	protected int creationTime;
	protected int timeStartPaying;
	
	protected int timeToRefillIn;
	protected Pump currentPump;
	protected Till currentTill;
	protected Station currentStation;
	
	protected boolean hasStartedFilling = false;
	protected boolean isShopping = false;
	protected boolean isInTheShopQueue = false;
	
	//protected boolean removeFromPump = false;
	protected boolean removeFromStation = false;
	protected boolean willBuyItems = false;
	protected boolean isBrowsing = false;
	protected boolean isPayingCurrently = false;
	
	protected boolean paid = false;
	protected int timeInTill;
	
	public Vehicle(){
		rnd = new Random();
		creationTime = Simulator.getTicks();
		timeInTill = rnd.nextInt(7)+12;
	}

//other
	protected void nextTickAction(int tick){
		if(isShopping){
			//is at the front of queue and will pay then leave
			if(!paid){
				if(!isPayingCurrently){
					startPaying(tick);
				}
				//add the money
				if( (timeStartPaying + timeInTill) < tick){
					spendFilling();
					if(willBuyItems){
						spendShopping();
					}
					//then leave both the till and the pump
					System.out.print(this.getName() + " paid and left shop.");
					removeFromStation = true;
				}
			}
		}else if(isInTheShopQueue){
			//is at the front of the queue
			if(getTill().getQueueArray().get(0) == this){
				System.out.print(this.getName() + " is at the front of the queue. ");
				isInTheShopQueue = false;
				isShopping = true;
			}
		}else if(isBrowsing){
			//this is only so that it counts the start time only once
			if(hasStartedFilling){
				setbrowseStartTime(tick);
				//System.out.print("(" + this.getName() + " shopstart = " + browseStartTime + ")");
			}
			hasStartedFilling = false;
			if(willBuyItems){
				double tickBrowseShouldBeDone = browseStartTime + browseTime;
				if( tickBrowseShouldBeDone < tick){
					if (this.getName().equals("Truck")){
						Truck.happy();
						this.currentStation.incrementHappyTrucks();
						System.out.print("happy truck"+ Truck.getProbabilityOfT());
					}
					//move into till
					if(currentStation.addToTill(tick, this)){
						System.out.print(this.getName() + " gone into till " + this.getTill().getNo() + ". ");
						isInTheShopQueue = true;
						isBrowsing = true;
					}else{
						System.out.print(this.getName() + " is waiting for a till. ");
					}
				}
			}
		}
		else if(hasStartedFilling){
			//is filling up
			double timeFillingShouldBeDone = fillingStartTime + tankSize;
			if( timeFillingShouldBeDone < tick){
				//finished filling up
				if(goesToShop()){
					willBuyItems = true;
					System.out.print(this.getName() + " is currently browsing. ");
					//will go to browsing
					isBrowsing = true;
					if (this.getName().contains("Truck")){
						Truck.happy();
						this.currentStation.incrementHappyTrucks();
						System.out.print("Happy truck" + Truck.getProbabilityOfT());
					}
				}else{
					willBuyItems = false;
					
					if(currentStation.addToTill(tick, this)){
						System.out.print(this.getName() + " is in the shop to pay for fuel. ");
						//will go to the shop queue
						isInTheShopQueue = true;
					}else{
						System.out.println(this.getName() + " is waiting for a till. ");
						//throw new RuntimeException();
					}
					if (this.getName().contains("Truck")){
						Truck.unHappy();
						this.currentStation.incrementSadTrucks();
						System.out.print("Sad truck" + Truck.getProbabilityOfT());
					}
				}
			}
		}else{
		//is in the queue to begin filling up
			//if at the front of the queue
			if(getPump().getQueueArray().get(0) == this){
				startsFilling(tick);
			}
		}
	}
	private void startPaying(int tick){
		timeStartPaying = tick;
		isPayingCurrently = true;
	}
	public boolean staysToShop(){
		if(rnd.nextDouble()<= shoppingProb){
			return true;
		}else{
			return false;
		}
	}
	private boolean goesToShop(){
		double refillTimeTaken = (fillingStartTime - pumpQueueArrival + tankSize)/6;
		if(refillTimeTaken < timeToRefillIn && ( rnd.nextInt(10)+1)/10 <= getProbability()){
			return true;
		}else{
			return false;
		}
	}
	private void spendFilling(){
		Station.setIncome(Station.getIncome() + (tankSize * Station.getPetrolPrice()));
		paid = true;
	}
	private void spendShopping(){
		Station.setIncome(Station.getIncome() + getShoppingMoney());
		paid = true;
	}
		
	protected void startsFilling(int tick){
		hasStartedFilling = true;
		fillingStartTime = tick;
	}
	protected void enterShopQueue(int tick){
		tillQueueArrival = tick;
	}
	protected void setTillQueueArrival(int tickNo){
		tillQueueArrival = tickNo;
	}
	protected void setPumpQueueArrival(int tickNo){
		pumpQueueArrival = tickNo;
	}
	protected void setFillingStartTime(int tickNo){
		fillingStartTime = tickNo;
	}
	protected void setbrowseStartTime(int tickNo){
		browseStartTime = tickNo;
	}
	protected void setPump(Pump p){
		currentPump = p;
	}
	protected void setTill(Till t){
		currentTill = t;
	}
	
	public Pump getPump(){
		return currentPump;
	}
	public Till getTill(){
		return currentTill;
	}
	public String getName(){
		return name + creationTime;
	}
	public double getLength(){
		return qSpace;
	}
	
	public double getProbability(){
		return shoppingProb;
	}
	public double getShoppingMoney(){
		return shoppingMoney;
	}
	/*private int getTankSize(){
	return this.tankSize;
	}
	/*private boolean removeFromStation(){
		return removeFromStation;
	}
	
	/*private boolean hasStartedFilling(){
		return hasStartedFilling;
	}
	private boolean isInTheShop(){
		return isShopping;
	}*/
	
}
