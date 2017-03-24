package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class QueueTest{
	
<<<<<<< HEAD
=======
	//ArrayList<Vehicle>vehicleArray = new ArrayList<Vehicle>();
>>>>>>> origin/master
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
<<<<<<< HEAD
	queue.add(c1, "pump");
	queue.add(c2, "pump");
	queue.add(c3, "pump");
	assertEquals(3.0, queue.getCurrentLength());
	}
			

	
=======
		queue.add(c1, "pump");
		queue.add(c2, "pump");
		queue.add(c3. "pump");
		assertEquals(3, queue.getCurrentLength());
	}
>>>>>>> origin/master

	@Test
	public void testCheckspace() {
		queue.add(c1, "pump");
		queue.add(c2, "pump");
<<<<<<< HEAD
		queue.add(c3, "pump");
		//assertEquals(true, queue.checkSpace(3.00));
		assertEquals(false, queue.checkSpace(s1.getLength());
}
=======
		queue.add(c3. "pump");
		//assertEquals(true, queue.checkSpace(3.00));
		assertEquals(false, queue.checkSpace(s1.getLength());
	}
>>>>>>> origin/master

	@Test
	public void testRemoveFirstItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	

}
