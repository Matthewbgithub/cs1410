package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	private Vehicle c1;
	private Vehicle c2;
	private Vehicle c3;
	private Vehicle m1;
	private Vehicle m2;
	private Vehicle s1;

	Queue queue = new Queue();

	@Before
	public void setUp() {
		c1 = new Car();
		c2 = new Car();
		c3 = new Car();
		m1 = new Motorbike();
		m2 = new Motorbike();
		s1 = new Sedan();

	}

	@Test
	public void testGetCurrentLength() {

		assertEquals(true, queue.checkspace(1.0));
		queue.add(c1, "pump");
		assertEquals(true, queue.checkspace(1.0));
		queue.add(c2, "pump");
		assertEquals(true, queue.checkspace(1.0));
		queue.add(c3, "pump");
		assertNotEquals(2.0, queue.getCurrentLength());
		assertNotEquals(4.0, queue.getCurrentLength());
		assertEquals(3.0, queue.getCurrentLength(), 0);
	}

	@Test
	public void testCheckspace() {
		assertEquals(true, queue.checkspace(1.0));
		queue.add(c1, "pump");
		assertEquals(true, queue.checkspace(1.0));
		queue.add(c2, "pump");
		assertEquals(false, queue.checkspace(1.5));
		assertEquals(true, queue.checkspace(0.75));
	}

	@Test
	public void testRemoveFirstItem() {
		assertEquals(true, queue.checkspace(1.5));
		queue.add(s1, "pump");
		assertEquals(true, queue.checkspace(0.75));
		queue.add(m1, "pump");
		assertEquals(true, queue.checkspace(0.75));
		queue.add(m2, "pump");
		assertEquals(3.0, queue.getCurrentLength(), 0);
		queue.removeFirstItem("pump");
		assertEquals(1.5, queue.getCurrentLength(), 0);
		queue.removeFirstItem("pump");
		assertEquals(0.75, queue.getCurrentLength(), 0);
		queue.removeFirstItem("pump");
		assertEquals(0.0, queue.getCurrentLength(), 0);

	}

	@Test
	public void testAdd() {
		assertEquals(true, queue.checkspace(1.0));
		queue.add(c1, "pump");

		assertEquals(true, queue.add(m1, "pump"));
		assertEquals(false, queue.add(s1, "pump"));

		assertEquals(true, queue.add(c3, "tills"));
	}

}
