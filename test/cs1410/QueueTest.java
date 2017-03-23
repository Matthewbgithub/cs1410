package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QueueTest{
	
	ArrayList<Vehicle>vehicleArray = new ArrayList<Vehicle>();
	Queue queue = new Queue();
	private final int qLength=3;
	private double currentLength=0.0;
	
	Car c1 = new Car();
	Car c2 = new Car();
	Car c3 = new Car();
	Motorbike m1 = new Motorbike();
	Motorbike m2 = new Motorbike();
	Sedan s1 = new Sedan();
	Sedan s2 = new Sedan();
	Truck t1 = new Truck();

	

	@Test
	public void testGetCurrentLength() {
		vehicleArray.add(c1);
		vehicleArray.add(c2);
		vehicleArray.add(c3);
		assertEquals(3, vehicleArray.size());
		
		vehicleArray.add(m1);
		vehicleArray.add(s1);
		vehicleArray.add(s2);
		assertEquals(3, qLength);
			

	}

	@Test
	public void testCheckspace() {
		vehicleArray.add(c1);
		vehicleArray.add(c2);
		vehicleArray.add(c3);
		currentLength = 3.0;
		vehicleArray.add(m1);
		//assertEquals(false , Queue.checkSpace());
	}

	@Test
	public void testRemoveFirstItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	

}
