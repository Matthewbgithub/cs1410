package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

	
public class SedanTest {

	private Vehicle s1;
	Vehicle vehicle = new Vehicle();
	Station station = new Station(1, 1, 0, 0, false);
	Sedan sedan = new Sedan();
	
	@Before
	public void setUp(){
	s1 = new Sedan();
	}
	
	@Test
	public void testGenerate() {
		Station station = new Station(1, 1, 0, 0, false);
		station.addVehicleToPump(s1);
		assertEquals("Sedan0", station.getPumpList().get(0).getQueueArray().get(0).getName());
		assertEquals(1.5, station.getPumpList().get(0).getQueueArray().get(0).getLength(), 0);
		//assertEquals(10, station.getPumpList().get(0).getQueueArray().get(0).getRefillTime(), 0);
		assertEquals(0.4, station.getPumpList().get(0).getQueueArray().get(0).getProbability(), 0);
		assertNotEquals(19, station.getPumpList().get(0).getQueueArray().get(0).getTankSize(), 0);
		assertNotEquals(11, station.getPumpList().get(0).getQueueArray().get(0).getTankSize(), 0);
		
	}

}
