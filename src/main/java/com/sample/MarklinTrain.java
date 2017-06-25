package com.sample;

import java.util.Observable;

public class MarklinTrain extends Observable implements Constants{
	boolean componentes[];
	
	public MarklinTrain(){
		componentes = new boolean[TRAIN_COMPONENTS_SIZE];
		initializeComponents();
	}
	
	private void initializeComponents(){
		for(int i = 0; i < TRAIN_COMPONENTS_SIZE; i++ )
			componentes[i] = false;
	}
	
	public boolean getComponente(int index){
		return componentes[index];
	}
	
	public void setComponente(int index, boolean value){
		componentes[index] = value;
	}
}
