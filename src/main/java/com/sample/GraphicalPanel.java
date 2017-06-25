package com.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@SuppressWarnings("serial")
public class GraphicalPanel extends JPanel {
	
	MarklinTrain train;
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	
	public GraphicalPanel(MarklinTrain t){
		train = t;
		
		setupComponents();
		setupLayout();
	}
	
	private void setupComponents(){
		 button1 = new JButton("Farol não funciona e transformador indica curto-circuito ");
		 button2 = new JButton("Farol não funciona e transformador não indica curto-circuito ");
		 button3 = new JButton("Farol funciona ");
		 button4 = new JButton("Catenária não funciona");
		 button5 = new JButton("Não funciona numa direção ");
	}	
	private void setupLayout(){
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		
		button1.addActionListener(new ButtonListener(0));
		button2.addActionListener(new ButtonListener(1));
		button3.addActionListener(new ButtonListener(2));
		button4.addActionListener(new ButtonListener(3));
		button5.addActionListener(new ButtonListener(4));
	}

	class ButtonListener implements ActionListener {
		int l;
		
		public ButtonListener(int i){
			l=i;
		}
		
		private void setupDrools() {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
		    KieSession kSession = kContainer.newKieSession("ksession-rules");
		    
		    kSession.insert(train);
		    kSession.fireAllRules() ;
		}
		
        @Override
        public void actionPerformed(ActionEvent e){
        	for(int i = 0; i < 5; i++){
        		if(i == l )
        			continue;
        		else
        			train.mark(i);
        	}
        	setupDrools();
        }
        
	}	
}
