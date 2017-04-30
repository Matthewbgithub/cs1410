package cs1410;



import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ColorUIResource;

public class StationGUI{	
	private JFrame mainFrame;
	private double pValue = 0.03;
	private double qValue = 0.03;
	private int pumpsValue = 4;
	private int tillsValue = 4;
	private boolean trucksValue = true;
	
	public static void main(String[] args){
	    StationGUI stationGUI = new StationGUI();
	}
	
	public StationGUI()	{
		
		final int blankSpace = 5;
		mainFrame = new JFrame("GUI Menu");
		JPanel buttonContainer = new JPanel();
		JPanel optionsContainer = new JPanel();
		JPanel tillsAndPumpsContainer = new JPanel();
		JButton simulateButton = new JButton();
		JButton quitButton = new JButton();
		JButton submitPreferences = new JButton();
		JButton helpButton = new JButton();
		JLabel title = new JLabel();
		JLabel tillsAmount = new JLabel();
		JLabel tillsTitle = new JLabel("Tills Scroller");
		JLabel pumpsAmount = new JLabel();
		JLabel pumpsTitle = new JLabel("Pumps Scroller");
		JLabel setPLabel = new JLabel("Set probability of p: ");
		JLabel setQLabel = new JLabel("Set probability of q: ");
		JLabel setTrucksLabel = new JLabel("Set trucks to On/Off: ");
		Scroller tillsScroller = new Scroller(tillsAmount, 1, 3, 0, tillsTitle);
		Scroller pumpsScroller = new Scroller(pumpsAmount, 1, 3, 0, pumpsTitle);
		JTextField setP = new JTextField();
		JTextField setQ = new JTextField();
		JRadioButton setTrucksTrue = new JRadioButton("True");
		JRadioButton setTrucksFalse = new JRadioButton("False");
		ButtonGroup group = new ButtonGroup();
		Color colButtons = new Color(236, 76, 147);
		Color colUpperPanelBackground = new Color(199, 0, 57);
		Color colPanelBackground = new Color (144, 12, 63);
		Color colFrameBackground = new Color(88, 24, 69);
		Color colLabelBackground = new Color(199, 0, 57); 
	
		
		simulateButton.setText("Simulate");
		simulateButton.setToolTipText("Start the simulation");
		simulateButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		simulateButton.setBackground(colButtons);
		simulateButton.setForeground(Color.WHITE);
		quitButton.setText("Quit ");
		quitButton.setToolTipText("Quit application");
		quitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		quitButton.setBackground(colButtons);
		quitButton.setForeground(Color.WHITE);
		submitPreferences.setText("Submit Preferences");
		submitPreferences.setToolTipText("Runs the simulation with selected values");
		helpButton.setText("  Help  ");
		helpButton.setToolTipText("Press for GUI explanation");
		helpButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		helpButton.setBackground(colButtons);
		helpButton.setForeground(Color.WHITE);
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		mainFrame.getContentPane().setBackground(colFrameBackground);
		mainFrame.setPreferredSize(new Dimension(350,500));
		mainFrame.setMinimumSize(new Dimension(350,500));
		
		ImageIcon titleIcon = new ImageIcon("ImagesForCars/PetrolStationSimulation.jpg");
		title.setIcon(titleIcon);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		setTrucksTrue.setForeground(Color.WHITE);
		setTrucksFalse.setForeground(Color.WHITE);
		setTrucksTrue.setBackground(colUpperPanelBackground);
		setTrucksFalse.setBackground(colUpperPanelBackground);
		setPLabel.setForeground(Color.WHITE);
		setQLabel.setForeground(Color.WHITE);
		setTrucksLabel.setForeground(Color.WHITE);
		submitPreferences.setForeground(Color.WHITE);
		
		setPLabel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 40, 0, 0), BorderFactory.createRaisedBevelBorder()));
		setPLabel.setBackground(colLabelBackground);
		setQLabel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 40, 0, 0), BorderFactory.createRaisedBevelBorder()));
		setQLabel.setBackground(colLabelBackground);
		setTrucksLabel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 0), BorderFactory.createRaisedBevelBorder()));
		setTrucksLabel.setBackground(colLabelBackground);
		
		setP.setMaximumSize(new Dimension(600, 30));
		setQ.setMaximumSize(new Dimension(600, 30));
		setTrucksTrue.setMaximumSize(new Dimension(600, 30));
		setTrucksFalse.setMaximumSize(new Dimension(600, 30));
		
		submitPreferences.setBackground(colUpperPanelBackground);
		submitPreferences.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 0, 0, 0), BorderFactory.createRaisedBevelBorder()));
		
		optionsContainer.setLayout(new BoxLayout(optionsContainer, BoxLayout.Y_AXIS));
		optionsContainer.setBackground(colUpperPanelBackground);
		optionsContainer.setBorder(BorderFactory.createRaisedBevelBorder());
		
		buttonContainer.setLayout(new FlowLayout());
		buttonContainer.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		buttonContainer.setBackground(colPanelBackground);
		
		tillsAndPumpsContainer.setLayout(new FlowLayout());
		tillsAndPumpsContainer.setBorder(BorderFactory.createRaisedBevelBorder());
		tillsAndPumpsContainer.setBackground(colPanelBackground);		
		
		tillsAndPumpsContainer.add(tillsAmount);
		tillsAndPumpsContainer.add(pumpsAmount);
		buttonContainer.add(simulateButton);
		buttonContainer.add(quitButton);
		group.add(setTrucksFalse);
		group.add(setTrucksTrue);
		optionsContainer.add(helpButton);
		optionsContainer.add(setPLabel);
		optionsContainer.add(setP);
		optionsContainer.add(setQLabel);
		optionsContainer.add(setQ);
		optionsContainer.add(tillsScroller);
		optionsContainer.add(pumpsScroller);
		optionsContainer.add(setTrucksLabel);
		optionsContainer.add(setTrucksTrue);
		optionsContainer.add(setTrucksFalse);
		optionsContainer.add(submitPreferences);
		
		mainFrame.setLayout(new BorderLayout());
		((JPanel)mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		mainFrame.add(title ,BorderLayout.NORTH);
		mainFrame.add(optionsContainer, BorderLayout.CENTER);
		mainFrame.add(tillsAndPumpsContainer, BorderLayout.EAST);
		mainFrame.add(buttonContainer, BorderLayout.SOUTH);
		
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				exitApp();
			}
		});    
		
		quitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				exitApp();
			}
		});
		
		helpButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				showHelp();
			}
		});
		
		simulateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simulate();
			}
		});
		
		
		
		tillsScroller.addChangeListener(new ChangeListener()
		{public void stateChanged(ChangeEvent tillChange)
		 {
			Integer intTillsAmount = 0;
			intTillsAmount = tillsScroller.getValue();
			if(intTillsAmount == 3)
				{
				  intTillsAmount = intTillsAmount + 1;
				  tillsAmount.setText(intTillsAmount + "  Tills");
				  tillsValue = intTillsAmount;
				}
			else 
				{tillsAmount.setText(intTillsAmount + "  Tills");
				 tillsValue = intTillsAmount;
			    } 
			
			if(intTillsAmount != null)
				{tillsValue = intTillsAmount;}}});
		
		pumpsScroller.addChangeListener(new ChangeListener()
		{public void stateChanged(ChangeEvent tillChange)
		 {
			Integer intPumpsAmount = 0;
			intPumpsAmount = pumpsScroller.getValue();
			if(intPumpsAmount == 3)
				{
				intPumpsAmount = intPumpsAmount + 1;
				  pumpsAmount.setText(intPumpsAmount + "  Pumps");
				  pumpsValue = intPumpsAmount;
				}
			else 
				{pumpsAmount.setText(intPumpsAmount + "  Pumps");
				 pumpsValue = intPumpsAmount;
			    } 
			
			if(intPumpsAmount != null)
			{pumpsValue = intPumpsAmount;}}});
		
		
		submitPreferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tempSetP = setP.getText();
				String tempSetQ = setQ.getText();
			
				Boolean trucksSelected = true;
				
				if(setTrucksFalse.isSelected()){
					trucksSelected = false;
					}
				Double tempSetPValue = null;
				Double tempSetQValue = null;
				try{
					tempSetPValue = Double.parseDouble(tempSetP);
				}catch(Exception exception){
					//ignore
				}
				try{
					tempSetQValue = Double.parseDouble(tempSetQ);
				}catch(Exception exception){
					//ignore
				}
				//as long as the values are not null, then use them to create the sim, otherwise use default values...
				if(tempSetPValue != null){
					pValue = tempSetPValue;
				}
				if(tempSetQValue != null){
					qValue = tempSetQValue;
				}
				trucksValue = trucksSelected;
			}
		});
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	private void exitApp()
	{
		
		int response = JOptionPane.showConfirmDialog(
				mainFrame, "Do you really want to quit?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (response == JOptionPane.YES_OPTION){
			System.exit(0);
		}
		
		
	}
	
	private void showHelp(){
		int xSize = 700;
		int ySize = 300;
		int blankSpace = 5;
		JFrame helpWindow = new JFrame("GUI Help");
		helpWindow.setPreferredSize(new Dimension(xSize,ySize));
		helpWindow.setMinimumSize(new Dimension(xSize,ySize));
		((JPanel)helpWindow.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		helpWindow.setLocationRelativeTo(null);
		
		String helpInput = 
		"This GUI controls a fuel station simulation." + "\n" +
		"Either input values into the GUI and click “Submit Preferences”, followed by “Simulate”." + "\n" +
		"Alternatively, just press “Simulate” for the default simulation to be carried out." + "\n" +
		"Pressing the “Quit” button and confirming closes and exits the program." + "\n" + "\n" + 
		
		"GUI Values:" + "\n" + "\n" +
		
		"“Set probability of p” – Double – Sets the probability of small cars and motorbikes spawning." + "\n" +
		"“Set probability of q” – Double – Sets the probability of sedans spawning." + "\n" +
		"“Set number of pumps” – Integer – Sets the number of pumps in the simulation." + "\n" +
		"“Set number of tills” – Integer – Sets the number of tills in the simulation." + "\n" +
		"“Set whether simulation has trucks” – Boolean – Sets whether the simulation has the ability to spawn trucks or not." + "\n" + "\n" +
		"Once you’ve started the simulation, there is a button called “Skip to end”," + "\n" + 
		"which will fast-forward the simulation to the final step and display the simulation’s results.";		
		JTextArea helpText = new JTextArea(helpInput);
		helpText.setLayout(new FlowLayout());
		helpText.setEditable(false);
		helpText.setForeground(Color.WHITE);
		helpText.setBackground(new Color(199,0,57));
		
		
		
		helpWindow.getContentPane().setBackground(new Color(88, 24, 69));
		helpWindow.add(helpText);
		helpWindow.pack();
		helpWindow.setVisible(true);
	}
	
	private void simulate(){		
		Simulator sim = new Simulator();
		sim.setP(pValue);
		sim.setQ(qValue);
		sim.setPumps(pumpsValue);
		sim.setTills(tillsValue);
		sim.setIsTruck(trucksValue);
		sim.runSim();
	}
}
