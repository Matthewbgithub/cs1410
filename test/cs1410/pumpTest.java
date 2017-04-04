package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class pumpTest {
	Station station = new Station(1, 3, 0, 0, false);
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
		assertEquals(true, pump.add(c1));
		assertEquals(true, pump.add(c2));
		assertEquals(false, pump.add(s1));	
	}
	
	@Test 
	public void testRemoveFirstItem(){
		pump.add(c1);
		pump.add(s1);
		pump.removeFirstItem();
		//assertEquals(1.5, station.getPumpList().get(0).getCurrentLength(), 0);
		//
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
