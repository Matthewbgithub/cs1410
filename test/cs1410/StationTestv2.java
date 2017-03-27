package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
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
	
	@Before
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
		pump.add(c1);
		pump.add(c2);
		pump.add(c3);
		assertEquals(false, pump.getQueue().checkspace(0.75));
		assertEquals(3.0, pump.getQueue().getCurrentLength(), 0);		
	}

	public void testChoosePump(){
		
	}

}
