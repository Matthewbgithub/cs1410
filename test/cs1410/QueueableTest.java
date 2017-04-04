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
	Till till = new Till();
	Pump pump = new Pump();
	
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
		assertEquals(true, pump.checkspace(1.0));
		pump.addTo(c1, "pump");
		
		
		assertEquals(true, pump.checkspace(1.0));
		pump.addTo(c2, "pump");
		
		
		assertEquals(true, pump.checkspace(1.0));
		pump.addTo(c3, "pump");
		
		
		assertEquals(false, pump.checkspace(1.0));
		
		assertNotEquals(2.0, pump.getCurrentLength());
		assertNotEquals(4.0, pump.getCurrentLength());
		assertEquals(3.0, pump.getCurrentLength(), 0);
		}
	

	@Test
	public void testSetCurrentLength() {
		pump.setCurrentLength(1.0);
		assertEquals(1.0, pump.getCurrentLength(),0);	
		
		till.setCurrentLength(1.0);
		assertEquals(1.0, till.getCurrentLength(), 0);
	}

	@Test
	public void testCheckspace() {
		assertEquals(true, pump.checkspace(1.0));
		pump.addTo(c1, "pump");
		
		assertEquals(true, pump.checkspace(1.0));
		pump.addTo(c2, "pump");
		
		assertEquals(false, pump.checkspace(1.5));
		assertEquals(true, pump.checkspace(0.75));
	}

	@Test
	public void testRemoveF() {
		assertEquals(true, pump.checkspace(1.5));
		pump.addTo(s1, "pump");
		till.addTo(s1, "till");
		
		assertEquals(true, pump.checkspace(0.75));
		pump.addTo(m1, "pump");
		till.addTo(m1, "till");
		
		assertEquals(true, pump.checkspace(0.75));
		pump.addTo(m2, "pump");
		till.addTo(m2, "till");
		
		assertEquals(3.0, pump.getCurrentLength(), 0);
		assertEquals(3.0, till.getCurrentLength(), 0);
		
		pump.removeF("pump");
		assertEquals(1.5, pump.getCurrentLength(), 0);
		till.removeF("till");
		assertEquals(2.0, till.getCurrentLength(), 0);
		
		pump.removeF("pump");
		assertEquals(0.75, pump.getCurrentLength(), 0);
		till.removeF("till");
		assertEquals(1.0, till.getCurrentLength(), 0);
		
		pump.removeF("pump");
		assertEquals(0.0, pump.getCurrentLength(), 0);
		till.removeF("till");
		assertEquals(0.0, till.getCurrentLength(), 0);
		
	}

	@Test
	public void testAddTo() {
		assertEquals(true, pump.addTo(c1, "pump"));
		assertEquals(true, till.addTo(c1, "till"));
		assertEquals(1.0, pump.getCurrentLength(), 0);
		assertEquals(1.0, till.getCurrentLength(), 0);
		
		assertEquals(true, pump.addTo(s1, "pump"));
		assertEquals(true, till.addTo(s1, "till"));
		assertEquals(2.5, pump.getCurrentLength(), 0);
		assertEquals(2.0, till.getCurrentLength(), 0);
		
		assertNotEquals(true, pump.addTo(m1, "pump"));		
	}
}
