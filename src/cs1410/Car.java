package cs1410;

public class Car {
	private int tankSize;
	private double probability;
	private int qSpace;
	
	public void Car(){
		
	}
	
//Set methods------
	public void setProbability(double prob){
		this.probability = prob;
	}
	
//Get methods------
	public int getLength(){
		return qSpace;
	}
	public int getTankSize(){
		return this.tankSize;
	}
	public double getProbability(){
		return this.probability;
	}
}
