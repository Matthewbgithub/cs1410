package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class pumpTest {
	Station station = new Station(3, 3, 0, 0, false);
	Pump pump = new Pump();
	private Car c1;
	private Car c2;
	private Sedan s1;
	
	@Before
	public void setUp(){
		c1 = new Car();
		c2 = new Car();
		s1 = new Sedan();
		
	}

	@Test
	public void testAdd() {
		assertEquals(pump.add(c1), pump.add(c1));
		//assertEquals(pump.pumpQueue.add(c2, "pump"), pump.add(c2));
		//assertEquals(false, pump.add(s1));
		
	}

	/*removed because getQueue is now unused
	@Test
	
	public void testGetQueue() {
		assertEquals(pump.q, pump.getQueue());
	}
	 */
	
	@Test
	public void testGetNo() {
		pump.setNo(1);
		assertEquals(1, pump.getNo());
		pump.setNo(2);
		assertEquals(2, pump.getNo());
	}

}
