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
	private Vehicle s2;
	
	
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
		s2 = new Sedan();
		}
	

	@Test
	public void testScanPumpsForChanges() {
		Station station = new Station(2, 3, 0, 0, false);
		station.addVehicleToPump(c1);
		station.addVehicleToPump(c2);
		station.addVehicleToPump(m1);
		station.addVehicleToPump(s1);
		assertEquals(1.75, station.getPumpList().get(0).getCurrentLength(), 0);
		assertEquals(2.5, station.getPumpList().get(1).getCurrentLength(), 0);
		station.getPumpList().get(0).removeFirstItem();
		assertEquals(0.75, station.getPumpList().get(0).getCurrentLength(), 0);
		
	}

	@Test
	public void testScanTillsForChanges() {
		Station station = new Station(3, 1, 0, 0, false);
		station.addToTill(1, c1);
		station.addToTill(2, c2);
		station.addToTill(3, c3);
		assertEquals(3, station.getTillList().get(0).getCurrentLength(), 0);
		//till.removeFirstItem("till");
		station.getTillList().get(0).removeFirstItem();
		assertEquals(2.0, station.getTillList().get(0).getCurrentLength(), 0);
		//assertEquals(2.0, till.getCurrentLength(), 0);
	}

	@Test
	public void testChoosePump() {
		Station station = new Station(3, 3, 0, 0, false);
		assertEquals(0.0, station.getPumpList().get(0).getCurrentLength(), 0);
		assertEquals(0.0, station.getPumpList().get(1).getCurrentLength(), 0);
		assertEquals(0.0, station.getPumpList().get(2).getCurrentLength(), 0);
		
		station.addVehicleToPump(c1); //adds a car to the pump 
		assertEquals(1.0, station.getPumpList().get(0).getCurrentLength(), 0);//checks it goes to first pump
		
		
		station.addVehicleToPump(s1); //adds a sedan to the pump 
		assertEquals(1.5, station.getPumpList().get(1).getCurrentLength(), 0); //checks it goes to second pump
		
		station.addVehicleToPump(m1);
		assertNotEquals(2.25, station.getPumpList().get(1).getCurrentLength(), 0); //checks the motorbike didnt go to second pump
		assertEquals(0.75, station.getPumpList().get(2).getCurrentLength(), 0);
		
		station.addVehicleToPump(c2);
		assertEquals(1.75, station.getPumpList().get(2).getCurrentLength(), 0); //checks it goes to second pump
		
		station.addVehicleToPump(c3);
		//assertEquals(station.getPumpList().get(0), station.choosePump());
		System.out.println(station.getPumpList().toString()+"1st-------");
		System.out.println(station.choosePump().toString()+ " HERE");
		assertEquals(2.0, station.getPumpList().get(0).getCurrentLength(), 0); //checks it goes to first pump
		
		
	}

	@Test
	public void testChooseTill() {
		Station station = new Station(3, 3, 0, 0, false);
		assertEquals(0.0, station.getTillList().get(0).getCurrentLength(), 0);
		assertEquals(0.0, station.getTillList().get(1).getCurrentLength(), 0);
		assertEquals(0.0, station.getTillList().get(2).getCurrentLength(), 0);
		station.addToTill(1, c1);
		station.addToTill(2, c2);
		station.addToTill(3, m1);
		assertEquals(1, station.getTillList().get(0).getCurrentLength(), 0);
		assertEquals(1, station.getTillList().get(1).getCurrentLength(), 0);
		assertEquals(1, station.getTillList().get(2).getCurrentLength(), 0);
		station.addToTill(4, c3);
		assertEquals(2, station.getTillList().get(0).getCurrentLength(), 0);
		station.addToTill(5, s1);
		assertEquals(2, station.getTillList().get(1).getCurrentLength(), 0);
	}

	@Test
	public void testAddToTill() {
		Station station = new Station(2, 2, 0, 0, false);
		
		station.addToTill(1, m1);
		assertEquals(1.0, station.getTillList().get(0).getCurrentLength(), 0);
	
		station.addToTill(2, s1);
		assertEquals(1.0, station.getTillList().get(1).getCurrentLength(), 0);
	
		station.addToTill(3, c1);
		assertEquals(2.0, station.getTillList().get(0).getCurrentLength(), 0);
	
		station.addToTill(4, c2);
		assertEquals(2.0, station.getTillList().get(1).getCurrentLength(), 0);

		station.addToTill(5, m2);
		assertEquals(3.0, station.getTillList().get(0).getCurrentLength(), 0);

		station.addToTill(6, c3);
		assertEquals(3.0, station.getTillList().get(1).getCurrentLength(), 0);

		
		
		
		
	}
	
	
	@Test
	public void testAddVehicleToPump(){
		Station station = new Station(2, 3, 0, 0, false);
		station.addVehicleToPump(c1); //adds a car to the pump 
		assertEquals(1.0, station.getPumpList().get(0).getCurrentLength(), 0); //checks the first pump has a car in it
		station.addVehicleToPump(c2); //adds a car to the pump
		assertEquals(1.0, station.getPumpList().get(1).getCurrentLength(), 0); //checks it goes to the second pump
		station.addVehicleToPump(m1); //adds a motor bike to the pump
		assertEquals(1.75, station.getPumpList().get(0).getCurrentLength(), 0); //checks it goes to first pump
		station.addVehicleToPump(s1); //adds a sedan to the pump
		assertEquals(2.5, station.getPumpList().get(1).getCurrentLength(), 0); //checks it goes to the second pump
		station.addVehicleToPump(c3); //adds a car to pump
		assertEquals(2.75, station.getPumpList().get(0).getCurrentLength(), 0); //checks it goes to first pump
		assertEquals(false, station.addVehicleToPump(s2) );//tries to add sedan to pump but both are full
		
		
	}

	@Test
	public void testRemoveFromShop() {
		till.add(c1);
		till.add(c2);
		till.add(m1);
		
		assertEquals(3.0, till.getCurrentLength(), 0);
		till.removeFirstItem();
		assertEquals(2.0, till.getCurrentLength(), 0);	
	}

	@Test
	public void testRemoveBeforeShop() {
		Station station = new Station(2, 3, 0, 0, false);
		c1= new Car();
		c2= new Car();
		c3 = new Car();
		station.addVehicleToPump(c1);  //adds car to first pump
		station.addVehicleToPump(c2);	//adds car to second pump
		station.addVehicleToPump(c3); //adds car to first pump
		station.addVehicleToPump(m1); //adds motor bike to second pumps
		
		station.getPumpList().get(0).removeFirstItem();
		assertEquals(1.0, station.getPumpList().get(0).getCurrentLength(), 0); //length of first pump when first car is removed
		assertEquals(1.75, station.getPumpList().get(1).getCurrentLength(), 0); //length of second pump
		station.getPumpList().get(0).removeFirstItem(); //removes c3 from first pump
		station.getPumpList().get(1).removeFirstItem(); //removes c2 from second pump
		assertEquals(0.0, station.getPumpList().get(0).getCurrentLength(), 0); //there are no vehicles in this pump queue
		assertEquals(0.75, station.getPumpList().get(1).getCurrentLength(), 0); //there is only a motor bike here 
		
	}


	@Test
	public void testGetLoss() {

		Station station = new Station(1, 1, 0, 0, false);
		station.setPetrolPrice(1.20);
		station.addVehicleToPump(c1);  
		station.addVehicleToPump(c2);	
		station.addVehicleToPump(c3); 
		station.addVehicleToPump(m1);
		assertEquals(3.0, station.getPumpList().get(0).getCurrentLength(), 0);
		station.vehicleLeaveBecauseQueueFull(m1);
		assertEquals(12.0, station.getLoss(), 0);
		
		
	}
	
	@Test
	public void testVehicleLeaveBecauseQueueFull() {
		pump.add(c1);
		pump.add(c2);
		pump.add(c3);
		assertEquals(false, pump.checkspace(0.75));
		assertEquals(3.0, pump.getCurrentLength(), 0);		
	}
}

	