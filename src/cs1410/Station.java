package cs1410;

import java.util.ArrayList;

public class Station {
	private ArrayList<Pump> pumpList;
	private ArrayList<Till> tillList;
	
	public Station(int pumpNo, int tillNo){
		pumpList = new ArrayList<Pump>();
		tillList = new ArrayList<Till>();
		
		for(int i = 0; i < pumpNo; i++){
			Pump pump = new Pump();
			pumpList.add(pump);
		}
		for(int i = 0; i < tillNo; i++){
			Till till = new Till();
			tillList.add(till);
		}
		//now, 'pumpno' of pumps have been created and 'tillno' of tills
		Car car = new Car();
		Truck truck = new Truck();
		Motorbike bike = new Motorbike();
		pumpList.get(0).add(car);
		pumpList.get(0).add(car);
		pumpList.get(1).add(bike);
		pumpList.get(2).add(truck);
		pumpList.get(2).add(truck);
		System.out.println(choosePump().toString());
	}
	public Pump choosePump(){
		double small = pumpList.get(0).getQueue().getCurrentLength();
		int pumpNo = 0;
		int i;
		for(i = 1; i < (pumpList.size() -1); i++){
			if(pumpList.get(i).getQueue().getCurrentLength() < small){
				small = pumpList.get(i).getQueue().getCurrentLength();
				pumpNo = i;
			}
			
		}
		return pumpList.get(pumpNo);
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
