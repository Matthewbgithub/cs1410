package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PumpTest {

	ArrayList<Vehicle>vehicleArray = new ArrayList<Vehicle>();
	Queue pumpQueue = new Queue();
	private final int qLength=3;
	private double currentLength=0.0;
	
	Sedan s1 = new Sedan();
	Sedan s2 = new Sedan();
	Sedan s3 = new Sedan();
	
	@Test
	public void testAdd() {
		pumpQueue.add(s1, null);
		//pumpQueue.add(s2, null);
		//currentLength = 3.0;
		assertEquals(s1, pumpQueue);
	}


	@Test
	public void testGetQueue() {
		fail("Not yet implemented");
	}

}
