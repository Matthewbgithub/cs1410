package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QueueTest{
	

	Queue queue = new Queue();
	
	
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

	queue.add(c1, "pump");
	queue.add(c2, "pump");
	queue.add(c3, "pump");
	assertNotEquals(2.0, queue.getCurrentLength());
	assertNotEquals(4.0, queue.getCurrentLength());
	assertEquals(3.0, queue.getCurrentLength(), 0);
	}


@Test
	public void testCheckspace() {
		queue.add(c1, "pump");
		queue.add(c2, "pump");
		assertEquals(false, queue.checkspace(1.5));
		assertEquals(true, queue.checkspace(0.75));
}

		
		

	@Test
	public void testRemoveFirstItem() {
		queue.add(s1, "pump");
		queue.add(m1, "pump");
		queue.add(m2, "pump");
		assertEquals(1.5, queue.removeFirstItem("pump"));
		
	}

	@Test
	public void testAdd() {
		queue.add(c1, "pump");

		assertEquals(true, queue.add(m1,  "pump"));
		assertEquals(false, queue.add(s1, "pump"));

		assertEquals(true, queue.add(c3, "tills"));
	}

	

}
