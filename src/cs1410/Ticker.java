package cs1410;

public class Ticker {

	private int tick;
	
	public Ticker() {
		tick = 0;
	}
	
	/**
	 * @return the current tick
	 */
	public int getTick() {
		return tick;
	}
	
	/**
	 * Increment the tick by one
	 */
	public void increment() {
		tick++;
	}
	
	/**
	 * Reset the ticks to zero
	 */
	public void reset() {
		tick = 0;
	}
	
}

