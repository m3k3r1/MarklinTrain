package com.sample;

import java.awt.Container;
import javax.swing.JFrame;



@SuppressWarnings("serial")
public class GraphicalInterface extends JFrame {
	
	MarklinTrain train;
	GraphicalPanel panel;
	
	public GraphicalInterface(MarklinTrain t){
		super("Marklin Train");
		train = t;
		
		Container container = getContentPane();
		
		panel = new GraphicalPanel(train);
		container.add(panel);
		
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        
	}
}
