package cs1410;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueableTest {
	
	private Vehicle c1;
	private Vehicle c2;
	private Vehicle c3;
	private Vehicle s1;
	private Vehicle m1;
	private Vehicle m2;
	Queueable queueable = new Queueable();
	//why cant i create an object queueable, is it because its abstract/super?
	Station station = new Station(1, 2, 0, 0, false);
 
	@Before
	public void setUp(){
		c1 = new Car();
		c2 = new Car();
		c3 = new Car();
		s1 = new Sedan();
		m1 = new Motorbike();
		m2 = new Motorbike();
		
		
	}

	@Test
	public void testGetCurrentLength() {
		assertEquals(true, queueable.checkspace(1.0));
		queueable.addTo(c1, "pump");
		
		
		assertEquals(true, queueable.checkspace(1.0));
		queueable.addTo(c2, "pump");
		
		
		assertEquals(true, queueable.checkspace(1.0));
		queueable.addTo(c3, "pump");
		
		
		assertEquals(false, queueable.checkspace(1.0));
		
		assertNotEquals(2.0, queueable.getCurrentLength());
		assertNotEquals(4.0, queueable.getCurrentLength());
		assertEquals(3.0, queueable.getCurrentLength(), 0);
		}
	

	@Test
	public void testSetCurrentLength() {
		queueable.setCurrentLength(1.0);
		assertEquals(1.0, queueable.getCurrentLength(),0);	
		}

	@Test
	public void testCheckspace() {
		assertEquals(true, queueable.checkspace(1.0));
		queueable.addTo(c1, "pump");
		
		assertEquals(true, queueable.checkspace(1.0));
		queueable.addTo(c2, "pump");
		
		assertEquals(false, queueable.checkspace(1.5));
		assertEquals(true, queueable.checkspace(0.75));
	}

	@Test
	public void testRemoveF() {
		assertEquals(true, queueable.checkspace(1.5));
		queueable.addTo(s1, "pump");
		queueable.addTo(s1, "till");
		
		assertEquals(true, queueable.checkspace(0.75));
		queueable.addTo(m1, "pump");
		queueable.addTo(m1, "till");
		
		assertEquals(true, queueable.checkspace(0.75));
		queueable.addTo(m2, "pump");
		queueable.addTo(m2, "till");
		
		assertEquals(3.0, station.getPumpList().get(0).getCurrentLength(), 0);
		assertEquals(3.0, station.getTillList().get(0).getCurrentLength(), 0);
		
		queueable.removeF("pump");
		assertEquals(1.5, station.getPumpList().get(0).getCurrentLength(), 0);
		queueable.removeF("till");
		assertEquals(2.0, station.getTillList().get(0).getCurrentLength(), 0);
		
		queueable.removeF("pump");
		assertEquals(0.75, station.getPumpList().get(0).getCurrentLength(), 0);
		queueable.removeF("till");
		assertEquals(1.0, station.getTillList().get(0).getCurrentLength(), 0);
		
		queueable.removeF("pump");
		assertEquals(0.0, station.getPumpList().get(0).getCurrentLength(), 0);
		queueable.removeF("till");
		assertEquals(0.0, station.getTillList().get(0).getCurrentLength(), 0);
		
	}

	@Test
	public void testAddTo() {
		assertEquals(true, queueable.addTo(c1, "pump"));
		assertEquals(true, queueable.addTo(c1, "till"));
		
		assertEquals(true, queueable.addTo(s1, "pump"));
		assertEquals(true, queueable.addTo(s1, "till"));
		
		assertNotEquals(true, queueable.addTo(m1, "pump"));		
	}
}
