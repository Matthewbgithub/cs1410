package cs1410;
import java.util.ArrayList;
import java.util.Random;

public class Simulator
{
	private  int intIncome;
	private  int intLoss;
	private int intPetrolPrice;
	private Random ranNumGenerator;
	
	public static void main(String[] args)
	{
		Station station = new Station(3,3);
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
	
	
}
