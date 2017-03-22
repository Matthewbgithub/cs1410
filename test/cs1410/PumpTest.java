package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PumpTest {

	ArrayList<Vehicle>vehicleArray = new ArrayList<Vehicle>();
	Queue pumpQueue = new Queue();
	
	Sedan s1 = new Sedan();
	Sedan s2 = new Sedan();
	
	@Test
	public void testAdd() {
		vehicleArray.add(s1);
		vehicleArray.add(s2);
		assertTrue(true, vehicleArray.size());
	}


	@Test
	public void testGetQueue() {
		fail("Not yet implemented");
	}

}
