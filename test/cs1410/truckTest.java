package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class truckTest {
	
	private Vehicle t1;
	private Station station;

	@Before
	public void setUp(){
		t1= new Truck();
		station = new Station(1, 1, 1, 1, true);
		}


	@Test
	public void testGetRefillTime() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetProbabilityOfT(){
		assertEquals(0.02, Truck.getProbabilityOfT(), 0);
	}

}
