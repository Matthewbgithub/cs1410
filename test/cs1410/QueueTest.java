package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QueueTest{
	ArrayList<Vehicle>vehicleArray = new ArrayList<Vehicle>();
	
	Car c1 = new Car();
	Car c2 = new Car();
	Car c3 = new Car();

	@Test
	public void testQueue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentLength(Queue queue) {
		vehicleArray.add(c1);
		vehicleArray.add(c2);
		vehicleArray.add(c3);
		assertEquals(3, queue.getCurrentLength());
	}

	@Test
	public void testCheckspace() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFirstItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}