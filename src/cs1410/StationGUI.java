package cs1410;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class StationGUI{	
	private JFrame mainFrame;
	private double pValue = 0.03;
	private double qValue = 0.03;
	private int pumpsValue = 3;
	private int tillsValue = 3;
	private boolean trucksValue = true;
	
	public static void main(String[] args){
	    StationGUI stationGUI = new StationGUI();
	}
	
	public StationGUI()	{
		
		final int blankSpace = 5;
		mainFrame = new JFrame("GUI Menu");
		JPanel buttonContainer = new JPanel();
		JPanel optionsContainer = new JPanel();
		JButton simulateButton = new JButton();
		JButton quitButton = new JButton();
		JButton submitPreferences = new JButton();
		JButton helpButton = new JButton();
		JLabel title = new JLabel();
		JTextField setP = new JTextField();
		JTextField setQ = new JTextField();
		JTextField setPumps = new JTextField();
		JTextField setTills = new JTextField();
		JRadioButton setTrucksTrue = new JRadioButton("True");
		JRadioButton setTrucksFalse = new JRadioButton("False");
		ButtonGroup group = new ButtonGroup();
		JLabel setPLabel = new JLabel("Set probability of p: ");
		JLabel setQLabel = new JLabel("Set probability of q: ");
		JLabel setPumpsLabel = new JLabel("Set number of pumps: ");
		JLabel setTillsLabel = new JLabel("Set number of tills: ");
		JLabel setTrucksLabel = new JLabel("Set whether simulation has trucks: ");
		
		simulateButton.setText("Simulate");
		simulateButton.setToolTipText("Start the simulation");
		quitButton.setText("Quit");
		quitButton.setToolTipText("Quit application");
		submitPreferences.setText("Submit Preferences");
		submitPreferences.setToolTipText("Runs the simulation with selected values");
		helpButton.setText("Help");
		helpButton.setToolTipText("Press for GUI explanation");
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		mainFrame.setPreferredSize(new Dimension(350,500));
		mainFrame.setMinimumSize(new Dimension(350,500));
		
		ImageIcon titleIcon = new ImageIcon("ImagesForCars/PetrolStationSimulation.jpg");
		title.setIcon(titleIcon);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		mainFrame.setLayout(new BorderLayout());
		((JPanel)mainFrame.getContentPane()).setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		buttonContainer.setLayout(new FlowLayout());
		buttonContainer.setBorder(new EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		buttonContainer.add(simulateButton);
		buttonContainer.add(quitButton);
		
		group.add(setTrucksFalse);
		group.add(setTrucksTrue);
		
		setP.setMaximumSize(new Dimension(600, 30));
		setQ.setMaximumSize(new Dimension(600, 30));
		setPumps.setMaximumSize(new Dimension(600, 30));
		setTills.setMaximumSize(new Dimension(600, 30));
		setTrucksTrue.setMaximumSize(new Dimension(600, 30));
		setTrucksFalse.setMaximumSize(new Dimension(600, 30));
		optionsContainer.setLayout(new BoxLayout(optionsContainer, BoxLayout.Y_AXIS));
		optionsContainer.add(helpButton);
		optionsContainer.add(setPLabel);
		optionsContainer.add(setP);
		optionsContainer.add(setQLabel);
		optionsContainer.add(setQ);
		optionsContainer.add(setPumpsLabel);
		optionsContainer.add(setPumps);
		optionsContainer.add(setTillsLabel);
		optionsContainer.add(setTills);
		optionsContainer.add(setTrucksLabel);
		optionsContainer.add(setTrucksTrue);
		optionsContainer.add(setTrucksFalse);
		optionsContainer.add(submitPreferences);
		
		mainFrame.add(title ,BorderLayout.NORTH);
		mainFrame.add(optionsContainer, BorderLayout.CENTER);
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
		
		submitPreferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tempSetP = setP.getText();
				String tempSetQ = setQ.getText();
				String tempSetPumps = setPumps.getText();
				String tempSetTills = setTills.getText();
				Boolean trucksSelected = true;
				
				if(setTrucksFalse.isSelected()){
					trucksSelected = false;
				}
				
				Double tempSetPValue = null;
				Double tempSetQValue = null;
				Integer tempSetPumpsValue = null;
				Integer tempSetTillsValue = null;

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
				try{
					tempSetPumpsValue = Integer.parseInt(tempSetPumps);
				}catch(Exception exception){
					//ignore
				}
				try{
					tempSetTillsValue = Integer.parseInt(tempSetTills);
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
				if(tempSetPumpsValue != null){
					pumpsValue = tempSetPumpsValue;
				}
				if(tempSetTillsValue != null){
					tillsValue = tempSetTillsValue;
				}
				trucksValue = trucksSelected;
			}
		});
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	private void exitApp(){
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
		helpText.setEditable(false);
		
		//layout?
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
