package com.sample;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GraphicalPanel extends JPanel  implements Observer{
	
	MarklinTrain train;
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	
	public GraphicalPanel(MarklinTrain t){
		train = t;
		
		train.addObserver(this);
		
		setupComponents();
		setupLayout();
		setOpaque(false);
		
		update(train, this);
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
		
		button1.addActionListener(new Button1Listener());
	}
	
	class Button1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
        	train.mark(1);
        	train.mark(2);
        	train.mark(3);
        	train.mark(4);
        }
	}
	
	class Button2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
         	train.mark(0);
        	train.mark(2);
        	train.mark(3);
        	train.mark(4);
        }
	}
	
	class Button3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
         	train.mark(0);
        	train.mark(1);
        	train.mark(3);
        	train.mark(4);

        }
	}
	
	class Button4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
         	train.mark(0);
        	train.mark(1);
        	train.mark(2);
        	train.mark(4);

        }
	}
	
	class Button5Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
           	train.mark(0);
        	train.mark(1);
        	train.mark(2);
        	train.mark(3);

        }
	}
	
	@Override
	public void update(Observable o, Object arg) {
		  
	}
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = Toolkit.getDefaultToolkit().createImage("background.png");
            g.drawImage(background, 0, 0, this);
    }
}
