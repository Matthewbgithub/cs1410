package Simulation;


import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.lang.String;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

//The below line states it extends JSlider as this class is an implementation of the jSlider pack
public class Scroller extends JSlider

{
	

	public Scroller(JLabel a, int minVal, int maxVal, int curValue, JLabel b) {
		
		
		Color colScrollerLabelBackground = new Color(230, 179, 201);
		a.setOpaque(true);
		a.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		a.setBackground(colScrollerLabelBackground);
		this.setBorder(BorderFactory.createTitledBorder(b.getText()));
		this.setBackground(colScrollerLabelBackground);
		this.setForeground(Color.WHITE);
		this.setPaintTicks(true);
		this.setMajorTickSpacing(1);
		this.setMinorTickSpacing(1);
		this.setMaximum(maxVal);
		this.setMinimum(minVal);
		this.setValue(curValue);

		
	  
	}

	
	
}
