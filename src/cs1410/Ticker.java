package cs1410;

public class Ticker {

  	private int tick;
	
	public Ticker() {
		tick = 0;
	}
	
	public int getTick() {
		return tick;
	}
	
	public void increment() {
		tick++;
	}
	
	public void reset() {
		tick = 0;
	}
  
}
