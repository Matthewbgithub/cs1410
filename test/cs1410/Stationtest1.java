package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Stationtest1 {
	private Vehicle c1;
	private Vehicle c2;
	private Vehicle c3;
	private Vehicle m1;
	private Vehicle m2;
	private Vehicle s1;
	
	Station station = new Station(1, 3, 0, 0, false);
	Pump pump = new Pump();
	Till till = new Till();
	
	

	@Before
	public void setUp(){
		c1= new Car();
		c2= new Car();
		c3 = new Car();
		m1= new Motorbike();
		m2 = new Motorbike();
		s1 = new Sedan();
		}
	

	@Test
	public void testScanPumpsForChanges() {
		fail("Not yet implemented");
	}

	@Test
	public void testScanTillsForChanges() {
		fail("Not yet implemented");
	}

	@Test
	public void testChoosePump() {
		fail("Not yet implemented");
	}

	@Test
	public void testChooseTill() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerateVehicle() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddToTill() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testRemoveFromShop() {
		c1= new Car();
		c2= new Car();
		m1= new Motorbike();
		assertEquals(true, till.getQueue().checkspace(1.0));
		till.add(c1);
		assertEquals(true, till.getQueue().checkspace(1.0));
		till.add(c2);
		assertEquals(true, till.getQueue().checkspace(0.75));
		till.add(m1);
		
		assertEquals(3.0, till.getQueue().getCurrentLength(), 0);
		till.getQueue().removeFirstItem("till");
		assertEquals(2.0, till.getQueue().getCurrentLength(), 0);
		
	
	}

	@Test
	public void testRemoveBeforeShop() {
		
		c1= new Car();
		c2= new Car();
		c3 = new Car();
		station.addVehicleToPump(c1);
		station.addVehicleToPump(c2);
		station.addVehicleToPump(c3);
		
		station.getPumpList().get(0).getQueue().removeFirstItem("pump");
		assertEquals(2.0, station.getPumpList().get(0).getQueue().getCurrentLength(), 0);
		
	}


	@Test
	public void testGetLoss() {
		fail("Not yet implemented");
	}
}

	