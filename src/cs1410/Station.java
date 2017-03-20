package cs1410;

import java.util.ArrayList;

public class Station {
	private ArrayList<Pump> pumpList;
	private ArrayList<Till> tillList;
	
	public Station(){
		pumpList = new ArrayList<Pump>();
		tillList = new ArrayList<Till>();
		
		Car largeCar = new Car();
		Pump pump1 = new Pump();
		pumpList.add(pump1);
		pumpList.get(0).getQueue().add(largeCar);
		System.out.println("should contain 1 car" + pumpList.get(0).getQueue().toString());
		
		}
	
	public void queueTest(){
		Car car1 = new Car();
		Motorbike bike1 = new Motorbike();
		Truck truck1 = new Truck();
		Queue q1 = new Queue();
		q1.add(car1);
		System.out.println("current length: " + q1.getCurrentLength());
		q1.add(bike1);
		q1.add(truck1);
		System.out.println(q1.toString());
		q1.checkspace(car1);
		q1.add(car1);
		System.out.println(q1.checkspace(car1));
		System.out.println("current length: " + q1.getCurrentLength());
		q1.removeFirstItem();
		System.out.println("current length: " + q1.getCurrentLength());
		q1.removeFirstItem();
		System.out.println("current length: " + q1.getCurrentLength());
		q1.removeFirstItem();
		System.out.println("current length: " + q1.getCurrentLength());
		q1.removeFirstItem();
		System.out.println("current length: " + q1.getCurrentLength());
		q1.removeFirstItem();
		System.out.println("current length: " + q1.getCurrentLength());

		System.out.println(car1.getTankSize());
		}
	}
