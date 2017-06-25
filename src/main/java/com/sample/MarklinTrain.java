package com.sample;

<<<<<<< HEAD
import java.util.Observable;

public class MarklinTrain extends Observable implements Constants{
	boolean componentes[];
=======
public class MarklinTrain implements Constants{
	Integer componentes[];
>>>>>>> origin/master
	
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
}
