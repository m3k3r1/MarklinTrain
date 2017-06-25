package com.sample;

import java.util.Observable;

public class MarklinTrain extends Observable implements Constants{
	Integer componentes[];
	int nModel;
	
	int group[][] = {{0,1,2,3},
			{4,5,6,7,8,9,10},
			{11,12,13,14,15,16,17,18},
			{19,20,21,22,23,24},
			{25,26,27,28,29,30,31,32} 
			};

	public MarklinTrain(){
		componentes = new Integer[TRAIN_COMPONENTS_SIZE];
		initializeComponents();
	}
	
	private void initializeComponents(){
		for(int i = 0; i < TRAIN_COMPONENTS_SIZE; i++ )
			componentes[i] = -1;
	}
	
	public int getComponente(int index){
		return componentes[index];
	}
	
	public void setComponente(int index, int value){
		componentes[index] = value;
	}
	
	public void mark(int index){
		
	}
}
