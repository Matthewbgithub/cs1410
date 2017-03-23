package cs1410;

import java.util.Iterator;
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
	protected int shoppingTime;
	protected double refillTime;
	protected Random rnd;
	protected String name;
	
	protected int pumpQueueArrival;
	protected int tillQueueArrival;
	protected int fillingStartTime;
	protected int shoppingStartTime;
	
	protected int timeToRefillIn;
	protected Pump currentPump;
	protected Till currentTill;
	protected Station currentStation;
	
	protected boolean hasStartedFilling = false;
	protected boolean isShopping = false;
	protected boolean isInTheShopQueue = false;
	
	protected boolean removeFromPump = false;
	protected boolean removeFromTill = false;
	
	protected boolean paid = false;
	public Vehicle(){
		rnd = new Random();
		
	}
	

//other
	protected void nextTickAction(int tick){
		if(isShopping){
			isInTheShopQueue = false;
			//actions when inside the shop
			if(!paid){
				double tickShopShouldBeDone = tillQueueArrival + shoppingTime;
				if( tickShopShouldBeDone < tick){
					//add the money
					spend();
					//then leave both the till and the pump
					System.out.println(this.getName() + " has left the shop and pump.");
					removeFromPump = true;
					removeFromTill = true;
				}
			}
		}else if(isInTheShopQueue){
			//is queuing for the shop
			hasStartedFilling = false;
			if(getTill().getQueue().getArray().get(0) == this){
				enterShopQueue(tick);
			}
		}else if(hasStartedFilling){
			//is filling up			
			double timeFillingShouldBeDone = pumpQueueArrival + tankSize;
			if( timeFillingShouldBeDone < tick){
				if(goesToShop()){
					//need to check if full--------------------------------------------------------------------------------------
					currentStation.addToTill(tick, this);
					//-----------------------------------------------------------------------------------
					System.out.println(this.getName() + " has entered the shop.");
				}else{
					System.out.println(this.getName() +" has left before going to the shop.");
					removeFromPump = true;
				}
			}
		}else{
		//is in the queue to begin filling up
			//if at the front of the queue
			if(getPump().getQueue().getArray().get(0) == this){
				startsFilling(tick);
			}
		}
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
	private void spend(){
		Station.setIncome(Station.getIncome() + getShoppingMoney());
		paid = true;
	}
	public void changeProbability(){
	}
//Set methods-------------------------------------------
	protected void startsFilling(int tick){
		hasStartedFilling = true;
		fillingStartTime = tick;
	}
	protected void enterShopQueue(int tick){
		isShopping = true;
		tillQueueArrival = tick;
	}
	protected void setTillQueueArrival(int tickNo){
		tillQueueArrival = tickNo;
	}
	/*public void setProbability(double prob){
		this.shoppingProb = prob;
	}*/
	protected void setPumpQueueArrival(int tickNo){
		pumpQueueArrival = tickNo;
	}
	protected void setFillingStartTime(int tickNo){
		fillingStartTime = tickNo;
	}
	protected void setShoppingStartTime(int tickNo){
		shoppingStartTime = tickNo;
	}
	protected void setPump(Pump p){
		currentPump = p;
	}
	protected void setTill(Till t){
		currentTill = t;
	}
	
//Get methods------------------------------------------
	protected boolean removeFromPump(){
		return removeFromPump;
	}
	protected boolean removeFromTill(){
		return removeFromTill;
	}
	protected boolean hasStartedFilling(){
		return hasStartedFilling;
	}
	protected boolean isInTheShop(){
		return isShopping;
	}
	public Pump getPump(){
		return currentPump;
	}
	public Till getTill(){
		return currentTill;
	}
	/*public int getTimeToRefillIn(){
		return timeToRefillIn;
	}*/
	public String getName(){
		return name;
	}
	public double getLength(){
		return qSpace;
	}
	public int getTankSize(){
		return this.tankSize;
	}
	public double getProbability(){
		return shoppingProb;
	}
	public double getShoppingMoney(){
		return shoppingMoney;
	}
	public double getShoppingTime(){
		return shoppingTime;
	}
	public double getRefillTime(){
		return refillTime;	
	}
	protected int getPumpArrival(){
		return pumpQueueArrival;
	}
	protected int getFillingStartTime(){
		return fillingStartTime;
	}
}
