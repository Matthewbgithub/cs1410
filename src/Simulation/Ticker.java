package Simulation;


public class Ticker {

	private int tick;
	private static int maxTicks;
	
	public Ticker(int time) {
		maxTicks = time;
		reset();
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
