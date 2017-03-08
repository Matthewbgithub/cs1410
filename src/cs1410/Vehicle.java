package cs1410;

public class Vehicle {
	protected int tankSize;
	protected double probability;
	protected int qSpace;
	
	public void Vehicle(){
		
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
		return probability;
	}
}
