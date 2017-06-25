package com.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MarklinTrain implements Constants{
	Integer componentes[];
	String fix[];
	int nModel;
	
	HashMap<Integer,List<Integer>> groups;
	
	public MarklinTrain(){
		componentes = new Integer[TRAIN_COMPONENTS_SIZE];
		groups = new HashMap<Integer, List<Integer>>();
		fix = new String[TRAIN_COMPONENTS_SIZE + 1];
		
		initializeComponents();
		initializeGroups();
		initializeFix();
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
	private void initializeFix(){
		fix[0] = FIX_0;
		fix[1] = FIX_1;
		fix[2] = FIX_2;
		fix[3] = FIX_3;
		fix[4] = FIX_4;
		fix[5] = FIX_5;
		fix[6] = FIX_6;
		fix[7] = FIX_7;
		fix[8] = FIX_8;
		fix[9] = FIX_9;
		fix[10] = FIX_10;
		fix[11] = FIX_11;
		fix[12] = FIX_12;
		fix[13] = FIX_13;
		fix[14] = FIX_14;
		fix[15] = FIX_15;
		fix[16] = FIX_16;
		fix[17] = FIX_17;
		fix[18] = FIX_18;
		fix[19] = FIX_19;
		fix[20] = FIX_20;
		fix[21] = FIX_21;
		fix[22] = FIX_22;
		fix[23] = FIX_23;
		fix[24] = FIX_24;
		fix[25] = FIX_25;
		fix[26] = FIX_26;
		fix[27] = FIX_27;
		fix[28] = FIX_28;
		fix[29] = FIX_29;
		fix[30] = FIX_30;
		fix[31] = FIX_31;
		fix[32] = FIX_32;
}
	
	public String getFix(int index){
		return fix[index];
	}
	public int getComponente(int index){
		return componentes[index];
	}
	
	public void setComponente(int index, int value){
		componentes[index] = value;
	}
	
	public void mark(int index){
		int c = 0;
		
		for(int i = 0; i < groups.get(index).size() - 1; i++){
			c = groups.get(index).get(i);
			componentes[c] = 0;
		}	
	}
	
	public boolean hasProblem(){
		for(int i = 0; i < TRAIN_COMPONENTS_SIZE; i++ ){
			if(componentes[i] == 1)
				return true;
		}
		return false;
	}
	
	public int whereIsTheProblem(){
		for(int i = 0; i < TRAIN_COMPONENTS_SIZE; i++ ){
			if(componentes[i] == 1)
				return i;
		}
		return -1;
	}
	
	public boolean hasAlternatives(){
		for(int i = 0; i < 5; i++){
			for(int o = 0; o < groups.get(i).size() - 1; o++){
				if(componentes[groups.get(i).get(o)] == -1)
					return true;
			}	
		}
		
		return false;
	}
}

