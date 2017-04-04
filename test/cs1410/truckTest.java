package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class truckTest {
	

	Truck truck = new Truck();
	Station station = new Station(1, 1, 1, 1, true);
	private Vehicle t1;

	
	
	@Before
	public void setUp(){
		t1= new Truck();
		
		}

	@Test
	public void testChangeProbability() {
		//truck.setRefillTime(5);
		Truck.happy();
		assertEquals(0.021, truck.getProbability(), 0);
		//says 1 for some reason
	}

	@Test
	public void testGetRefillTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testHappy() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnHappy() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProbabilityOfT(){
		assertEquals(0.02, Truck.getProbabilityOfT(), 0);
	}

}
