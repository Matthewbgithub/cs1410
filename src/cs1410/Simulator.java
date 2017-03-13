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
	Car car1 = new Car();
	System.out.println(car1.getProbability());
	}
	
	//Allows vehicle to choose queue - most likely will envoke the smallest queue method
	public Queue chooseQueue()
	{
		return null;
	}
	
	//Return the total number of ticks that have gone past so far (time)
	public integer getTicks()
	{
	
	  return  null; 
	
	
	}
	
	//Calculate the total income generated
	public integer calcIncome()
	{
	
	  return  null; 
	
	
	}
	
	//Returns the current price of petrol
	public int getPetrolPrice()
	{
	   return  null; 
	
	}
	
	//Gives the option to set the current price of petrol
	public int setPetrolPrice(int newPetrolPrice)
	{
	  	//Sets the price of the petrol to whatever the user enter into the simulator
		intPetrolPrice = newPetrolPrice;
	
	}
	
	// Checks if the queues are full: the amount of queues are based on the amount of pumps (use enters this)
	// Return true if the queues are full
	// So: queue.size compared against the size we intially set for it
	public boolean checkQueuesFull()
	{
	
	
	}
	
	// Checks the size of all queues, and return the smallest
	public Queue searchSmallest()
	{
	 	 //e.g. 
		
		"int TempOne = (QueueOne.Size) minus 10"
	        "int TempTwo = (Queuetwo.Size) minus 10"
			
		"TempOne *Comparison* TempTwo"
			
			"Return Queue X"
		//etc......
	
	}
	
	
}
