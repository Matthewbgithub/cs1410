package cs1410;

import static org.junit.Assert.*;

import org.junit.Test;

public class StationTestv2 {
	private Vehicle c1;
	private Vehicle c2;
	private Vehicle c3;
	private Vehicle m1;
	private Vehicle m2;
	private Vehicle s1;
	Vehicle vehicle = new Vehicle();
	Pump pump = new Pump();
	
	
	public void setUp(){
		c1 = new Car();
		c2 = new Car();
		c3 = new Car();
		m1 = new Motorbike();
		m2 = new Motorbike();
		s1 = new Sedan();
	}
	
	@Test
	public void testVehicleLeaveBecauseQueueFull() {
		Simulator simulator = new Simulator();
		Station station = new Station(1, 1, 0, 0, false);
		
		assertEquals(true, pump.add(c1));
		//assertEquals(true, station.addVehicleToPump(s1));
		//assertNotEquals(true, station.addVehicleToPump(m1));
		
	}

	@Test
	public void testGetIncome() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPetrolPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPumpList() {
		fail("Not yet implemented");
	}

}
