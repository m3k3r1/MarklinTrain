package com.sample;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class GraphicalInterface extends JFrame implements Observer{
	
	MarklinTrain train;
	GraphicalPanel panel;
	
	public GraphicalInterface(MarklinTrain t){
		super("Marklin Train");
		Container container = getContentPane();
		
		train = t;
		train.addObserver(this);
		
		panel = new GraphicalPanel(train);
		container.add(panel);
		
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        update(train, this);
	}
		
	private void setupDrools() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
	    KieSession kSession = kContainer.newKieSession("ksession-rules");
	    
	    kSession.insert(train);
	    kSession.fireAllRules() ;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		  
	}
}
