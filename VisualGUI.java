import java.util.ArrayList;
import java.util.Objects;

import OtherClasses.Queue;
import OtherClasses.Vehicle;

public class VisualGUI 
{
	private Queue queObject;
	private Vehicle vehObject;
	//This global variable will allow us to send the last entry in the array (gained from the lastVehicleEntry local variable located in the visualize method), to the LabelBank class so the correct label can be returned
	private Vehicle lastVehicleEntrySend;

	/*  - It will check the last of entry of the array by calling the 'getLastObject' method from the vehicle database class - NOTE: this method returns the string name of the last vehicle entered: so if it was a Car object - it will return "car"
							   - The method above that returns the string of the type of vehicle will be stored in a local variable call 'strLatestEntry' 
						           - This (the above) variable will be compared against an IF, Else If and Else statement;
									- The first IF will comapre it 'strLatestEntry' to "Car" using .equals("Small Car")
									- The ELSE IF will comapre it 'strLatestEntry' to "Family Sedan" using .equals("Family Sedan")
									- The 2nd ELSE IF will comapre it 'strLatestEntry' to "Family Sedan" using .equals("Motorbike")
									- The ELSE will NOT comapre it, as if it isn't Car or Family Sedan, it must be truck
								  1.) IF: The contents of the if statment will create a JLabel, called '[ANYNUBER CREATE BY A RANDOM NUMBER GENERATOR BETWEEN 1 AND 1000000]' - THIS IS DONE SO THE NAMES OF ALL THE JLABELS DONT CLASH WHEN NUMEROUES ARE CREATED. The image that will be set to this JLabel is a Car
								  2.) IF ELSE: The contents of the if statment will create a JLabel, called '[ANYNUBER CREATE BY A RANDOM NUMBER GENERATOR BETWEEN 1 AND 1000000]' - THIS IS DONE SO THE NAMES OF ALL THE JLABELS DONT CLASH WHEN NUMEROUES ARE CREATED. The image that will be set to this JLabel is a Family Sedan
								  3.) ELSE: The contents of the if statment will create a JLabel, called '[ANYNUBER CREATE BY A RANDOM NUMBER GENERATOR BETWEEN 1 AND 1000000]' - THIS IS DONE SO THE NAMES OF ALL THE JLABELS DONT CLASH WHEN NUMEROUES ARE CREATED. The image that will be set to this JLabel is a Truck*/
	
	
	public VisualGUI()
	{
		
		
	}
	
	public void visualize()
	{
		
		
		//The below line initializes a Queue object. This is so we can have access to the vehicle array
		
		//The below line creates a local array list so we can copy over the vehicle queue to this array list : note 'Object' is used as it's generic and can hold any object.
		
		ArrayList<Vehicle> arrHolder = new ArrayList<Vehicle>();
		//The line below allows in the calls the 'sendOver' from the Queue class - this methods returns the Vehicle array
		arrHolder = queObject.sendOver();
		
		
		
		//The below line of code gets the size of the array list and minuses it by 1 - this is a reference to the last index in the array - I've assigned it to a Vehicle object called lastVehicleEntry
		Vehicle lastVehicleEntry = arrHolder.get(arrHolder.size() -1);
		//The reason for this assignment is discussed in the comment above the declaration of the lastVehicleEntrySend above.  
		lastVehicleEntrySend = lastVehicleEntry;
		
		//This first if statement checks that the last object in the array is of Car type - we need to know this to know what Label to create
		if (lastVehicleEntry instanceof Car)
		{
			//a method called something like : makeCarLabel - this method will check the isUsed array, then the labelBank array, then create, and add the label to the GUI
			
			
		}
		
		
		//This first else if statement checks that the last object in the array is of Sedan type - we need to know this to know what Label to create
		else if()
		{
			//a method called something like : makeSedanLabel - this method will check the isUsed array, then the labelBank array, then create, and add the label to the GUI
		}
		
		
		//This second else if statement checks that the last object in the array is of Truck type - we need to know this to know what Label to create
		else if()
		{
			//a method called something like : makeTruckLabel - this method will check the isUsed array, then the labelBank array, then create, and add the label to the GUI
			
		}
		//We obviously don't need another if else, as if it's not of the three previously checked types (Car, Sedan and Truck), then it's of Motorbike type
		else
		{
			//a method called something like : makeMotorBikeLabel - this method will check the isUsed array, then the labelBank array, then create, and add the label to the GUI
			
		}
		
		
		
		
		
	}
	
	//This method will be called by the LabelBank class, as it returns the variable(lastVehicleEntrySend) that holds the last object in the Queue array.
	public Vehicle sendLastObject()
	{
		
		return lastVehicleEntrySend;
		
	}

}
