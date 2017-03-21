package cs1410;

public class Ticker {

	private int tick;
	private int maxTicks;
	
	public Ticker() {
		tick = 0;
		maxTicks = 1440;
	}
	
	/**
	 * @return the current tick
	 */
	public int getTick() {
		return tick;
	}
	
	/**
	 * Increment the tick by one if it is less than the maximum number of ticks
	 */
	public void increment() {
		if(tick < maxTicks) {
		tick++;
		}
	}
	
	/**
	 * Reset the ticks to zero
	 */
	public void reset() {
		tick = 0;
	}
	
}

