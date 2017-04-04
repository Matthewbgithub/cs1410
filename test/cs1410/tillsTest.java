package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class tillsTest {
	Station station = new Station(2, 3, 0, 0, false);
	Till till = new Till();
	private Vehicle c1;


	
	@Before
	public void setUp(){
		
		c1 = new Car();

	}

	@Test
	public void testAdd() {
		assertEquals(till.add(c1), till.add(c1));
	}
	
	@Test 
	public void testGetQueue(){
		assertEquals(till.q, till.getQueue());
		
		
	}
	@Test
	public void testGetNo() {
		till.setNo(1);
		assertEquals(1, till.getNo());
		till.setNo(2);
		assertEquals(2, till.getNo());
	}


		


}
