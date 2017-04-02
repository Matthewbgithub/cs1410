package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class pumpTest {
	Station station = new Station(3, 3, 0, 0, false);
	Pump pump = new Pump();
	private Vehicle c1;
	private Vehicle c2;
	private Vehicle s1;
	
	@Before
	public void setUp(){
		c1 = new Car();
		c2 = new Car();
		s1 = new Sedan();
		
	}

	@Test
	public void testAdd() {
		assertEquals(pump.pumpQueue.add(c1, "pump"), pump.add(c1));
		//assertEquals(pump.pumpQueue.add(c2, "pump"), pump.add(c2));
		//assertEquals(false, pump.add(s1));
		
	}

	@Test
	public void testGetQueue() {
		assertEquals(pump.pumpQueue, pump.getQueue());
	}

	
	@Test
	public void testGetNo() {
		pump.setNo(1);
		assertEquals(1, pump.getNo());
		pump.setNo(2);
		assertEquals(2, pump.getNo());
	}

}
