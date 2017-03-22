package cs1410;

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
	static final int shopQSpace = 1;
	protected Random rnd;
	protected String name;
	protected int pumpEnterTickNo;
	protected int tillEnterTickNo;
	protected int startFillingTickNo;
	protected int timeToRefillIn;
	protected Pump currentPump;
	protected Till currentTill;
	
	public Vehicle(){
		rnd = new Random();
	}
	
//Set methods------
	protected void setTillEnterTickNo(int tickNo){
		tillEnterTickNo = tickNo;
	}
	public void setProbability(double prob){
		this.shoppingProb = prob;
	}
	protected void setPumpEnterTickNo(int tickNo){
		pumpEnterTickNo = tickNo;
	}
	protected void setStartFillingTickNo(int tickNo){
		startFillingTickNo = tickNo;
	}
	protected void setPump(Pump p){
		currentPump = p;
	}
	protected void setTill(Till t){
		currentTill = t;
	}
	
//Get methods------
	public Pump getPump(){
		return currentPump;
	}
	public Till getTill(){
		return currentTill;
	}
	public int getTimeToRefillIn(){
		return timeToRefillIn;
	}
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
	
	public double getShopQSpace(){
		return shopQSpace;
	}
	protected int getPumpEnterTickNo(){
		return pumpEnterTickNo;
	}
	protected int getStartFillingTickNo(){
		return startFillingTickNo;
	}
//other
	protected boolean fillComplete(){
		//start to fill minus enter queue time to get wait time
		//add the fill time to that
		double start = getStartFillingTickNo();
		double enter = getPumpEnterTickNo();
		double tank = getTankSize();
		
		double timeTaken = (enter + tank);
		int cTicks = Simulator.getTicks();;
		while( timeTaken > cTicks){
			//wait
			//System.out.println("waiting....");
			cTicks = Simulator.getTicks();
			Simulator.incrementTick();
		}
		double time12 = timeTaken /6;
		//rnd.nextInt(10)+1)/10
		if(time12 < getTimeToRefillIn() && ( 0.1<= getProbability())){
			//enter shop
			return true;
		}else{
			//leaves shop
			return false;
		}
	}
	
	protected boolean shopComplete(){
		//start to fill minus enter queue time to get wait time
		//add the fill time to that
		int time = ((Simulator.getTicks() * 6) * getTimeToRefillIn());
		while( getStartFillingTickNo() < time){
			//wait
			//System.out.println("waiting....");
			Simulator.incrementTick();
		}
		spend();
		return true;
	}
	public boolean staysToShop(){
		if(rnd.nextDouble()<= shoppingProb){
			return true;
		}else{
			return false;
		}
	}
	private void spend(){
		Station.setIncome(Station.getIncome() + getShoppingMoney());
	}
	public void changeProbability(){
	}
}
