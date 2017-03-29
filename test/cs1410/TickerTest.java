package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TickerTest {
	private Vehicle c1;
	private Vehicle c2;
	private Vehicle c3;
	private Vehicle m1;
	private Vehicle m2;
	private Vehicle s1;
	private Vehicle s2;
	Pump pump = new Pump();
	Till till = new Till();
	Ticker ticker = new Ticker();

	@Before
	public void setUp(){
		c1= new Car();
		c2= new Car();
		c3 = new Car();
		m1= new Motorbike();
		m2 = new Motorbike();
		s1 = new Sedan();
		s2 = new Sedan();
		}
	
	@Test
	public void testGetTick() {
		Station station = new Station(2, 3, 0, 0, false);
		station.addToTill(1, c1);
		assertEquals(1, ticker.getTick());
		
	}

	@Test
	public void testGetMaxTicks() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrement() {
		fail("Not yet implemented");
	}

	@Test
	public void testReset() {
		fail("Not yet implemented");
	}

}
