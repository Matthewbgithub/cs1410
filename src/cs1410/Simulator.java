package cs1410;
import java.util.Random;

public class Simulator
{
	private  int intIncome;
	private  int intLoss;
	private int intPetrolPrice;
	private Random ranNumGenerator;
	
	
	public static void main(String[] args)
	{
		//adds some things to a queue 
	Car car1 = new Car();
	Motorbike bike1 = new Motorbike();
	Truck truck1 = new Truck();
	Queue q1 = new Queue();
	q1.add(car1);
	System.out.println("current length: " + q1.getCurrentLength());
	q1.add(bike1);
	q1.add(truck1);
	System.out.println(q1.toString());
	q1.checkspace(car1);
	q1.add(car1);
	System.out.println(q1.checkspace(car1));
	System.out.println("current length: " + q1.getCurrentLength());
	q1.removeFirstItem();
	System.out.println("current length: " + q1.getCurrentLength());
	q1.removeFirstItem();
	System.out.println("current length: " + q1.getCurrentLength());
	q1.removeFirstItem();
	System.out.println("current length: " + q1.getCurrentLength());
	q1.removeFirstItem();
	System.out.println("current length: " + q1.getCurrentLength());
	q1.removeFirstItem();
	System.out.println("current length: " + q1.getCurrentLength());

	
	System.out.println(car1.getTankSize());
	}
	
	//Allows vehicle to choose queue - most likely will envoke the smallest queue method
	public Queue chooseQueue()
	{
		return null;
	}
	
	//Return the total number of ticks that have gone past so far (time)
	public int getTicks()
	{
	  return  0; 
	}
	
	//Calculate the total income generated
	public int calcIncome()
	{
	  return 0; 
	}
	
	//Returns the current price of petrol
	public int getPetrolPrice()
	{
	   return  0; 
	}
	
	//Gives the option to set the current price of petrol
	public int setPetrolPrice(int newPetrolPrice)
	{
	  	//Sets the price of the petrol to whatever the user enter into the simulator
		intPetrolPrice = newPetrolPrice;
		return 0;
	}
	
	// Checks if the queues are full: the amount of queues are based on the amount of pumps (use enters this)
	// Return true if the queues are full
	// So: queue.size compared against the size we intially set for it
	public boolean checkQueueIsFull()
	{
	return false;
	
	}
	
	// Checks the size of all queues, and return the smallest
	public Queue searchSmallest()
	{
	 	 /*e.g. 
		
		"int TempOne = (QueueOne.Size) minus 10"
	        "int TempTwo = (Queuetwo.Size) minus 10"
			
		"TempOne *Comparison* TempTwo"
			
			"Return Queue X"
		etc......*/
		return null;
	
	}
	
	
}
