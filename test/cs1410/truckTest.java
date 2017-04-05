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
		station.addVehicleToPump(t1);
		assertEquals(5.0, station.getPumpList().get(0).getQueueArray().get(0).getRefillTime(), 0);
	}


	@Test
	public void testGetProbabilityOfT(){
		assertEquals(0.02, Truck.getProbabilityOfT(), 0);
	}

}
