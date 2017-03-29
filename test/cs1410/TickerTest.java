package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TickerTest {
	private Vehicle c1;
	
	Pump pump = new Pump();
	Till till = new Till();
	Ticker ticker = new Ticker(1440);

	@Before
	public void setUp(){
		c1= new Car();
		
		}
	
	@Test
	public void testGetTick() {
		Station station = new Station(2, 3, 0, 0, false);
		station.addToTill(1, c1);
		ticker.increment();
		assertEquals(1, ticker.getTick());
		ticker.increment();
		assertEquals(2, ticker.getTick());
		ticker.increment();
		assertEquals(3, ticker.getTick());
		
		
	}

	@Test
	public void testGetMaxTicks() {
		assertEquals(1440, ticker.getMaxTicks());
	}

	

	@Test
	public void testReset() {
		ticker.increment();
		assertEquals(1, ticker.getTick());
		ticker.increment();
		assertEquals(2, ticker.getTick());
		ticker.increment();
		assertEquals(3, ticker.getTick());
		ticker.reset();
		assertEquals(0, ticker.getTick());
	}

}
