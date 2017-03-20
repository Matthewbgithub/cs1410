
public class LabelBank
{
	private int intIsNotUsedIndex;
	public LabelBank ()
	{
		//The isUsed boolean array needs to be constructed, and it's values added
		//The labelBank JLabel array needs to be constucted, and it's values added
		
		
	}
	
	//First method return a free slot (false) in the isUsed array of boolean type: findNonUsed();
	//This method needs to know what the last object in the Queue array to know what range to search for;
	// Car: 0-9 index reservation. Sedan :10-19 index reservation. Truck: 20-29 index reservation. Motorbike: 30 -39 index reservation.
	// For example - if index 5 of the array slot is free - the index of this 'false' reutrn (index 5), will be assigned to the global variable 'intIsNotUsedIndex'
	
	public void intIsNotUsedIndex()
	{
		//The below line creates an instancceo f the visual GUI class so we can call the sendLastObject method
		VisualGUI temp = new VisualGUI();
		//The below variable is used to hold the index number of a false value return from the cars index range of 0-9
		int intCarLabelNotUsed = 0;
		//The below variable is used to hold the index number of a false value return from the sedans index range of 10-19
		int intSedanLabelNotUsed = 0;
		//The below variable is used to hold the index number of a false value return from the trucks index range of 20-29
		int intTruckLabelNotUsed = 0;
		//The below variable is used to hold the index number of a false value return from the motorbike index range of 30-39
		int intMotorbikeLabelNotUsed = 0;
		
		
		//If the last object in the array is an instance of the Car object, then iterate through index 0-9 in the isUsed array, if a value within the 0-9 indexes is false, return the INDEX NUMBER of that, and change it to True
		//We need to change it's value to true - because it IS GOING TO BE USED NOW.
		if (temp.sendLastObject() instanceof Car)
		{
			//Iterator: iterates index 0-9 then returns the index number in a local varaible 'intCarLabelNotUsed'
			for (int a < 9; )
			//Nested if statment to create the label based on the intCarLabelNotUsed number
		}
		else if()
		{}
		else if ()
		{}
		
	}
	
	//Second method

}
