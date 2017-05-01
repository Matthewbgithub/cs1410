package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import Simulation.Car;
import Simulation.Motorbike;
import Simulation.Sedan;
import Simulation.Truck;
import Simulation.Vehicle;

public class SimulatorView {
	
	private ArrayList <ArrayList <ArrayList<Vehicle>>> pumpInfo;
	private ArrayList <ArrayList <ArrayList<Vehicle>>> tillInfo;
	private ArrayList<JPanel> jPumps;
	private ArrayList<JPanel> jTills;
	private JFrame simulation;
	private String overallLoss;
	private String overallProfit;
	private int overallHappyTrucks;
	private int overallSadTrucks;
	private int overallVehiclesGenerated;
	private double overallTruckHappiness;
	private JLabel tickCount;
	private int outsideIterate;
	private JButton skipToEnd;
	private int tickToSkipTo;
	
	/**
	 * Creates the window on which the simulation takes place
	 * @param numberOfPumps The number of pumps the simulation is running with
	 * @param numberOfTills The number of tills the simulation is running with
	 * @param numberOfTicks The number of ticks the simulation is running for
	 */
	
	public SimulatorView(int numberOfPumps, int numberOfTills, int numberOfTicks)  
	{			
		int size = 700;
		final int blankSpace = 5;
		
		tickToSkipTo = numberOfTicks;
		simulation = new JFrame("Simulation");
		JPanel simPanel = new JPanel();
		JPanel simPanelTill = new JPanel();
		jPumps = new ArrayList<JPanel>();
		jTills = new ArrayList<JPanel>();
		tickCount = new JLabel("Tick: 0");
		skipToEnd = new JButton("Skip to end");
		JPanel southPanel = new JPanel();
		Color colButtons = new Color(236, 76, 147);
		Color colPanelBackground = new Color (144, 12, 63);
		Color colFrameBackground = new Color(88, 24, 69);
		Color colLabelBackground = new Color(199, 0, 57); 
		southPanel.setLayout(new FlowLayout());
		
		simulation.setPreferredSize(new Dimension(size, size));
		simulation.setMinimumSize(new Dimension(size, size));
		simulation.setLayout(new BorderLayout(1,60));
		((JPanel)simulation.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		simulation.setLocationRelativeTo(null);
		
		simPanel.setLayout(new GridLayout(1, numberOfPumps));
		simPanelTill.setLayout(new GridLayout(1, numberOfTills));
		
		for(int createJpumps=0; createJpumps<numberOfPumps; createJpumps++)
		{
			JPanel pumpToAdd = new JPanel();
			pumpToAdd.setLayout(new BoxLayout(pumpToAdd, BoxLayout.Y_AXIS));
			JLabel title = new JLabel("Pump #" + (createJpumps+1));
			pumpToAdd.add(title);
			simPanel.add(pumpToAdd);
			jPumps.add(pumpToAdd);
		}
		
		for(int createJtills=0; createJtills<numberOfTills; createJtills++)
		{
			JPanel tillToAdd = new JPanel();
			tillToAdd.setLayout(new BoxLayout(tillToAdd, BoxLayout.Y_AXIS));
			JLabel title = new JLabel("Till #" + (createJtills+1));
			tillToAdd.add(title);
			simPanelTill.add(tillToAdd);
			jTills.add(tillToAdd);
		}		
		
		skipToEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outsideIterate = (tickToSkipTo-1);
			}
		});
		
		southPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		southPanel.setBackground(new Color(199, 0, 57, 123));
		simPanel.setBackground(colPanelBackground);
		simPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		simPanelTill.setBackground(colPanelBackground);
		simPanelTill.setBorder(BorderFactory.createRaisedBevelBorder());
		
		tickCount.setForeground(Color.WHITE);
		tickCount.setBackground(colLabelBackground);
		tickCount.setBorder(BorderFactory.createLoweredBevelBorder());
		skipToEnd.setForeground(Color.WHITE);
		skipToEnd.setBackground(colButtons);
		skipToEnd.setBorder(BorderFactory.createRaisedBevelBorder());
		simulation.getContentPane().setBackground(colFrameBackground);
		

		
		southPanel.add(tickCount);
		southPanel.add(skipToEnd);
		simulation.add(simPanelTill, BorderLayout.NORTH);
		simulation.add(simPanel, BorderLayout.CENTER);		
		simulation.add(southPanel, BorderLayout.SOUTH);
		simulation.pack();
		simulation.setVisible(true);
	}		
	
	/**
	 * The method that is called to run the simulation after it has been created and appropriate values set
	 */
	public void runSimulation()
	{    
		SwingWorker<Integer, String> worker;
		worker = new SwingWorker<Integer, String>(){
		@Override
		protected Integer doInBackground(){
			for(outsideIterate=0; outsideIterate<pumpInfo.size(); outsideIterate++){
				
				delay(100);
				
				if(outsideIterate == (tickToSkipTo-1)){
					int size = 400;
					int blankSpace = 5;
					JFrame popUp = new JFrame("Simulation Results");
					popUp.setPreferredSize(new Dimension(size, size));
					popUp.setMinimumSize(new Dimension(size, size));
					((JPanel)popUp.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
					popUp.setLocationRelativeTo(null);
					
					JLabel loss = new JLabel("Overall loss: " + overallLoss);
					JLabel profit = new JLabel("Overall profit: " + overallProfit);
					String stringOverallHappyTrucks = "" + overallHappyTrucks;
					JLabel happyTrucks = new JLabel("Number of happy trucks: " + stringOverallHappyTrucks);
					String stringOverallSadTrucks = "" + overallSadTrucks;
					JLabel sadTrucks = new JLabel("Number of sad trucks: " + stringOverallSadTrucks);
					String stringOverallVehiclesGenerated = "" + overallVehiclesGenerated;
					JLabel vehiclesGenerated = new JLabel("Number of vehicles generated: " + stringOverallVehiclesGenerated);
					String stringOverallTruckHappiness =  "" + overallTruckHappiness;
					JLabel truckHappiness = new JLabel("End happiness of trucks: " + stringOverallTruckHappiness);
					Color colLabelBackground = new Color(199, 0, 57); 
					
					
					loss.setForeground(Color.WHITE);
					profit.setForeground(Color.WHITE);
					happyTrucks.setForeground(Color.WHITE);
					sadTrucks.setForeground(Color.WHITE);
					vehiclesGenerated.setForeground(Color.WHITE);
					truckHappiness.setForeground(Color.WHITE);
					
					loss.setBackground(colLabelBackground);
					profit.setBackground(colLabelBackground);
					happyTrucks.setBackground(colLabelBackground);
					sadTrucks.setBackground(colLabelBackground);
					vehiclesGenerated.setBackground(colLabelBackground);
					truckHappiness.setBackground(colLabelBackground);
					
					loss.setBorder(BorderFactory.createRaisedBevelBorder());
					profit.setBorder(BorderFactory.createRaisedBevelBorder());
					happyTrucks.setBorder(BorderFactory.createRaisedBevelBorder());
					sadTrucks.setBorder(BorderFactory.createRaisedBevelBorder());
					vehiclesGenerated.setBorder(BorderFactory.createRaisedBevelBorder());
					truckHappiness.setBorder(BorderFactory.createRaisedBevelBorder());
					
					
					popUp.getContentPane().setBackground(new Color(88,24,69));
					popUp.setLayout(new GridLayout(6,1));
					popUp.add(loss);
					popUp.add(profit);
					popUp.add(happyTrucks);
					popUp.add(sadTrucks);
					popUp.add(vehiclesGenerated);
					popUp.add(truckHappiness);
					popUp.pack();
					popUp.setVisible(true);
				}
				
				tickCount.setText("Tick: " + outsideIterate);
				
				ArrayList<ArrayList <Vehicle>> pumpsInTick = pumpInfo.get(outsideIterate);
				ArrayList<ArrayList <Vehicle>> tillsInTick = tillInfo.get(outsideIterate);

				for(int iterate = 0; iterate<pumpsInTick.size(); iterate++){
					ArrayList <Vehicle> vehicleArrayToProcess = pumpsInTick.get(iterate);
					
					for(int iterate2=0; iterate2<vehicleArrayToProcess.size(); iterate2++){
						Vehicle vehicleToCheck = vehicleArrayToProcess.get(iterate2);
						
						if(vehicleToCheck instanceof Car){
							publish("car-pump#" + iterate);
						}
						else if(vehicleToCheck instanceof Sedan){	
							publish("sedan-pump#" + iterate);
						}
						else if(vehicleToCheck instanceof Motorbike){	
							publish("motorbike-pump#" + iterate);
						}
						else if(vehicleToCheck instanceof Truck){		
							publish("truck-pump#" + iterate);
						}
					}
				}
				
				for(int iterate = 0; iterate<tillsInTick.size(); iterate++){
					ArrayList <Vehicle> vehicleArrayToProcess = tillsInTick.get(iterate);
					
					for(int iterate2=0; iterate2<vehicleArrayToProcess.size(); iterate2++){
						Vehicle vehicleToCheck = vehicleArrayToProcess.get(iterate2);
						
						if(vehicleToCheck instanceof Car){
							publish("car-till#" + iterate);
						}
						else if(vehicleToCheck instanceof Sedan){	
							publish("sedan-till#" + iterate);
						}
						else if(vehicleToCheck instanceof Motorbike){	
							publish("motorbike-till#" + iterate);
						}
						else if(vehicleToCheck instanceof Truck){		
							publish("truck-till#" + iterate);
						}
					}
				}
			}
			return 1;
		}

		@Override
		protected void process(List<String> stringList) 
		{
			ImageIcon carIcon = new ImageIcon("ImagesForCars/carSmall.jpg");
			ImageIcon sedanIcon = new ImageIcon("ImagesForCars/sedanSmall.jpg");
			ImageIcon truckIcon = new ImageIcon("ImagesForCars/truckSmall.jpg");
			ImageIcon motorbikeIcon = new ImageIcon("ImagesForCars/motorbikeSmall.jpg");
			
	 		for(int i=0; i<jPumps.size(); i++)
			{
				JPanel toWipe = jPumps.get(i);
				toWipe.removeAll();
				JLabel title = new JLabel("Pump #" + (i+1));
				toWipe.add(title);
			} 
	 		
	 		for(int i=0; i<jTills.size(); i++)
			{
				JPanel toWipe = jTills.get(i);
				toWipe.removeAll();
				JLabel title = new JLabel("Till #" + (i+1));
				toWipe.add(title);
			} 

			for(int pumpIterate=0; pumpIterate<jPumps.size(); pumpIterate++)
			{	
				JPanel toAddPump = jPumps.get(pumpIterate);
	 		
				for(String string : stringList)
				{
					if(string.equals("car-pump#" + pumpIterate))
					{
						JLabel car = new JLabel();
						car.setIcon(carIcon);						
						toAddPump.add(car);
					}
					else if(string.equals("sedan-pump#" + pumpIterate))
					{	
						JLabel sedan = new JLabel();
						sedan.setIcon(sedanIcon);
						toAddPump.add(sedan);
					}
					else if(string.equals("motorbike-pump#" + pumpIterate))
					{	
						JLabel motorbike = new JLabel();
						motorbike.setIcon(motorbikeIcon);
						toAddPump.add(motorbike);
					}
					else if(string.equals("truck-pump#" + pumpIterate))
					{		
						JLabel truck = new JLabel();
						truck.setIcon(truckIcon);
						toAddPump.add(truck);
					}
				}
			}
			
			for(int tillIterate=0; tillIterate<jTills.size(); tillIterate++)
			{	
				JPanel toAddTill = jTills.get(tillIterate);
	 		
				for(String string : stringList)
				{
					if(string.equals("car-till#" + tillIterate))
					{
						JLabel car = new JLabel();
						car.setIcon(carIcon);						
						toAddTill.add(car);
					}
					else if(string.equals("sedan-till#" + tillIterate))
					{	
						JLabel sedan = new JLabel();
						sedan.setIcon(sedanIcon);
						toAddTill.add(sedan);
					}
					else if(string.equals("motorbike-till#" + tillIterate))
					{	
						JLabel motorbike = new JLabel();
						motorbike.setIcon(motorbikeIcon);
						toAddTill.add(motorbike);
					}
					else if(string.equals("truck-till#" + tillIterate))
					{		
						JLabel truck = new JLabel();
						truck.setIcon(truckIcon);
						toAddTill.add(truck);
					}
				}
			}
			simulation.revalidate();
	 		simulation.repaint();
		}
		};
		worker.execute();		
	}	
	/**
	 * Sets the simulation information for the pumps
	 * @param setPumpInfo The simulation information for pumps to be passed in
	 * 
	 */
	public void setPumpInfo(ArrayList <ArrayList <ArrayList<Vehicle>>> setPumpInfo){
		pumpInfo = setPumpInfo;
	}
	/**
	 * Sets the simulation information for the tills
	 * @param setTillInfo The simulation information for tills to be passed in
	 */
	public void setTillInfo(ArrayList <ArrayList <ArrayList<Vehicle>>> setTillInfo){
		tillInfo = setTillInfo;
	}
	/**
	 * Sets the simulation information for the overall loss
	 * @param setOverallLoss The simulation information for the overall loss to be passed in
	 */
	public void setOverallLoss(String setOverallLoss){
		overallLoss = setOverallLoss;
	}
	/**
	 * Sets the simulation information for the overall profit
	 * @param setOverallProfit The simulation information for the overall profit to be passed in
	 */
	public void setOverallProfit(String setOverallProfit){
		overallProfit = setOverallProfit;
	}
	/**
	 * Sets the simulation information for the overall number of happy trucks
	 * @param setOverallHappyTrucks The simulation information for the number of happy trucks to be passed in
	 */
	public void setOverallHappyTrucks(int setOverallHappyTrucks){
		overallHappyTrucks = setOverallHappyTrucks;
	}
	/**
	 * Sets the simulation information for the overall number of sad trucks
	 * @param setOverallSadTrucks The simulation information for the number of sad trucks to be passed in 
	 */
	public void setOverallSadTrucks(int setOverallSadTrucks){
		overallSadTrucks = setOverallSadTrucks;
	}
	/**
	 * Sets the simulation information for the overall number of vehicles generated
	 * @param setOverallVehiclesGenerated The simulation information for the overall number of vehicles generated to be passed in
	 */
	public void setOverallVehiclesGenerated(int setOverallVehiclesGenerated){
		overallVehiclesGenerated = setOverallVehiclesGenerated;
	}
	/**
	 * Sets the simulation information for the overall truck happiness
	 * @param setOverallTruckHappiness The simulation information for the overall truck happiness to be passed in 
	 */
	public void setOverallTruckHappiness(double setOverallTruckHappiness){
		overallTruckHappiness = setOverallTruckHappiness;
	}
	/**
	 * Delays the method being ran by the specified amount of time
	 * @param millisecs the amount of time to delay for
	 */
	private static void delay(int millisecs)
    {
        try {
            Thread.sleep(millisecs);
        }
        catch (InterruptedException ie) {
        }
    }
}
