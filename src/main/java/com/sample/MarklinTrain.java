package com.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class MarklinTrain implements Constants{
	Integer componentes[];
	int nModel;
	
	HashMap<Integer,List<Integer>> groups;
	
	public MarklinTrain(){
		componentes = new Integer[TRAIN_COMPONENTS_SIZE];
		groups = new HashMap<Integer, List<Integer>>();
		initializeComponents();
		initializeGroups();
	}
	
	private void initializeComponents(){
		for(int i = 0; i < TRAIN_COMPONENTS_SIZE; i++ )
			componentes[i] = -1;
	}
	private void initializeGroups(){
		groups.put(0,  Arrays.asList(0,1,2,3));
		groups.put(1,  Arrays.asList(4,5,6,7,8,9,10));
		groups.put(2,  Arrays.asList(11,12,13,14,15,16,17,18));
		groups.put(3,  Arrays.asList(19,20,21,22,23,24));
		groups.put(4,  Arrays.asList(25,26,27,28,29,30,31,32));
	}
	
	public int getComponente(int index){
		return componentes[index];
	}
	
	public void setComponente(int index, int value){
		componentes[index] = value;
	}
	
	public void mark(int index){
		int c = 0;
		
		System.out.println("" + groups.get(index).size());
		
		for(int i = 0; i < groups.get(index).size() - 1; i++){
			c = groups.get(index).get(i);
			componentes[c] = 0;
		}
		
	}
}
