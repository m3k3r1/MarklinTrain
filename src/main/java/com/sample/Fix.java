package com.sample;

public class Fix implements Constants{
	String fix[];
	
	
	public Fix(){
		fix = new String[TRAIN_COMPONENTS_SIZE];
		initializeFix();
	}
	
	private void initializeFix(){
			fix[0] = "ola";
	}
}

