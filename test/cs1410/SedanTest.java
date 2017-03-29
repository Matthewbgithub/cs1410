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
		s1 = new Sedan();
		//station.addVehicleToPump(s1);
		assertEquals("Sedan", vehicle.getName());
	}

}
