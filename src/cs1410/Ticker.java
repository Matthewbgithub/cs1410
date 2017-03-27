package cs1410;

public class Ticker {

	private int tick;
	private static final int maxTicks = 1440;
	
	public Ticker() {
		tick = 0;
	}
	
	/**
	 * @return the current tick
	 */
	public int getTick() {
		return tick;
	}
	
	public int getMaxTicks() {
		return maxTicks;
	}
	
	/**
	 * Increment the tick by one if it is less than the maximum number of ticks
	 */
	public void increment() {
		if(tick <= maxTicks) {
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
