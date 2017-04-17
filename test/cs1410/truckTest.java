package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class truckTest {
	
	private Vehicle t1;
	private Station station;
	Truck truck= new Truck();

	@Before
	public void setUp(){
		t1= new Truck();
		station = new Station(1, 1, 1, 1, true);
		}

	@Test
	public void testGetRefillTime() {
		truck.setRefillTime(5);
		station.addVehicleToPump(t1);
		assertEquals(5.0, truck.getRefillTime(), 0);	
	}

	@Test
	public void testGetProbabilityOfT(){
		assertEquals(0.02, Truck.getProbabilityOfT(), 0);
	}
	
	@Test
	public void testGenerate() {
	
		station.addVehicleToPump(t1);
		assertEquals("Truck0", station.getPumpList().get(0).getQueueArray().get(0).getName());
		assertEquals(2.0, station.getPumpList().get(0).getQueueArray().get(0).getLength(), 0);
		assertEquals(1.0, station.getPumpList().get(0).getQueueArray().get(0).getProbability(), 0);
		assertNotEquals(29, station.getPumpList().get(0).getQueueArray().get(0).getTankSize(), 0);
		assertNotEquals(41, station.getPumpList().get(0).getQueueArray().get(0).getTankSize(), 0);

}
}
