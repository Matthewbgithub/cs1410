package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class tillsTest {
	Station station = new Station(2, 1, 0, 0, true);
	Till till = new Till();
	private Vehicle c1;
	private Vehicle c2;
	private Vehicle t1;


	
	@Before
	public void setUp(){
		
		c1 = new Car();
		c2 = new Car();
		t1 = new Truck();
	}

	@Test
	public void testAdd() {
		assertEquals(true, till.add(c1));
		assertEquals(1.0, till.getCurrentLength(), 0);
		
		assertEquals(true, till.add(c2));
		assertEquals(2.0, till.getCurrentLength(), 0);
		
		assertEquals(true, till.add(t1));
		assertEquals(3.0, till.getCurrentLength(), 0);
		
	}
	
	/* removed because getQueue is now unused
	@Test 
	public void testGetQueue(){
		assertEquals(till.q, till.getQueue());
	}
	*/
	@Test
	public void testGetNo() {
		till.setNo(1);
		assertEquals(1, till.getNo());
		till.setNo(2);
		assertEquals(2, till.getNo());
	}


		


}
